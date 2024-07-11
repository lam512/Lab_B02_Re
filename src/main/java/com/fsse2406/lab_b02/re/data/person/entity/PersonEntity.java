package com.fsse2406.lab_b02.re.data.person.entity;

import com.fsse2406.lab_b02.re.data.person.domainObject.CreatePersonRequestData;

public class PersonEntity {
    private String firstName;
    private String lastName;
    private String hkid;

    public PersonEntity(CreatePersonRequestData data){
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
