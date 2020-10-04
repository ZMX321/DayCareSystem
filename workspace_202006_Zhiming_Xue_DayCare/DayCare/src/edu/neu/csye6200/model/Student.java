/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.model;

import java.util.Date;

/**
 *
 * @author Congcong
 */
public class Student extends Member {
	
	private String first_name;
	private String last_name;
	private String id;
	private String teacher_id;
	private String classroom_id;
	private String teacher_name;
    private String age;
    private String father_name;
    private String mother_name;
//    private String MMR1;
//    private String MMR2;
//    private String varicella_1;
//    private String varicella_2;
    
    private String Hib;
    private String DTaP;
    private String Polio;
    private String Hepatitis_B;
    private String MMR;
    private String Varicella;
    
    
	
    public Student(){
        
    }
    
    
//	public Student(String first_name, String last_name, String id,  String classroom_id,
//			String teacher_name, String teacher_id,String age, String father_name, String mother_name, String mMR1, String mMR2,
//			String varicella_1, String varicella_2) {
//		super();
//		this.first_name = first_name;
//		this.last_name = last_name;
//		this.id = id;
//		this.teacher_id = teacher_id;
//		this.classroom_id = classroom_id;
//		this.teacher_name = teacher_name;
//		this.age = age;
//		this.father_name = father_name;
//		this.mother_name = mother_name;
////		MMR1 = mMR1;
////		MMR2 = mMR2;
////		this.varicella_1 = varicella_1;
////		this.varicella_2 = varicella_2;
//		
//	}
    
    public Student(String first_name, String last_name, String id, String teacher_id, String classroom_id,
    		String teacher_name, String age, String father_name, String mother_name, String hib, String dTaP, String polio,
    		String hepatitis_B, String mMR, String varicella) {
    		super();
    		this.first_name = first_name;
    		this.last_name = last_name;
    		this.id = id;
    		this.teacher_id = teacher_id;
    		this.classroom_id = classroom_id;
    		this.teacher_name = teacher_name;
    		this.age = age;
    		this.father_name = father_name;
    		this.mother_name = mother_name;
    		Hib = hib;
    		DTaP = dTaP;
    		Polio = polio;
    		Hepatitis_B = hepatitis_B;
    		MMR = mMR;
    		Varicella = varicella;
    }
    
    
    


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTeacher_id() {
		return teacher_id;
	}


	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}


	public String getClassroom_id() {
		return classroom_id;
	}


	public void setClassroom_id(String classroom_id) {
		this.classroom_id = classroom_id;
	}


	public String getTeacher_name() {
		return teacher_name;
	}


	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getFather_name() {
		return father_name;
	}


	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}


	public String getMother_name() {
		return mother_name;
	}


	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}


	public String getHib() {
		return Hib;
	}


	public void setHib(String hib) {
		Hib = hib;
	}


	public String getDTaP() {
		return DTaP;
	}


	public void setDTaP(String dTaP) {
		DTaP = dTaP;
	}


	public String getPolio() {
		return Polio;
	}


	public void setPolio(String polio) {
		Polio = polio;
	}


	public String getHepatitis_B() {
		return Hepatitis_B;
	}


	public void setHepatitis_B(String hepatitis_B) {
		Hepatitis_B = hepatitis_B;
	}


	public String getMMR() {
		return MMR;
	}


	public void setMMR(String mMR) {
		MMR = mMR;
	}


	public String getVaricella() {
		return Varicella;
	}


	public void setVaricella(String varicella) {
		Varicella = varicella;
	}


	@Override
	public String toString() {
		return " " + "," + first_name + "," + last_name + "," + id + "," 
	+ classroom_id + "," + teacher_name + "," + teacher_id + "," + age + "," 
				+ father_name + "," + mother_name + "," + Hib + "," + DTaP + "," + Polio +
				"," + Hepatitis_B + "," +  MMR + "," + Varicella;
	}


	
	
    
}
