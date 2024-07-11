package com.fsse2406.lab_b02.re.exception.person;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CreatPersonRequestDataInvaidException extends RuntimeException{
}
