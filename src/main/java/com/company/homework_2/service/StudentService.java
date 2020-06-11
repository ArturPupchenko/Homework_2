package com.company.homework_2.service;

import com.company.homework_2.data.Student;

public interface StudentService extends AbstractService<Student> {

    Student findByName(String name);
}
