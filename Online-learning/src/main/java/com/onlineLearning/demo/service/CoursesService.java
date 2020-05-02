package com.onlineLearning.demo.service;

import javax.servlet.http.HttpServletRequest;

import com.onlineLearning.demo.model.Courses;

public interface CoursesService {

	Courses findCourse(Integer course_id, HttpServletRequest request);

}
