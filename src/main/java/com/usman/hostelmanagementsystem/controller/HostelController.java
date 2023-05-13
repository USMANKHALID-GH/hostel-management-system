package com.usman.hostelmanagementsystem.controller;

import com.usman.hostelmanagementsystem.dto.HostelDto;
import com.usman.hostelmanagementsystem.dto.ResponseDto;
import com.usman.hostelmanagementsystem.mapper.HostelMapper;
import com.usman.hostelmanagementsystem.service.HostelService;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/hostel/")
public class HostelController {

    private  final HostelService service;
    private  final HostelMapper mapper;

    @PostMapping("/")
    public ResponseEntity<ResponseDto> saveHostel(@RequestBody HostelDto dto){
        service.saveHostel(mapper.toEntity(dto));
        return ResponseEntity.ok(ResponseDto.builder().message("Hostel saved").build());
    }


    @GetMapping("/{id}")
    public ResponseEntity<HostelDto> getHostelById(@PathVariable long id){
        return ResponseEntity.ok(mapper.toDto(service.findById(id)));
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<Page<HostelDto>> getHostelByCity(@PathVariable String city, Pageable pageable){
        return ResponseEntity.ok(new PageImpl<>(mapper.toDto(service.getAllHostelBycity(city,pageable).getContent())));
    }
    @GetMapping("/gender/{gender}")
    public ResponseEntity<Page<HostelDto>> getHostelByGender(@PathVariable String gender, Pageable pageable){
        return ResponseEntity.ok(new PageImpl<>(mapper.toDto(service.getByGender(gender,pageable).getContent())));
    }

}
