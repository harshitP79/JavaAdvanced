package com.example.SpringMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringMVC.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Long>{
		
}
