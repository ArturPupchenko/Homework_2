package com.company.homework_2.service.impl;

import com.company.homework_2.data.Course;
import com.company.homework_2.data.Student;
import com.company.homework_2.data.CrossCourseStudent;
import com.company.homework_2.repository.CrossCourseStudentRepository;
import com.company.homework_2.repository.impl.CrossCourseStudentRepositoryImpl;
import com.company.homework_2.service.CrossCourseStudentService;

import java.util.List;

public class CrossCourseStudentServiceImpl implements CrossCourseStudentService {
    private final CrossCourseStudentRepository crossCourseStudentRepository = new CrossCourseStudentRepositoryImpl();

    @Override
    public List<Course> findAllCoursesByStudentName(String student) {
        return crossCourseStudentRepository.findAllCoursesByStudentName(student);
    }

    @Override
    public List<Student> findAllStudentsByCourseName(String courseName) {
        return crossCourseStudentRepository.findAllStudentsByCourseName(courseName);
    }

    @Override
    public List<Course> findCoursesByStudentId(Long id) {
        return crossCourseStudentRepository.findCoursesByStudentId(id);
    }

    @Override
    public List<Student> findStudentsByCourseId(Long id) {
        return crossCourseStudentRepository.findStudentsByCourseId(id);
    }

    @Override
    public void saveOrUpdate(CrossCourseStudent crossCourseStudent) {
        if (crossCourseStudent.getId() == null) {
            long id = findAll().size();
            crossCourseStudent.setId(++id);
            crossCourseStudentRepository.save(crossCourseStudent);
        } else {
            crossCourseStudentRepository.update(crossCourseStudent);
        }
    }

    @Override
    public CrossCourseStudent findById(Long id) {
        return crossCourseStudentRepository.findById(id);
    }

    @Override
    public List<CrossCourseStudent> findAll() {
        return crossCourseStudentRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        crossCourseStudentRepository.remove(id);
    }
}