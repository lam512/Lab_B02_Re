package com.fsse2406.lab_b02.re.exception.person;

import com.fsse2406.lab_b02.re.data.person.domainObject.PersonResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PersonNotFoundException extends RuntimeException{
    public PersonNotFoundException(String hkid){
        super ("Person Not Found:" + hkid);
    }
}