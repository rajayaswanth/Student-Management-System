package com.sms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.entities.ExamResult;

@Repository
public interface ExamResultRepository extends JpaRepository<ExamResult, Integer> {

}
