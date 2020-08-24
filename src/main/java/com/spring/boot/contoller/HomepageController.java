package com.spring.boot.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.domain.Student;
import com.spring.boot.service.StudentService;

@RestController
@RequestMapping("/")
public class HomepageController {

	@Autowired
	StudentService studentService;
	
	@GetMapping("api/students")
	public List<Student> retrieveAllStudents() {
		System.out.println("homepage retrivestudents  ");
		return studentService.retrieveStudents();
	}
}
