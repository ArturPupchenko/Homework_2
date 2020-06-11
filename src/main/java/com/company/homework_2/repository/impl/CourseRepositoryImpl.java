package com.company.homework_2.repository.impl;

import com.company.homework_2.data.Course;
import com.company.homework_2.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepository {

    private final List<Course> coursesList = new ArrayList<>();

    @Override
    public Course findByName(String name) {
        for (Course course: coursesList) {
            if (course.getName().equals(name))
                return course;
        }

        return null;
    }

    @Override
    public void save(Course course) {
        coursesList.add(course);
    }

    @Override
    public Course findById(Long id) {
        for (Course course: coursesList) {
            if (course.getId().equals(id))
                return course;
        }

        return null;
    }

    @Override
    public List<Course> findAll() {
        return coursesList;
    }

    @Override
    public void update(Course course) {
        for (Course currentCourse: coursesList)
        {
            if (course.getId().equals(currentCourse.getId())) {
                currentCourse.setName(course.getName());
            }
        }
    }

    @Override
    public void remove(Long id) {

        for (int i = 0; i < coursesList.size(); i++) {
            if (coursesList.get(i).getId().equals(id)) {
                coursesList.remove(i);
                return;
            }
        }
    }
}
