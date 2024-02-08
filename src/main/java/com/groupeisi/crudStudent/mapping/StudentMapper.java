package com.groupeisi.crudStudent.mapping;

import com.groupeisi.crudStudent.dto.StudentDTO;
import com.groupeisi.crudStudent.entities.Student;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.Mapping;
import org.mapstruct.Mapper;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
//    @Mapping(target = "id", ignore = true)
    Student toEntity(StudentDTO studentDTO);
    StudentDTO toDto(Student student);
}
