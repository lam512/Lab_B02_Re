package com.fsse2406.lab_b02.re.service;

import com.fsse2406.lab_b02.re.data.person.domainObject.*;
import com.fsse2406.lab_b02.re.data.person.entity.PersonEntity;

import java.util.List;

public interface PersonService {
    CreatePersonResponseData createPerson(CreatePersonRequestData createPersonRequestData);
    List<GetAllPeopleResponseData> getAllPeople();

    PersonResponseData updatePerson (PersonRequestData personRequestData);

    PersonResponseData deletePerson(String hkid);

    List<PersonResponseData> getByLastName(String lastName);

    PersonEntity getByHkid(String hkid);
}
