/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.model;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Congcong
 */
public class Classroom extends Model {

    private String name;
	private Integer maxSize;
	private Integer maxAge;
    private Integer minAge;
    private Integer teachersSize;
	private List<Student> studentList;
	private List<Teacher> teacherList;

    public Classroom() {
    	
    }
    public Classroom(String name, Integer maxAge, Integer minAge, Integer maxSize, Integer teachersSize) {
        studentList = new ArrayList<>();
        teacherList = new ArrayList<>();
        this.name = name;
        this.maxSize = maxSize;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.teachersSize = teachersSize;
    }

    public Integer getTeachersSize() {
        return teachersSize;
    }

    public void setTeachersSize(Integer teachersSize) {
        this.teachersSize = teachersSize;
    }
    
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }



    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }
    public boolean isAvailableClassRoom(){
        if(maxSize == studentList.size()){
            return false;
        }
        return true;
    }
}
