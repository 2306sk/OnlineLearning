package com.onlineLearning.demo.service;

import java.util.Locale;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineLearning.demo.model.Courses;
import com.onlineLearning.demo.repository.CoursesRepository;

@Service
public class CoursesServiceImpl implements CoursesService {

	@Autowired
	CoursesRepository coursesRepository;

	@Override
	public Courses findCourse(Integer course_id, HttpServletRequest request) {
		Courses courses = coursesRepository.findByCourseId(course_id);
		// From here we can return prices in Rs or in $ according to user's country
		// or if user currently loggedIn then we can fetch details from user details
		// table and get country code and then we can return aprropriate price
		Locale currentLocale = request.getLocale();
		if (!(currentLocale == null)) {
			System.out.println(currentLocale.getCountry());
			System.out.println(currentLocale.getDisplayCountry());
		}
		return courses;
	}
}
