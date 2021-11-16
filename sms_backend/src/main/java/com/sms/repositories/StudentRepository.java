package com.sms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
