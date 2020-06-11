package com.company.homework_2.service;

import com.company.homework_2.data.Course;

public interface CourseService extends AbstractService<Course> {

    Course findByName(String name);

}
