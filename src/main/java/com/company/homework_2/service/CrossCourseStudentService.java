package com.company.homework_2.service;

import com.company.homework_2.data.Course;
import com.company.homework_2.data.Student;
import com.company.homework_2.data.CrossCourseStudent;

import java.util.List;

public interface CrossCourseStudentService extends AbstractService<CrossCourseStudent> {

    List<Course> findAllCoursesByStudentName(String student);

    List<Student> findAllStudentsByCourseName(String courseName);

    List<Course> findCoursesByStudentId(Long id);

    List<Student> findStudentsByCourseId(Long id);
}