package com.usman.hostelmanagementsystem.mapper;


import com.usman.hostelmanagementsystem.dto.StudentDto;
import com.usman.hostelmanagementsystem.model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper extends BaseMapper<StudentDto, Student > {
    Student toEntity(StudentDto dto);
    StudentDto toDto(Student entity);
}
