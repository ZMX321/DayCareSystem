/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.model;

/**
 *
 * @author Congcong
 */
public abstract class Member extends Model {

    private String first_name;
    private String last_name;
    private String classroom_id;
    private String password;

    public Member() {
    }

   

	public Member(String classroom_id, String firstName, String lastName, String password) {
		super();
		this.first_name = firstName;
		this.last_name = lastName;
		this.classroom_id = classroom_id;
		this.password = password;
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



	public String getClassroom_id() {
		return classroom_id;
	}



	public void setClassroom_id(String classroom_id) {
		this.classroom_id = classroom_id;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return first_name + "," + last_name + "," + password;
	}
    
    
}
