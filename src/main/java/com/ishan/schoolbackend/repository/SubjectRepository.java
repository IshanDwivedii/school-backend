package com.ishan.schoolbackend.repository;
import com.ishan.schoolbackend.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    List<Subject> findByNameContainingIgnoreCase(String name);
}
