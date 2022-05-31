package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.domain.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    StudentDTO getStudentById(Long id);
    List<StudentDTO> getAllStudents();
    StudentDTO insertStudent(Student student);
    StudentDTO getStudentByName(String name);
}
