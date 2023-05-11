package com.usman.hostelmanagementsystem.mapper;

import com.usman.hostelmanagementsystem.dto.RegisterDto;
import com.usman.hostelmanagementsystem.model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegisterMapper extends BaseMapper<RegisterDto, Student> {
    Student toEntity(RegisterDto dto);
    RegisterDto toDto(Student entity);
}
