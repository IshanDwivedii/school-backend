package com.ishan.schoolbackend.repository;

import com.ishan.schoolbackend.model.ClassRoom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {

    List<ClassRoom> findByYear(String year);

    List<ClassRoom> findBySection(String section);

    List<ClassRoom> findByYearAndSection(String year, String section);

    @Query("SELECT c FROM ClassRoom c WHERE c.school.id = :schoolId")
    List<ClassRoom> findBySchoolId(@Param("schoolId") Long schoolId);
}