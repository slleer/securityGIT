package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private long id;
    private String name;
    private String year;

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.year = student.getYear();
    }
}
