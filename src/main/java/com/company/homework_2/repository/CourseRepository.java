package com.company.homework_2.repository;

import com.company.homework_2.data.Course;

public interface CourseRepository extends AbstractRepository<Course> {

    Course findByName(String fullName);
}
