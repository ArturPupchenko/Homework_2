package com.company.homework_2.service.impl;

import com.company.homework_2.data.Student;
import com.company.homework_2.repository.StudentRepository;
import com.company.homework_2.repository.impl.StudentRepositoryImpl;
import com.company.homework_2.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository = new StudentRepositoryImpl();

    @Override
    public Student findByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public void saveOrUpdate(Student student) {
        if (student.getId() == null) {
            for(Student i: studentRepository.findAll()) {
                if (i.getName().equals(student.getName()))
                {
                    student.setId(i.getId());
                    return;
                }
            }
            long id = findAll().size();
            student.setId(++id);
            studentRepository.save(student);
        } else {
            studentRepository.update(student);
        }
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        studentRepository.remove(id);
    }
}