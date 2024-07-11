package com.fsse2406.lab_b02.re.data.course.dto.response;

import com.fsse2406.lab_b02.re.data.course.domainObject.response.GetAllCourseResponseData;
import com.fsse2406.lab_b02.re.data.person.domainObject.PersonResponseData;
import com.fsse2406.lab_b02.re.data.person.dto.response.PersonResponseDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GetAllCourseResponseDto {
    private String courseId;
    private String courseName;
    private BigDecimal price;
    private PersonResponseDto teacher;
    private List<PersonResponseData> students = new ArrayList<>();

    public GetAllCourseResponseDto(GetAllCourseResponseData data){
        this.courseId = data.getCourseId();
        this.courseName = data.getCourseName();
        this.price = data.getPrice();
        this.teacher = new PersonResponseDto(data.getTeacher());
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

    public PersonResponseDto getTeacher() {
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

    public void setTeacher(PersonResponseDto teacher) {
        this.teacher = teacher;
    }

    public void setStudents(List<PersonResponseData> students) {
        this.students = students;
    }
}
