package com.onlineLearning.demo.serviceTest;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.onlineLearning.demo.model.Courses;
import com.onlineLearning.demo.repository.CoursesRepository;
import com.onlineLearning.demo.service.CoursesServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CoursesServiceTest {

	@Mock
	CoursesRepository coursesRepository;

	@InjectMocks
	CoursesServiceImpl coursesServiceImpl;
	
	@Mock
	HttpServletRequest request;

	@Test
	public void findCourseTest() {
		Courses courses = new Courses();
		Integer course_id = null;
		when(coursesRepository.findByCourseId(course_id)).thenReturn(courses);
		Courses coursesData = coursesServiceImpl.findCourse(course_id, request);
		assertNotNull(coursesData);

	}
}
