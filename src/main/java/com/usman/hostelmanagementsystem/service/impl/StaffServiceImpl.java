package com.usman.hostelmanagementsystem.service.impl;


import com.usman.hostelmanagementsystem.dto.ResponseDto;
import com.usman.hostelmanagementsystem.exception.BusinessException;
import com.usman.hostelmanagementsystem.model.*;
import com.usman.hostelmanagementsystem.repository.RoomRepository;
import com.usman.hostelmanagementsystem.repository.StaffRepository;
import com.usman.hostelmanagementsystem.repository.StudentRepository;
import com.usman.hostelmanagementsystem.service.BedService;
import com.usman.hostelmanagementsystem.service.RoomService;
import com.usman.hostelmanagementsystem.service.StaffService;
import com.usman.hostelmanagementsystem.service.StudentService;
import lombok.AllArgsConstructor;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.math.BigInteger;
import java.time.LocalDate;


@Service
@AllArgsConstructor
public class StaffServiceImpl  implements StaffService {
    @Autowired
    private final StaffRepository staffRepository;
    @Autowired
    private final RoomService roomService;
    @Autowired
    private  final StudentService studentService;
    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private final RoomRepository roomRepository;
    @Autowired
    private final BedService bedService;

    @Override
    public void registerStaff(Staff staff) {


        if(ObjectUtils.isEmpty(staff.getFirstName())){
            throw  new BusinessException(HttpStatus.FORBIDDEN, "FIRST NAME MUST BE PROVIDED");
        }
        if(ObjectUtils.isEmpty(staff.getSurname())){
            throw  new BusinessException(HttpStatus.FORBIDDEN, "SURNAME NAME MUST BE PROVIDED");
        }
        if(ObjectUtils.isEmpty(staff.getIdentityNumber())){
            throw  new BusinessException(HttpStatus.FORBIDDEN, "TC MUST BE PROVIDED");
        }
        if(ObjectUtils.isEmpty(staff.getEmail())){
            throw  new BusinessException(HttpStatus.FORBIDDEN, "EMAIL NAME MUST BE PROVIDED");
        }
        if(ObjectUtils.isEmpty(staff.getTelefon())){
            throw  new BusinessException(HttpStatus.FORBIDDEN, "TEFLON MUST BE PROVIDED");
        }
        if(ObjectUtils.isEmpty(staff.getGender())){
            throw  new BusinessException(HttpStatus.FORBIDDEN, "GENDER MUST BE PROVIDED");
        }
        if(ObjectUtils.isEmpty(staff.getQualificaation())){
            throw  new BusinessException(HttpStatus.FORBIDDEN, "QUALIFICATION NAME MUST BE PROVIDED");
        }
        


        staffRepository.save(staff);
    }

    @Override
    public void approveStudent(long studentId,long bedId) {
        Bed bed = bedService.findBedBYId(bedId);
        Room room=bed.getRoom();
        if(!room.isReady()){
            throw new BusinessException(HttpStatus.FORBIDDEN,"ROOM IS NOT READY YET");
        }
        if(room.getRoomCapacity()>4){
            throw new BusinessException(HttpStatus.FORBIDDEN,"ROOM IS FULL ");
        }
        Student student= studentService.findStudentById(studentId);
        if(room.getHostel().isMixed()|| (room.getHostel().getGender().equalsIgnoreCase(student.getGender()))){
            String studentHostelId=generateId(studentId,room.getHostel());
            room.setRoomCapacity(room.getRoomCapacity()+1);
            bed.setOccupied(true);
            student.setBedNumber(bed.getBedNumber());
            student.setActive(true);
            student.setRoom(room);
            student.setBed(bed);
            student.setHostelId(studentHostelId);
            roomRepository.save(room);
            studentRepository.save(student);
        }
        else {
           throw  new BusinessException(HttpStatus.NOT_FOUND,"CANT BE APPROVED DIFFERENT GENDER");
        }



    }


    @Override
    public void updateStaff(Staff staff,long id) {
        Staff oldStaff=getStaffById(id);

        if(!ObjectUtils.isEmpty(staff.getFirstName())){
          oldStaff.setFirstName(staff.getFirstName());
        }
        if(!ObjectUtils.isEmpty(staff.getSurname())){
           oldStaff.setSurname(staff.getSurname());
        }
        if(!ObjectUtils.isEmpty(staff.getIdentityNumber())) {
            oldStaff.setIdentityNumber(staff.getIdentityNumber());
        }
        if(!ObjectUtils.isEmpty(staff.getEmail())){
            oldStaff.setEmail(staff.getEmail());

        }
        if(!ObjectUtils.isEmpty(staff.getTelefon())){
        oldStaff.setTelefon(staff.getTelefon());
        }
        if(!ObjectUtils.isEmpty(staff.getGender())){
            oldStaff.setGender(staff.getGender());

        }
        if(!ObjectUtils.isEmpty(staff.getQualificaation())){
         oldStaff.setQualificaation(staff.getQualificaation());
        }



        staffRepository.save(oldStaff);

    }

    @Override
    public Page<Staff> getAllStaff(Pageable pageable) {
        return staffRepository.findAll(pageable);
    }

    @Override
    public void deleteStaff(long id) {
        Staff staff=getStaffById(id);
        staffRepository.delete(staff);

    }

    @Override
    public void changePosition(long id) {

    }

    @Override
    public Staff getByEmailOrTc(String email, BigInteger tc) {
        return staffRepository.findStaffByEmailOrIdentityNumber(email, tc)
                .orElseThrow(()->new BusinessException(HttpStatus.NOT_FOUND,"STAFF CANT BE FOUND BY EMAIL OR TC "));
    }

    @Override
    public Staff getStaffById(long id) {
        return staffRepository.findById(id)
                .orElseThrow(()->new BusinessException(HttpStatus.NOT_FOUND,"STAFF ID IS NOT IN OUR SYSTEM "+id));
    }


    private  String generateId(long studentId,  Hostel hostel){
        String id="";
        int year=LocalDate.now().getYear();
        Student student=studentService.findStudentById(studentId);
        id+=year+student.getFirstName().charAt(0)+student.getSurname().charAt(0)+hostel.getName().substring(0,2)+studentId;
        return id;
    }
}
