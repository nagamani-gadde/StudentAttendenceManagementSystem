package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nit.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

	
}
