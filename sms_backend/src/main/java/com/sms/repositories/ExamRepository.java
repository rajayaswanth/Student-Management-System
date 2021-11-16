package com.sms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.entities.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {

}
