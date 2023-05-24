package com.usman.hostelmanagementsystem.service.impl;

import com.usman.hostelmanagementsystem.exception.BusinessException;
import com.usman.hostelmanagementsystem.model.Hostel;
import com.usman.hostelmanagementsystem.repository.HostelRepository;
import com.usman.hostelmanagementsystem.service.HostelService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Slf4j
@Service
@AllArgsConstructor
public class HostelServiceImpl  implements HostelService {
    @Autowired
    private final HostelRepository hostelRepository;

    @Override
    public void saveHostel(@Valid  Hostel hostel) {

        if(ObjectUtils.isEmpty(hostel.getGender())){
            throw  new BusinessException(HttpStatus.FORBIDDEN, "Hostel Type  MUST BE PROVIVED");
        }
        if(ObjectUtils.isEmpty(hostel.getName())){
            throw  new BusinessException(HttpStatus.FORBIDDEN, "Hostel NAME MUST BE PROVIVED");
        }
        if(ObjectUtils.isEmpty(hostel.isMixed())){
            throw  new BusinessException(HttpStatus.FORBIDDEN, "Is mixed  MUST BE indicated");
        }

        hostelRepository.save(hostel);
    }

    @Override
    public Page<Hostel> getAllHostelBycity(String city, Pageable pageable) {
        return hostelRepository.getHostelByCityName(city,pageable);
    }

    @Override
    public Page<Hostel> getAllHostel(String name,Pageable pageable) {
        if(ObjectUtils.isEmpty(name)){
        return hostelRepository.findAll(pageable);
    }
    return  hostelRepository.findHostelByNameContainingIgnoreCase(name, pageable);

    }

    @Override
    public Hostel findById(long id) {
        log.info(id+"///////////////////////////////////////////////////////////1");
       return  hostelRepository.findById(id)
               .orElseThrow(()->new BusinessException(HttpStatus.NOT_FOUND,"HOSTEL ID IS NOT IN OUR SYSTEM"+id));
    }

    @Override
    public Page<Hostel> getByGender(String gender, Pageable pageable) {
        return hostelRepository.findHostelByGender(gender,pageable);
    }

    @Override
    public void updateHostel(Hostel hostel, long id) {
        Hostel oldHostel= findById(id);
        if(ObjectUtils.isEmpty(hostel.getGender())){
            oldHostel.setGender(hostel.getGender());
        }
        if(ObjectUtils.isEmpty(hostel.getName())){
            oldHostel.setName(hostel.getName());
        }
        if(ObjectUtils.isEmpty(hostel.isMixed())){
           oldHostel.setMixed(hostel.isMixed());
        }
        if(ObjectUtils.isEmpty(hostel.getAboutHostel())){
            oldHostel.setAboutHostel(hostel.getAboutHostel());
        }
        if(ObjectUtils.isEmpty(hostel.getImage())){
            oldHostel.setImage(hostel.getImage());
        }

        hostelRepository.save(oldHostel);
    }
}
