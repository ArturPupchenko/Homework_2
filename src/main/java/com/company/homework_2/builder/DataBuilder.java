package com.company.homework_2.builder;

import com.company.homework_2.config.ApplicationEnvironment;
import com.company.homework_2.data.Course;
import com.company.homework_2.data.Student;
import com.company.homework_2.data.CrossCourseStudent;
import com.company.homework_2.service.CourseService;
import com.company.homework_2.service.StudentService;
import com.company.homework_2.service.CrossCourseStudentService;
import com.company.homework_2.service.impl.StudentServiceImpl;
import com.company.homework_2.service.impl.CourseServiceImpl;
import com.company.homework_2.service.impl.CrossCourseStudentServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DataBuilder implements AbstractBuilder {

    private final CourseService courseService = new CourseServiceImpl();
    private final StudentService studentService = new StudentServiceImpl();
    private final CrossCourseStudentService crossCourseStudentService = new CrossCourseStudentServiceImpl();

    @Override
    public void buildDataList() {

        for (Map.Entry<String, String> entry : getKeyValueMapByBundleProperties(ApplicationEnvironment.getPropertyLang()).entrySet()) {

            Course course = new Course();
            String courseNameProperties = String.join(" ", entry.getKey().split("_"));
            course.setName(courseNameProperties);
            courseService.saveOrUpdate(course);

            if (entry.getValue().contains(";")) {
                List<String> studentNamePropertiesList = Arrays.asList(entry.getValue().split(";"));
                for (String name : studentNamePropertiesList) {
                    Student student = new Student();
                    student.setName(name);

                    CrossCourseStudent crossCourseStudent = new CrossCourseStudent();
                    crossCourseStudent.setCourse(course);
                    crossCourseStudent.setStudent(student);

                    crossCourseStudentService.saveOrUpdate(crossCourseStudent);
                    studentService.saveOrUpdate(student);
                }
            } else {
                Student student = new Student();
                String studentName = entry.getValue();
                student.setName(studentName);

                CrossCourseStudent crossCourseStudent = new CrossCourseStudent();
                crossCourseStudent.setCourse(course);
                crossCourseStudent.setStudent(student);

                crossCourseStudentService.saveOrUpdate(crossCourseStudent);
                studentService.saveOrUpdate(student);
            }
        }
    }

    public CourseService getCourseService() {
        return courseService;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public CrossCourseStudentService getCrossCourseStudentService() {
        return crossCourseStudentService;
    }
}
