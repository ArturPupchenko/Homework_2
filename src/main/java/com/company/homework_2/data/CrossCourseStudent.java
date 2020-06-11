package com.company.homework_2.data;

public class CrossCourseStudent extends AbstractData<CrossCourseStudent>{
    private Course course;
    private Student student;

    public Course getCourse(){
        return course;
    }

    public void setCourse(Course course){
        this.course = course;
    }

    public Student getStudent(){
        return student;
    }

    public void setStudent(Student student){
        this.student = student;
    }
}
