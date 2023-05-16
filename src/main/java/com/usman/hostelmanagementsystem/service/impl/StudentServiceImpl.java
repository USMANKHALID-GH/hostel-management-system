package com.usman.hostelmanagementsystem.service.impl;


import com.usman.hostelmanagementsystem.exception.BusinessException;
import com.usman.hostelmanagementsystem.model.Bed;
import com.usman.hostelmanagementsystem.model.Parent;
import com.usman.hostelmanagementsystem.model.Room;
import com.usman.hostelmanagementsystem.model.Student;
import com.usman.hostelmanagementsystem.repository.BedRepository;
import com.usman.hostelmanagementsystem.repository.ParentRepository;
import com.usman.hostelmanagementsystem.repository.RoomRepository;
import com.usman.hostelmanagementsystem.repository.StudentRepository;
import com.usman.hostelmanagementsystem.service.BedService;
import com.usman.hostelmanagementsystem.service.RoomService;
import com.usman.hostelmanagementsystem.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


import java.time.LocalDate;
import java.time.Period;



@Slf4j
@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ParentRepository parentRepository;
    private  final RoomRepository roomRepository;
    private final BedRepository bedRepository;
    private final RoomService roomService;
    private final BedService bedService;


    @Override
    public void register(@Valid Student register) {
        LocalDate now = LocalDate.now();
        Period  period = Period.between(register.getDateOfBirth(),now);

        if(period.getYears()<16){
            throw  new BusinessException(HttpStatus.FORBIDDEN, "YOU MUST BE ABOVE 16  TO REGISTER: "+period.getYears());
        }

        if(ObjectUtils.isEmpty(register.getFirstName())){
            throw  new BusinessException(HttpStatus.FORBIDDEN, "FIRST NAME MUST BE PROVIDED");
        }
        if(ObjectUtils.isEmpty(register.getSurname())){
            throw  new BusinessException(HttpStatus.FORBIDDEN, "SURNAME NAME MUST BE PROVIDED");
        }
        if(ObjectUtils.isEmpty(register.getTc())){
            throw  new BusinessException(HttpStatus.FORBIDDEN, "TC MUST BE PROVIDED");
        }
        if(ObjectUtils.isEmpty(register.getStudentNumber())){
            throw  new BusinessException(HttpStatus.FORBIDDEN, "Student NAME MUST BE PROVIDED");
        }
        if(ObjectUtils.isEmpty(register.getTelefon())){
            throw  new BusinessException(HttpStatus.FORBIDDEN, "TEFLON MUST BE PROVIDED");
        }
        if(ObjectUtils.isEmpty(register.getGender())){
            throw  new BusinessException(HttpStatus.FORBIDDEN, "GENDER MUST BE PROVIDED");
        }
        if(ObjectUtils.isEmpty(register.getDepartment())){
            throw  new BusinessException(HttpStatus.FORBIDDEN, "FIRST NAME MUST BE PROVIDED");
        }


      studentRepository.save(register);
    }

    @Override
    public Student getStudentByEmailORTc(String email,String tc) {
        return studentRepository.findStudentByEmailOrTc(email,tc)
                .orElseThrow(()-> new BusinessException("THERE IS NO SUCH EMAIL OR TC IN OUR SYSTEM"));
    }

    @Override
    public Student findStudentById(long id) {
        return studentRepository.findById(id)
                .orElseThrow(()->new BusinessException(HttpStatus.NOT_FOUND,"STUDENT ID IS NOT IN OUR SYSTEM "+id));
    }

    @Override
    public void updateStudent(Student student,long id) {
        Student oldStudent= findStudentById(id);
        if(!ObjectUtils.isEmpty(student.getFirstName())){
           oldStudent.setFirstName(student.getFirstName());
        }
        if(!ObjectUtils.isEmpty(student.getSurname())){
          oldStudent.setSurname(student.getSurname());
        }
        if(!ObjectUtils.isEmpty(student.getTc())){
           oldStudent.setTc(student.getTc());
        }
        if(!ObjectUtils.isEmpty(student.getStudentNumber())){
            oldStudent.setStudentNumber(student.getStudentNumber());
        }
        if(!ObjectUtils.isEmpty(student.getTelefon())){
           oldStudent.setTelefon(student.getTelefon());
        }
        if(!ObjectUtils.isEmpty(student.getGender())){
            oldStudent.setGender(student.getGender());
        }
        if(!ObjectUtils.isEmpty(student.getDepartment())){
            oldStudent.setDepartment(student.getDepartment());
        }
      studentRepository.save(oldStudent);


    }

    @Override
    public void deleteStudent(long id) {
        Student student=findStudentById(id);
        Room room=student.getRoom();
        room.setRoomCapacity(room.getRoomCapacity()-1);
        Bed bed =student.getBed();
        bed.setOccupied(false);
        bedRepository.save(bed);
        roomRepository.save(room);
        studentRepository.delete(student);

    }

    @Override
    public void deactivateStudent(long id) {
        Student student= findStudentById(id);
        student.setActive(false);
        studentRepository.save(student);

    }

    @Override
    public Page<Student> getAllStudent(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public void changeRoom(long studentId, long roomId, long bedNumber) {
        Student student=findStudentById(studentId);
        Room room=roomService.findById(roomId);
        Bed bed= bedService.findBedBYId(bedNumber);
        if(bed.isOccupied()){
            throw  new BusinessException("BED IS OCCUPIED CHOOSE NEW BED");
        }
        Room oldRoom=student.getRoom();
        oldRoom.setRoomCapacity(oldRoom.getRoomCapacity()-1);
        Bed oldBed=student.getBed();
        oldBed.setOccupied(false);
        bedRepository.save(oldBed);
        roomRepository.save(oldRoom);

        bed.setOccupied(true);
        room.setRoomCapacity(room.getRoomCapacity()+1);
        student.setRoom(room);
        student.setBed(bed);
        bedRepository.save(bed);
        roomRepository.save(room);
        studentRepository.save(student);


    }

    @Override
    public Student findStudentByParent(String email, String tc) {
        Parent parent= parentRepository.findParentByEmailOrIdentityNumber(email, tc)
                .orElseThrow(()->new BusinessException(HttpStatus.NOT_FOUND,"THERE IS NO SUCH PARENTT IN OUR SYSTEM "));
        return  studentRepository.findStudentByParent(parent)
                .orElseThrow(()->new BusinessException(HttpStatus.NOT_FOUND,"CONT FIND STUDENT ASSOCIATED WITH  THIS PARENTT "));
    }

    @Override
    public void makeStudentQuest(long id) {
        Student student=findStudentById(id);
        student.setGuest(true);
        studentRepository.save(student);
    }
}
