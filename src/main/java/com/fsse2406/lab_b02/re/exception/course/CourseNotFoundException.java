package com.fsse2406.lab_b02.re.exception.course;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CourseNotFoundException extends  RuntimeException{
    public CourseNotFoundException (String courseId){
        super ("Course Not Found" + courseId);
    }
}
