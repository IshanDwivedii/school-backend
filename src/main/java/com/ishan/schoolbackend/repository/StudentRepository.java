package com.ishan.schoolbackend.repository;

import com.ishan.schoolbackend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByNameContainingIgnoreCase(String name);

    List<Student> findByParentName(String parentName);

    @Query("SELECT s FROM Student s JOIN s.classRooms c WHERE c.id = :classRoomId")
    List<Student> findByClassRoomId(@Param("classRoomId") Long classRoomId);

    @Query("SELECT COUNT(s) FROM Student s JOIN s.classRooms c WHERE c.id = :classRoomId")
    Long countStudentsByClassRoomId(@Param("classRoomId") Long classRoomId);
}
