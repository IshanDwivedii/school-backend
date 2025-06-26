package com.ishan.schoolbackend.repository;

import com.ishan.schoolbackend.model.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    List<Teacher> findByNameContainingIgnoreCase(String name);

    List<Teacher> findByQualification(String qualification);

    @Query("SELECT t FROM Teacher t JOIN t.classRooms c WHERE c.id = :classRoomId")
    List<Teacher> findByClassRoomId(@Param("classRoomId") Long classRoomId);
}