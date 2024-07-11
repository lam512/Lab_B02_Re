package com.fsse2406.lab_b02.re.service.impl;

import com.fsse2406.lab_b02.re.data.person.domainObject.*;
import com.fsse2406.lab_b02.re.data.person.entity.PersonEntity;
import com.fsse2406.lab_b02.re.exception.person.CreatPersonRequestDataInvaidException;
import com.fsse2406.lab_b02.re.exception.person.PersonExistedException;
import com.fsse2406.lab_b02.re.exception.person.PersonNotFoundException;
import com.fsse2406.lab_b02.re.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);
    private List<PersonEntity> personEntityList = new ArrayList<>();

    @Override
    public CreatePersonResponseData createPerson(CreatePersonRequestData createPersonRequestData) {
        try {
            if (createPersonRequestData.getFirstName() == null
                    || createPersonRequestData.getLastName() == null
                    || createPersonRequestData.getHkid() == null) {

                throw new CreatPersonRequestDataInvaidException();
            }

            if (isExistByHkid(createPersonRequestData.getHkid())) {
                throw new PersonExistedException(createPersonRequestData.getHkid());
            }

            PersonEntity personEntity = new PersonEntity(createPersonRequestData);
            personEntityList.add(personEntity);
            CreatePersonResponseData createPersonResponseData = new CreatePersonResponseData(personEntity);
            return createPersonResponseData;
        } catch (PersonExistedException ex) {
            logger.warn("Create Person: " + ex.getMessage());
            throw ex;
        }
    }

    @Override
    public List<GetAllPeopleResponseData> getAllPeople() {
        List<GetAllPeopleResponseData> getAllPeopleResponseDataList = new ArrayList<>();

        for (PersonEntity personEntity : personEntityList) {
            GetAllPeopleResponseData getAllPeopleResponseData = new GetAllPeopleResponseData(personEntity);
            getAllPeopleResponseDataList.add(getAllPeopleResponseData);
        }
        return getAllPeopleResponseDataList;
    }

    @Override
    public PersonResponseData updatePerson(PersonRequestData personRequestData) {
        try {
            PersonEntity personEntity = getByHkid(personRequestData.getHkid());
            personEntity.setFirstName(personRequestData.getFirstName());
            personEntity.setLastName(personRequestData.getLastName());
            PersonResponseData personResponseData = new PersonResponseData(personEntity);
            return personResponseData;

        } catch (Exception ex) {
            logger.warn("Update Person: " + ex.getMessage());
            throw ex;
        }
    }

    @Override
    public PersonResponseData deletePerson(String hkid){
        try {
            PersonEntity personEntity = getByHkid(hkid);
            personEntityList.remove(personEntity);
            return new PersonResponseData(personEntity);
        }catch(Exception ex){
            logger.warn("Delete Person:" + ex.getMessage());
            throw ex;
        }
    }

    @Override
    public List<PersonResponseData> getByLastName(String lastName){
        List<PersonResponseData> result = new ArrayList<>();

        for(PersonEntity personEntity :personEntityList){
            if (personEntity.getLastName().equals(lastName)){
                PersonResponseData personResponseData = new PersonResponseData(personEntity);
                result.add(personResponseData);
            }
        }
        return result;
    }


    public boolean isExistByHkid (String hkid){
        for (PersonEntity personEntity : personEntityList){
            if (personEntity.getHkid().equals (hkid)){
                return true;
            }
        }
        return false;
    }

    @Override
    public PersonEntity getByHkid(String hkid){
        for (PersonEntity entity : personEntityList) {
            if (!entity.getHkid().equals (hkid)){
            continue;
            }
            return entity;
        }
        throw new PersonNotFoundException(hkid);
    }
}
