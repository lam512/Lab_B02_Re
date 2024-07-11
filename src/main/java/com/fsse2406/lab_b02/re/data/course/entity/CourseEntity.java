package com.fsse2406.lab_b02.re.data.course.entity;

import com.fsse2406.lab_b02.re.data.course.domainObject.request.CreateCourseRequestData;
import com.fsse2406.lab_b02.re.data.person.entity.PersonEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CourseEntity {
    private String courseId;
    private String courseName;
    private BigDecimal price;
    private PersonEntity teacher;
    private List<PersonEntity> students = new ArrayList<>();

    public CourseEntity(CreateCourseRequestData data, PersonEntity teacher){
        this.courseId = data.getCourseId();
        this.courseName = data.getCourseName();
        this.price = data.getPrice();
        this.teacher = teacher;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public PersonEntity getTeacher() {
        return teacher;
    }

    public List<PersonEntity> getStudents() {
        return students;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setTeacher(PersonEntity teacher) {
        this.teacher = teacher;
    }

    public void setStudents(List<PersonEntity> students) {
        this.students = students;
    }
}
