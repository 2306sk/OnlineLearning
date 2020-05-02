package com.onlineLearning.demo.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.onlineLearning.demo.controller.CoursesController;
import com.onlineLearning.demo.exception.CourseNotFoundException;
import com.onlineLearning.demo.model.Courses;
import com.onlineLearning.demo.service.CoursesService;

@RunWith(MockitoJUnitRunner.class)
public class CoursesControllerTest {

	@Mock
	CoursesService coursesService;

	@InjectMocks
	CoursesController coursesController;

	@Test
	public void getCourseTest() {
		Courses courses = new Courses();
		Integer course_id = 1;
		HttpServletRequest request = null;
		when(coursesService.findCourse(course_id, request)).thenReturn(courses);
		ResponseEntity<?> response = coursesController.getCourse(request, course_id);
		Courses coursesData = (Courses) response.getBody();
		assertEquals(courses, coursesData);
	}

	@Test(expected = CourseNotFoundException.class)
	public void adminRegistrationError() {
		Integer course_id = null;
		HttpServletRequest request = null;
		when(coursesService.findCourse(course_id, request)).thenReturn(null);
		coursesController.getCourse(request, course_id);
	}
}
