package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.domain.StudentDTO;
import com.example.demo.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    private final StudentServiceImpl studentService;

    @Autowired
    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return new ResponseEntity<>(this.studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping(value = "/students", params = "student")
    public ResponseEntity<StudentDTO> insertStudent(@RequestParam Student student) {
        return new ResponseEntity<>(this.studentService.insertStudent(student), HttpStatus.OK);
    }

    @GetMapping(value = "/students", params = "name")
    public ResponseEntity<StudentDTO> getStudentByName(@RequestParam String name) {
        return new ResponseEntity<>(this.studentService.getStudentByName(name), HttpStatus.OK);
    }

    @GetMapping(value = "/students", params = "id")
    public ResponseEntity<StudentDTO> getStudentById(@RequestParam long id) {
        return new ResponseEntity<>(this.studentService.getStudentById(id), HttpStatus.OK);
    }
}
