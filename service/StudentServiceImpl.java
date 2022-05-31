package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.domain.StudentDTO;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public StudentDTO getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return new StudentDTO(student.get());
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(stu -> new StudentDTO(stu)).collect(Collectors.toList());
    }

    @Override
    public StudentDTO insertStudent(Student student) {
        return new StudentDTO(studentRepository.save(student));
    }

    @Override
    public StudentDTO getStudentByName(String name) {
        Student student = studentRepository.findByName(name);
        return new StudentDTO(student);
    }
}
