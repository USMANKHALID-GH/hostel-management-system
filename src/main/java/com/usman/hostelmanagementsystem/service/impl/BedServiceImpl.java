package com.usman.hostelmanagementsystem.service.impl;


import com.usman.hostelmanagementsystem.exception.BusinessException;
import com.usman.hostelmanagementsystem.model.Bed;
import com.usman.hostelmanagementsystem.model.Room;
import com.usman.hostelmanagementsystem.repository.BedRepository;
import com.usman.hostelmanagementsystem.service.BedService;
import com.usman.hostelmanagementsystem.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BedServiceImpl  implements BedService {

    @Autowired
    private  final BedRepository bedRepository;
    @Autowired
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
        bed.setReady(true);
        bed.setRoom(room);
        bedRepository.save(bed);

    }

    @Override
    public Bed findBedBYId(long id) {
        return bedRepository.findById(id)
                .orElseThrow( ()->new BusinessException(HttpStatus.NOT_FOUND,"BED ID IS NOT IN OUR SYSTEM"+id));
    }

    @Override
    public void UpdateBedReady(long id) {
        Bed bed=findBedBYId(id);
        if(bed.isOccupied()){
            throw new BusinessException(HttpStatus.BAD_REQUEST,"BED IS OCCUPIED  CHANGE THE BED USER FIRST :"+id);
        }
        bed.setReady(false);
        bedRepository.save(bed);


    }

    @Override
    public void deleteUpdate(long id) {
        Bed bed= findBedBYId(id);
        if(bed.isOccupied()){
            throw new BusinessException(HttpStatus.BAD_REQUEST,"BED CANT BE DELETED IS OCCUPIED :"+id);
        }
        bedRepository.delete(bed);
    }

    @Override
    public Page<Bed> getAllAlreadyBed(Pageable pageable) {
        List<Bed>  bed= bedRepository.findAll(pageable)
                .stream().filter(s->!!s.isOccupied())
                .filter(s1->s1.isReady())
                .collect(Collectors.toList());
        return new PageImpl<>(bed);
    }


}
