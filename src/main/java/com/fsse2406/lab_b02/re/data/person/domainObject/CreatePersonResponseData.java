package com.fsse2406.lab_b02.re.data.person.domainObject;

import com.fsse2406.lab_b02.re.data.person.entity.PersonEntity;

public class CreatePersonResponseData {
    private String firstName;
    private String lastName;
    private String hkid;

    public CreatePersonResponseData(PersonEntity entity){
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.hkid = entity.getHkid();
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
