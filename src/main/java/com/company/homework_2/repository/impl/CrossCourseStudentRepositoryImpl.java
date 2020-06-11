package com.company.homework_2.repository.impl;

import com.company.homework_2.data.Course;
import com.company.homework_2.data.Student;
import com.company.homework_2.data.CrossCourseStudent;
import com.company.homework_2.repository.CrossCourseStudentRepository;

import java.util.ArrayList;
import java.util.List;

public class CrossCourseStudentRepositoryImpl implements CrossCourseStudentRepository {

    private final List<CrossCourseStudent> crossCourseStudentList = new ArrayList<>();

    @Override
    public List<Course> findAllCoursesByStudentName(String student) {
        List<Course> courses = new ArrayList<>();
        for (CrossCourseStudent i : crossCourseStudentList) {
            if (i.getStudent().getName().equals(student)) {
                courses.add(i.getCourse());
            }
        }
        return courses;
    }

    @Override
    public List<Student> findAllStudentsByCourseName(String courseName) {
        List<Student> students = new ArrayList<>();
        for (CrossCourseStudent i : crossCourseStudentList) {
            if (i.getCourse().getName().equals(courseName)) {
                students.add(i.getStudent());
            }
        }
        return students;
    }

    @Override
    public List<Course> findCoursesByStudentId(Long id) {
        List<Course> courses = new ArrayList<>();
        for (CrossCourseStudent i : crossCourseStudentList) {
            if (i.getStudent().getId().equals(id)) {
                courses.add(i.getCourse());
            }
        }
        return courses;
    }

    @Override
    public List<Student> findStudentsByCourseId(Long id) {
        List<Student> students = new ArrayList<>();
        for (CrossCourseStudent i : crossCourseStudentList) {
            if (i.getCourse().getId().equals(id)) {
                students.add(i.getStudent());
            }
        }
        return students;
    }

    @Override
    public void save(CrossCourseStudent crossCourseStudent) {
        crossCourseStudentList.add(crossCourseStudent);
    }

    @Override
    public CrossCourseStudent findById(Long id) {
        for (CrossCourseStudent i : crossCourseStudentList) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public List<CrossCourseStudent> findAll() {
        return crossCourseStudentList;
    }

    @Override
    public void update(CrossCourseStudent crossCourseStudent) {
        for (CrossCourseStudent i: crossCourseStudentList)
        {
            if (i.getId().equals(i.getId())) {
                i.setCourse(crossCourseStudent.getCourse());
                i.setStudent(crossCourseStudent.getStudent());
            }
        }
    }

    @Override
    public void remove(Long id) {
        for (int i = 0; i < crossCourseStudentList.size(); i++) {
            if (crossCourseStudentList.get(i).getId().equals(id)) {
                crossCourseStudentList.remove(i);
                return;
            }
        }
    }
}
