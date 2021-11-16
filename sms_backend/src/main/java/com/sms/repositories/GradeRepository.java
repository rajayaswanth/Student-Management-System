package com.sms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.entities.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {

}
