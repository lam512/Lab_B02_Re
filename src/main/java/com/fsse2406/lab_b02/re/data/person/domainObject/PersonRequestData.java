package com.fsse2406.lab_b02.re.data.person.domainObject;

import com.fsse2406.lab_b02.re.data.person.dto.request.PersonRequestDto;

public class PersonRequestData {
        private String firstName;
        private String lastName;
        private String hkid;

        public PersonRequestData(PersonRequestDto dto){
            this.firstName = dto.getFirstName();
            this.lastName = dto.getLastName();
            this.hkid = dto.getHkid();
        }

    public String getFirstName() {
        return firstName;
    }

    public String getHkid() {
        return hkid;
    }

    public String getLastName() {
        return lastName;
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
