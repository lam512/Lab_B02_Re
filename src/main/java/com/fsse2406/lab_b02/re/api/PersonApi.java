package com.fsse2406.lab_b02.re.api;

import com.fsse2406.lab_b02.re.data.person.domainObject.*;
import com.fsse2406.lab_b02.re.data.person.dto.request.CreatPersonRequestDto;
import com.fsse2406.lab_b02.re.data.person.dto.request.PersonRequestDto;
import com.fsse2406.lab_b02.re.data.person.dto.response.CreatPersonResponseDto;
import com.fsse2406.lab_b02.re.data.person.dto.response.GetAllPeopleResponseDto;
import com.fsse2406.lab_b02.re.data.person.dto.response.PersonResponseDto;
import com.fsse2406.lab_b02.re.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonApi {

    private final PersonService personService;

    @Autowired
    public PersonApi(PersonService personService){
        this.personService = personService;
    }

    @PostMapping("/person")
    public CreatPersonResponseDto createPerson (@RequestBody CreatPersonRequestDto creatPersonRequestDto){
        CreatePersonRequestData createPersonRequestData = new CreatePersonRequestData(creatPersonRequestDto);
        CreatePersonResponseData createPersonResponseData = personService.createPerson(createPersonRequestData);
        CreatPersonResponseDto creatPersonResponseDto = new CreatPersonResponseDto(createPersonResponseData);
        return creatPersonResponseDto;
    }

    @GetMapping("/person")
    public List<GetAllPeopleResponseDto> getAllPeople(){
        List<GetAllPeopleResponseData> getAllPeopleResponseDataList = personService.getAllPeople();

        List<GetAllPeopleResponseDto> getAllPeopleResponseDtoList = new ArrayList<>();
        for (GetAllPeopleResponseData getAllPeopleResponseData : getAllPeopleResponseDataList){
            GetAllPeopleResponseDto getAllPeopleResponseDto = new GetAllPeopleResponseDto(getAllPeopleResponseData);
            getAllPeopleResponseDtoList.add(getAllPeopleResponseDto);
        }
        return getAllPeopleResponseDtoList;
    }

    @PutMapping("/person")
    public PersonResponseDto updatePerson(@RequestBody PersonRequestDto personRequestDto){
        PersonRequestData personRequestData = new PersonRequestData(personRequestDto);
        PersonResponseData personResponseData = personService.updatePerson(personRequestData);
        PersonResponseDto personResponseDto = new PersonResponseDto (personResponseData);
        return personResponseDto;
    }

    @DeleteMapping("/person")
    public PersonResponseDto deletePerson (@RequestParam String hkid){
        PersonResponseData personResponseData = personService.deletePerson(hkid);
        PersonResponseDto personResponseDto = new PersonResponseDto(personResponseData);
        return personResponseDto;
    }

    @GetMapping("/person/{lastName}")
    public List<PersonResponseDto> getByLastName(@PathVariable String lastName){
        List<PersonResponseData> result = personService.getByLastName(lastName);

        List<PersonResponseDto> personResponseDtoList = new ArrayList<>();
        for (PersonResponseData personResponseData : result){
            PersonResponseDto personResponseDto = new PersonResponseDto(personResponseData);
            personResponseDtoList.add(personResponseDto);
        }
        return personResponseDtoList;
    }
}
