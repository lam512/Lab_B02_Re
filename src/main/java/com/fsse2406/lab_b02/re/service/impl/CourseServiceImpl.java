package com.fsse2406.lab_b02.re.service.impl;

import com.fsse2406.lab_b02.re.data.course.domainObject.request.CreateCourseRequestData;
import com.fsse2406.lab_b02.re.data.course.domainObject.response.CourseResponseData;
import com.fsse2406.lab_b02.re.data.course.domainObject.response.GetAllCourseResponseData;
import com.fsse2406.lab_b02.re.data.course.entity.CourseEntity;
import com.fsse2406.lab_b02.re.data.person.entity.PersonEntity;
import com.fsse2406.lab_b02.re.exception.course.*;
import com.fsse2406.lab_b02.re.service.CourseService;
import com.fsse2406.lab_b02.re.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private List<CourseEntity> courseEntityList = new ArrayList<>();

    Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

    private final PersonService personService;

    public CourseServiceImpl(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public CourseResponseData createCourse(CreateCourseRequestData createCourseRequestData) {
        try {
            if (isCourseExist(createCourseRequestData.getCourseId())) {
                throw new CourseExistException(createCourseRequestData.getCourseId());
            }

            PersonEntity teacherentity = personService.getByHkid(createCourseRequestData.getTeacherHkid());

            CourseEntity courseEntity = new CourseEntity(createCourseRequestData, teacherentity);
            courseEntityList.add(courseEntity);
            CourseResponseData courseResponseData = new CourseResponseData(courseEntity);
            return courseResponseData;

        } catch (Exception ex) {
            logger.warn("Create Course:" + ex.getMessage());
            throw ex;
        }
    }

    @Override
    public List<GetAllCourseResponseData> getAllCourse(){
        List<GetAllCourseResponseData> getAllCourseResponseDataList = new ArrayList<>();

        for (CourseEntity courseEntity : courseEntityList){
            GetAllCourseResponseData getAllCourseResponseData =new GetAllCourseResponseData(courseEntity);
            getAllCourseResponseDataList.add(getAllCourseResponseData);
        }
        return getAllCourseResponseDataList;
    }

    @Override
    public CourseResponseData updateCourse(CreateCourseRequestData createCourseRequestData) {
        try {
            CourseEntity courseEntity = getByCourseId(createCourseRequestData.getCourseId());
            PersonEntity teacherentity = personService.getByHkid(createCourseRequestData.getTeacherHkid());
            courseEntity.setCourseName(createCourseRequestData.getCourseName());
            courseEntity.setPrice(createCourseRequestData.getPrice());
            courseEntity.setTeacher(teacherentity);
            CourseResponseData courseResponseData = new CourseResponseData(courseEntity);
            return courseResponseData;
        }catch(Exception ex) {
            logger.warn("Update Course: " + ex.getMessage());
            throw ex;
        }
    }

    @Override
    public CourseResponseData deleteCourse(String courseId){
        try{
            CourseEntity entity = getByCourseId(courseId);
            courseEntityList.remove(entity);
            return new CourseResponseData(entity);

        }catch(Exception ex){
            logger.warn("Delete Course:" + ex.getMessage());
            throw ex;
        }
    }

    @Override
    public CourseResponseData addStudent(String courseId, String hkId){
        try{
            CourseEntity courseEntity = getByCourseId(courseId);
            PersonEntity studentEntity = personService.getByHkid(hkId);

            if (courseEntity.getTeacher().getHkid().equals(hkId)){
                throw new StudentIsTeacherException(hkId);
            }

            List<PersonEntity> studentEntityList = courseEntity.getStudents();
            for (PersonEntity entity : studentEntityList){
                if (entity.getHkid().equals(hkId)){
                    throw new StudentExistedException(hkId);
                }
            }
            studentEntityList.add(studentEntity);
            CourseResponseData courseResponseData = new CourseResponseData(courseEntity);
            return courseResponseData;

        }catch(Exception ex){
            logger.warn("Add Student:" + ex.getMessage());
            throw ex;
        }
    }

    @Override
    public CourseResponseData deleteStudent(String courseId, String hkId){
        try {
            CourseEntity courseEntity = getByCourseId(courseId);

            for (PersonEntity studentEntity : courseEntity.getStudents()) {
                if (!studentEntity.getHkid().equals(hkId)) {
                    continue;
                }
                courseEntity.getStudents().remove(studentEntity);
                return new CourseResponseData(courseEntity);
            }
            throw new StudentNotFoundException(hkId);

        } catch (Exception ex) {
            logger.warn("Delete Student: " + ex.getMessage());
            throw ex;
        }
    }

    public boolean isCourseExist(String courseId) {
        for (CourseEntity courseEntity : courseEntityList) {
            if (courseEntity.getCourseId().equals(courseId)) {
                return true;
            }
        }
        return false;
    }

    public CourseEntity getByCourseId(String courseId) {
        for (CourseEntity entity : courseEntityList) {
            if (!entity.getCourseId().equals(courseId)) {
                continue;
            }
            return entity;
        }
        throw new CourseNotFoundException(courseId);
    }
}
