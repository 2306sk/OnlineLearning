package com.onlineLearning.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.onlineLearning.demo.model.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Integer>{

	@Query(value = "SELECT * from courses c  where c.course_id = ?1", nativeQuery = true)
	Courses findByCourseId(Integer course_id);

}
