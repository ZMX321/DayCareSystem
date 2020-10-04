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
public class Teacher extends Member {
	private String id;
    public Teacher() {
    }

    public Teacher(String id, String firstName, String lastName, String classroom_id, String password) {
        super(classroom_id, firstName, lastName, password);
        this.id = id;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return super.toString() + "," + id;
	}
    
	
    
}
