package com.usman.hostelmanagementsystem.mapper;

import com.usman.hostelmanagementsystem.dto.StaffDto;
import com.usman.hostelmanagementsystem.model.Staff;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StaffMapper extends BaseMapper<StaffDto, Staff> {


    public Staff toEntity(StaffDto dto) ;


    public StaffDto toDto(Staff entity) ;



    public List<Staff> toEntity(List<StaffDto> dtoList) ;




    public List<StaffDto> toDto(List<Staff> entityList) ;

}
