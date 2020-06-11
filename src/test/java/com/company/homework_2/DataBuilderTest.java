package com.company.homework_2;

import com.company.homework_2.builder.DataBuilder;
import com.company.homework_2.config.ApplicationEnvironment;
import com.company.homework_2.service.CourseService;
import com.company.homework_2.service.StudentService;
import com.company.homework_2.service.CrossCourseStudentService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DataBuilderTest {

    @BeforeAll
    public static void setEnv() {
        ApplicationEnvironment.setPropertyLang("en");
    }

    @Test
    public void build() {

        DataBuilder dataBuilder = new DataBuilder();
        CourseService courseService = dataBuilder.getCourseService();
        StudentService studentService = dataBuilder.getStudentService();
        CrossCourseStudentService crossCourseStudentService = dataBuilder.getCrossCourseStudentService();
        dataBuilder.buildDataList();

        assertEquals(5, courseService.findAll().size());
        assertEquals(studentService.findAll().size(), 8);
        assertEquals(courseService.findByName("Psychology").getName(), "Psychology");
        assertEquals("Miller", studentService.findByName("Miller").getName());
        assertEquals("Geography", courseService.findById(1L).getName());
        assertEquals(3, crossCourseStudentService.findStudentsByCourseId(1L).size());
        assertEquals("Sidorov", studentService.findById(2L).getName());
        assertEquals(1, crossCourseStudentService.findCoursesByStudentId(3L).size());
        assertEquals(3, crossCourseStudentService.findAllCoursesByStudentName("Miller").size());
        assertEquals(3, crossCourseStudentService.findAllStudentsByCourseName("Geography").size());


        courseService.remove(3L);
        assertNull(courseService.findById(3L));
        assertEquals(4, courseService.findAll().size());

        studentService.remove(4L);
        assertNull(studentService.findById(4L));
        assertEquals(7, studentService.findAll().size());

        crossCourseStudentService.remove(5L);
        assertNull(studentService.findById(0L));
    }
}
