package com.groupeisi.crudStudent.service;

import com.groupeisi.crudStudent.dao.IStudentRepository;
import com.groupeisi.crudStudent.dto.StudentDTO;
import com.groupeisi.crudStudent.entities.Student;
import com.groupeisi.crudStudent.mapping.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private IStudentRepository studentRepository;

    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(StudentMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    public StudentDTO getStudentById(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.map(StudentMapper.INSTANCE::toDto).orElse(null);
    }

    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = StudentMapper.INSTANCE.toEntity(studentDTO);
        student = studentRepository.save(student);
        return StudentMapper.INSTANCE.toDto(student);
    }

    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            // Mise à jour des attributs de l'étudiant
            student.setName(studentDTO.getName());
            student.setAge(studentDTO.getAge());
            student.setEmail(studentDTO.getEmail());
            student = studentRepository.save(student);
            return StudentMapper.INSTANCE.toDto(student);
        }
        return null;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
