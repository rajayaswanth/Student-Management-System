package com.sms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.entities.ExamType;

@Repository
public interface ExamtypeRepository extends JpaRepository<ExamType, Integer> {

}
