package com.company.homework_2.repository.impl;

import com.company.homework_2.data.Student;
import com.company.homework_2.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private final List<Student> studentsList = new ArrayList<>();

    @Override
    public Student findByName(String name) {
        for (Student student: studentsList) {
            if (student.getName().equals(name))
                return student;
        }

        return null;
    }

    @Override
    public void save(Student student) {
        studentsList.add(student);
    }

    @Override
    public Student findById(Long id) {
        for (Student student: studentsList) {
            if (student.getId().equals(id))
                return student;
        }

        return null;
    }

    @Override
    public List<Student> findAll() {
        return studentsList;
    }

    @Override
    public void update(Student student) {
        for (Student currentStudent: studentsList)
        {
            if (student.getId().equals(currentStudent.getId())) {
                currentStudent.setName(student.getName());
            }
        }
    }

    @Override
    public void remove(Long id) {

        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getId().equals(id)) {
                studentsList.remove(i);
                return;
            }
        }
    }
}
