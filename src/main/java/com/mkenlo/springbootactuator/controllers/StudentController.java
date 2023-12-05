package com.mkenlo.springbootactuator.controllers;

import com.mkenlo.springbootactuator.models.Student;
import com.mkenlo.springbootactuator.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @GetMapping("/student")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/student/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

}
