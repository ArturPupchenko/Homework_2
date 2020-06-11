package com.company.homework_2.repository;

import com.company.homework_2.data.Student;

public interface StudentRepository extends AbstractRepository<Student> {

    Student findByName(String studentName);
}
