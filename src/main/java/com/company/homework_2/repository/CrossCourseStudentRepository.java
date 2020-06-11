package com.company.homework_2.repository;

import com.company.homework_2.data.*;
import com.company.homework_2.data.CrossCourseStudent;

import java.util.List;

public interface CrossCourseStudentRepository extends AbstractRepository<CrossCourseStudent> {

    List<Course> findAllCoursesByStudentName(String student);
    List<Student> findAllStudentsByCourseName(String courseName);
    List<Course> findCoursesByStudentId(Long id);
    List<Student> findStudentsByCourseId(Long id);
}