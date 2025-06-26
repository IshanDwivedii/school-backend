package com.ishan.schoolbackend.repository;
import com.ishan.schoolbackend.model.Progress;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {

    List<Progress> findByStudentId(Long studentId);

    List<Progress> findByClassRoomId(Long classRoomId);

    @Query("SELECT p FROM Progress p WHERE p.student.id = :studentId AND p.classRoom.id = :classRoomId")
    List<Progress> findByStudentIdAndClassRoomId(@Param("studentId") Long studentId, @Param("classRoomId") Long classRoomId);

    @Query("SELECT AVG(p.marks) FROM Progress p WHERE p.student.id = :studentId")
    Double findAverageMarksByStudentId(@Param("studentId") Long studentId);
}