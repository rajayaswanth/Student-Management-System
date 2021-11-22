package com.sms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.entities.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Integer> {
	
	Parent findByUserId(Long id);

}
