package com.usman.hostelmanagementsystem.mapper;

import com.usman.hostelmanagementsystem.dto.BedDto;
import com.usman.hostelmanagementsystem.model.Bed;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BedMapper extends  BaseMapper<BedDto,Bed> {
    Bed toEntity(BedDto dto);
    BedDto toDto(Bed entity);
}
