package com.nit.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.Attendance;
import com.nit.entity.Student;
import com.nit.repository.AttendanceRepository;
import com.nit.repository.StudentRepository;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    
    
    @Autowired
    StudentRepository stdRepo;

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return stdRepo.save(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return stdRepo.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return stdRepo.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Student not found"));
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
    	stdRepo.deleteById(id);
        return "Student deleted successfully";
    }

}
