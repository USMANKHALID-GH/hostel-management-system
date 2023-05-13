package com.usman.hostelmanagementsystem.service.impl;


import com.usman.hostelmanagementsystem.exception.BusinessException;
import com.usman.hostelmanagementsystem.model.Bed;
import com.usman.hostelmanagementsystem.model.Room;
import com.usman.hostelmanagementsystem.repository.BedRepository;
import com.usman.hostelmanagementsystem.service.BedService;
import com.usman.hostelmanagementsystem.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BedServiceImpl  implements BedService {

    private  final BedRepository bedRepository;
    private final RoomService roomService;

    @Override
    public void saveBed(Bed bed, long roomId) {
        Room room=roomService.findById(roomId);
        if(!room.isReady()){
            throw new BusinessException(HttpStatus.BAD_REQUEST,"THIs ROOM IS NOT READY :"+roomId);
        }

        if(bed.getBedNumber()<=0 || bed.getBedNumber()>=5){
            throw new BusinessException(HttpStatus.BAD_REQUEST,"BED NUMBER MUST BE BETWEEN 0 AND 5 :"+bed.getBedNumber());
        }
        if(bedRepository.existsBedByBedNumberAndAndRoom_Id(bed.getBedNumber(), roomId)){
            throw new BusinessException(HttpStatus.BAD_REQUEST,"THIS BED IS ALREADY IN THE ROOM :"+bed.getId());
        }
        bed.setRoom(room);
        bedRepository.save(bed);

    }

    @Override
    public Bed findBedBYId(long id) {
        return bedRepository.findById(id)
                .orElseThrow( ()->new BusinessException(HttpStatus.NOT_FOUND,"BED ID IS NOT IN OUR SYSTEM"+id));
    }
}
