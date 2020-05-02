package com.onlineLearning.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlineLearning.demo.exception.CourseNotFoundException;
import com.onlineLearning.demo.model.Courses;
import com.onlineLearning.demo.service.CoursesService;

@RestController
@RequestMapping("course")
public class CoursesController {

	@Autowired
	CoursesService coursesService;

	@GetMapping(value = "/search")
	public ResponseEntity<?> getCourse(HttpServletRequest request,@RequestParam(name = "course_id", required = true) Integer course_id) {
		Courses courses = coursesService.findCourse(course_id,request);
		if (courses == null) {
			throw new CourseNotFoundException();
		}
		return ResponseEntity.ok(courses);
	}

}
