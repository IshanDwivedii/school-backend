package com.ishan.schoolbackend.repository;

import com.ishan.schoolbackend.model.School;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {

    List<School> findByNameContainingIgnoreCase(String name);

    List<School> findByPrincipal(String principal);
}