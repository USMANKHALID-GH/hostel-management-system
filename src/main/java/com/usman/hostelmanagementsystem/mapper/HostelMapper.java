package com.usman.hostelmanagementsystem.mapper;

import com.usman.hostelmanagementsystem.dto.HostelDto;
import com.usman.hostelmanagementsystem.model.Hostel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HostelMapper extends BaseMapper<HostelDto, Hostel>{

    Hostel toEntity(HostelDto dto);
    HostelDto toDto(Hostel entity);
}
