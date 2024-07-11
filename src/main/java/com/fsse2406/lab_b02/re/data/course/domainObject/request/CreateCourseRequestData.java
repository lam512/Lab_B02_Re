package com.fsse2406.lab_b02.re.data.course.domainObject.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2406.lab_b02.re.data.course.dto.request.CreateCourseRequestDto;

import java.math.BigDecimal;

public class CreateCourseRequestData {
    private String courseId;
    private String courseName;
    private BigDecimal price;
    private String teacherHkid;

    public CreateCourseRequestData (CreateCourseRequestDto dto){
        this.courseId = dto.getCourseId();
        this.courseName = dto.getCourseName();
        this.price = dto.getPrice();
        this.teacherHkid = dto.getTeacherHkid();
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

    public String getTeacherHkid() {
        return teacherHkid;
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

    public void setTeacherHkid(String teacherHkid) {
        this.teacherHkid = teacherHkid;
    }
}
