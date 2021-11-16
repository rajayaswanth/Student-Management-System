package com.sms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
