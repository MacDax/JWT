package com.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
