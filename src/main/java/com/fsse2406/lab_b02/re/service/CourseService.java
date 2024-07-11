package com.fsse2406.lab_b02.re.service;

import com.fsse2406.lab_b02.re.data.course.domainObject.request.CreateCourseRequestData;
import com.fsse2406.lab_b02.re.data.course.domainObject.response.CourseResponseData;
import com.fsse2406.lab_b02.re.data.course.domainObject.response.GetAllCourseResponseData;

import java.util.List;

public interface CourseService {

    CourseResponseData createCourse(CreateCourseRequestData createCourseRequestData);

    List<GetAllCourseResponseData> getAllCourse();

    CourseResponseData updateCourse(CreateCourseRequestData createCourseRequestData);

    CourseResponseData deleteCourse(String courseId);

    CourseResponseData addStudent(String courseId, String hkId);

    CourseResponseData deleteStudent(String courseId, String hkId);
}
