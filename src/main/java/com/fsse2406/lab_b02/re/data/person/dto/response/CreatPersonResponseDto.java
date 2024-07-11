package com.fsse2406.lab_b02.re.data.person.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2406.lab_b02.re.data.person.domainObject.CreatePersonResponseData;

public class CreatPersonResponseDto {
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("hkid_number")
    private String hkid;

    public CreatPersonResponseDto (CreatePersonResponseData data){
        this.firstName = data.getFirstName();
        this.lastName = data.getLastName();
        this.hkid = data.getHkid();
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
