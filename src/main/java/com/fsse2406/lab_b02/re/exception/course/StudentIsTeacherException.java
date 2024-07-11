package com.fsse2406.lab_b02.re.exception.course;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StudentIsTeacherException extends RuntimeException{
    public StudentIsTeacherException(String hkId){
        super ("Student is teacher: " + hkId);
    }
}
