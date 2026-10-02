package com.nit.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
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
@RequestMapping("/api/attendance")
public class AttendanceController {

	 

	@Autowired
	AttendanceRepository attendanceRepo;
	
	@Autowired
    StudentRepository studentRepo;

    @PostMapping("/mark/{studentId}")
    public Attendance markAttendance(
            @PathVariable Long studentId,
            @RequestParam String status) {

        if (!status.equalsIgnoreCase("Present")
                && !status.equalsIgnoreCase("Absent")) {
            throw new IllegalArgumentException(
                    "Status must be Present or Absent");
        }

        Student student = studentRepo.findById(studentId)
                .orElseThrow(() ->
                    new RuntimeException("Student not found"));

        Attendance attendance = new Attendance();
        attendance.setStudent(student);
        attendance.setDate(LocalDate.now());
        attendance.setStatus(status);

        return attendanceRepo.save(attendance);
    }

    @GetMapping("/student/{studentId}")
    public List<Attendance> getStudentAttendance(
            @PathVariable Long studentId) {
        return attendanceRepo.findByStudent_Id(studentId);
    }

    @GetMapping("/date/{date}")
    public List<Attendance> getAttendanceByDate(
            @PathVariable String date) {
        return attendanceRepo.findByDate(
                LocalDate.parse(date));
    }
}
