package com.nit.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Attendance;
import com.nit.entity.Student;

public interface AttendanceRepository extends JpaRepository<Attendance,Long>{

	List<Attendance> findByDate(LocalDate date);

    List<Attendance> findByStudent_Id(Long studentId);

	Attendance save(Attendance attendance);
}
