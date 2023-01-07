package com.java.springboot.repository;

import com.java.springboot.model.Wikimedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikimediaRepository extends JpaRepository<Wikimedia, Long> {
}