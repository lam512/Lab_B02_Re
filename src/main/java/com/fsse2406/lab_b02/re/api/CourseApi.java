package com.fsse2406.lab_b02.re.api;

import com.fsse2406.lab_b02.re.data.course.domainObject.request.CreateCourseRequestData;
import com.fsse2406.lab_b02.re.data.course.domainObject.response.GetAllCourseResponseData;
import com.fsse2406.lab_b02.re.data.course.dto.request.CreateCourseRequestDto;
import com.fsse2406.lab_b02.re.data.course.domainObject.response.CourseResponseData;
import com.fsse2406.lab_b02.re.data.course.dto.response.CourseResponseDto;
import com.fsse2406.lab_b02.re.data.course.dto.response.GetAllCourseResponseDto;
import com.fsse2406.lab_b02.re.data.course.entity.CourseEntity;
import com.fsse2406.lab_b02.re.data.person.dto.response.GetAllPeopleResponseDto;
import com.fsse2406.lab_b02.re.service.CourseService;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseApi {
    private final CourseService courseService;

    public CourseApi(CourseService courseService){
        this.courseService = courseService;

    }

    @PostMapping
    public CourseResponseDto createCourse (@RequestBody CreateCourseRequestDto createCourseRequestDto){
        CreateCourseRequestData createCourseRequestData = new CreateCourseRequestData(createCourseRequestDto);
        CourseResponseData courseResponseData =courseService.createCourse(createCourseRequestData);
        CourseResponseDto courseResponseDto = new CourseResponseDto(courseResponseData);
        return courseResponseDto;
    }

    @GetMapping
    public List<GetAllCourseResponseDto> getAllCourse(){
        List<GetAllCourseResponseData> getAllCourseResponseDataList = courseService.getAllCourse();

        List<GetAllCourseResponseDto> getAllCourseResponseDtoList = new ArrayList<>();
        for (GetAllCourseResponseData getAllCourseResponseData: getAllCourseResponseDataList){
            GetAllCourseResponseDto getAllCourseResponseDto = new GetAllCourseResponseDto(getAllCourseResponseData);
            getAllCourseResponseDtoList.add(getAllCourseResponseDto);
        }
        return getAllCourseResponseDtoList;
    }

    @PutMapping
    public CourseResponseDto updateCourse(@RequestBody CreateCourseRequestDto createCourseRequestDto){
        CreateCourseRequestData createCourseRequestData = new CreateCourseRequestData(createCourseRequestDto);
        CourseResponseData courseResponseData = courseService.updateCourse(createCourseRequestData);
        CourseResponseDto courseResponseDto = new CourseResponseDto(courseResponseData);
        return courseResponseDto;
    }

    @DeleteMapping("{courseId}")
    public CourseResponseDto deleteCourse(@PathVariable  String courseId){
        CourseResponseData courseResponseData = courseService.deleteCourse(courseId);
        CourseResponseDto courseResponseDto = new CourseResponseDto(courseResponseData);
        return courseResponseDto;
    }
    @PatchMapping("{courseId}/add-student/{hkId}")
    public CourseResponseDto addStudent (@PathVariable String courseId, @PathVariable String hkId){
        CourseResponseData courseResponseData = courseService.addStudent(courseId, hkId);
        CourseResponseDto courseResponseDto = new CourseResponseDto(courseResponseData);
        return courseResponseDto;
    }
    @PatchMapping("{courseId}/delete-student/{hkId}")
    public CourseResponseDto deleteStudent(@PathVariable String courseId, @PathVariable String hkId){
        CourseResponseData courseResponseData = courseService.deleteStudent(courseId, hkId);
        CourseResponseDto courseResponseDto = new CourseResponseDto(courseResponseData);
        return courseResponseDto;
    }
}
