package com.fsse2406.lab_b02.re.data.course.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;

public class CreateCourseRequestDto {

    @JsonProperty("course_id")
    @NotEmpty
    private String courseId;

    @JsonProperty("course_name")
    private String courseName;

    private BigDecimal price;

    @JsonProperty("teacher_hkid")
    private String teacherHkid;

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
