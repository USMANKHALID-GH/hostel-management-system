package com.usman.hostelmanagementsystem.service.impl;


import com.usman.hostelmanagementsystem.exception.BusinessException;
import com.usman.hostelmanagementsystem.model.Bed;
import com.usman.hostelmanagementsystem.model.Room;
import com.usman.hostelmanagementsystem.model.Staff;
import com.usman.hostelmanagementsystem.model.Student;
import com.usman.hostelmanagementsystem.repository.RoomRepository;
import com.usman.hostelmanagementsystem.repository.StaffRepository;
import com.usman.hostelmanagementsystem.repository.StudentRepository;
import com.usman.hostelmanagementsystem.service.BedService;
import com.usman.hostelmanagementsystem.service.RoomService;
import com.usman.hostelmanagementsystem.service.StaffService;
import com.usman.hostelmanagementsystem.service.StudentService;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StaffServiceImpl  implements StaffService {

    private final StaffRepository staffRepository;
    private final RoomService roomService;
    private  final StudentService studentService;
    private final StudentRepository studentRepository;
    private final RoomRepository roomRepository;
    private final BedService bedService;

    @Override
    public void registerStaff(Staff staff) {
           staffRepository.save(staff);
    }

    @Override
    public void approveStudent(long studentId,long bedId) {
        Bed bed = bedService.findBedBYId(bedId);
        Room room=bed.getRoom();
        if(!room.isReady()){
            throw new BusinessException(HttpStatus.FORBIDDEN,"ROOM IS NOT READY YET");
        }
        if(room.getRoomCapacity()<4){
            throw new BusinessException(HttpStatus.FORBIDDEN,"ROOM IS FULL ");
        }
        Student student= studentService.findStudentById(studentId);
        room.setRoomCapacity(room.getRoomCapacity()+1);
        bed.setOccupied(true);
        student.setBedNumber(bed.getBedNumber());
        student.setActive(true);
        student.setRoom(room);
        roomRepository.save(room);
        studentRepository.save(student);

    }

    @Override
    public void updateStaff(long id) {

    }

    @Override
    public Page<Staff> getAllStaff() {
        return null;
    }

    @Override
    public void deleteStaff(long id) {

    }

    @Override
    public void changePosition(long id) {

    }

    @Override
    public Staff getByEmailOrTc(String email, Integer tc) {
        return null;
    }

    @Override
    public Staff getStaffById(long id) {
        return staffRepository.findById(id)
                .orElseThrow(()->new BusinessException(HttpStatus.NOT_FOUND,"STAFF ID IS NOT IN OUR SYSTEM "+id));
    }
}
