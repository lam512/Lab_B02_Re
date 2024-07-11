package com.fsse2406.lab_b02.re.data.person.domainObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2406.lab_b02.re.data.person.dto.request.CreatPersonRequestDto;

public class CreatePersonRequestData {
    private String firstName;
    private String lastName;
    private String hkid;

    public CreatePersonRequestData (CreatPersonRequestDto dto){
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.hkid = dto.getHkid();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHkid() {
        return hkid;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setHkid(String hkid) {
        this.hkid = hkid;
    }
}
