package com.company.homework_2.service.impl;

import com.company.homework_2.data.Course;
import com.company.homework_2.repository.CourseRepository;
import com.company.homework_2.repository.impl.CourseRepositoryImpl;
import com.company.homework_2.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository = new CourseRepositoryImpl();

    @Override
    public Course findByName(String name) {
        return courseRepository.findByName(name);
    }

    @Override
    public void saveOrUpdate(Course course) {
        if (course.getId() == null) {
            long id = findAll().size();
            course.setId(++id);
            courseRepository.save(course);
        } else {
            courseRepository.update(course);
        }
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        courseRepository.remove(id);
    }
}
