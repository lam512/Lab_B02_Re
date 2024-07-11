package com.fsse2406.lab_b02.re.data.course.domainObject.response;

import com.fsse2406.lab_b02.re.data.course.entity.CourseEntity;
import com.fsse2406.lab_b02.re.data.person.domainObject.PersonResponseData;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GetAllCourseResponseData {
    private String courseId;
    private String courseName;
    private BigDecimal price;
    private PersonResponseData teacher;
    private List<PersonResponseData> students = new ArrayList<>();

    public GetAllCourseResponseData (CourseEntity entity){
        this.courseId = entity.getCourseId();
        this.courseName = entity.getCourseName();
        this.price = entity.getPrice();
        this.teacher = new PersonResponseData(entity.getTeacher());
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

    public PersonResponseData getTeacher() {
        return teacher;
    }

    public List<PersonResponseData> getStudents() {
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

    public void setTeacher(PersonResponseData teacher) {
        this.teacher = teacher;
    }

    public void setStudents(List<PersonResponseData> students) {
        this.students = students;
    }
}


