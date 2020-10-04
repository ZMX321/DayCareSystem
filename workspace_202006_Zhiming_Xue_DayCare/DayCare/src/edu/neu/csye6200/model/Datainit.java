/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author wangguojun
 */
public class Datainit {
    private static Datainit datainit;
    private List<Rules> rules;
    private List<Classroom> classrooms;
    private Map<String, Integer> immuniRules;

    private Datainit(){
        rulesAdd();
        classroomAdd();
    }

    private void rulesAdd(){
        rules = new ArrayList<>();
        rules.add(new Rules(6,12,4,"4:1",3));
        rules.add(new Rules(13,24,5,"5:1",3));
        rules.add(new Rules(25,35,6,"6:1",3));
        rules.add(new Rules(36,47,8,"8:1",3));
        rules.add(new Rules(48,59,12,"12:1",2));
        rules.add(new Rules(60,Integer.MAX_VALUE,15,"15:1",2));  
    }
    private void classroomAdd(){
        classrooms = new ArrayList<>();
        classrooms.add(new Classroom("Class 1",12,6,12,3));
        classrooms.add(new Classroom("Class 2",24,13,15,3));
        classrooms.add(new Classroom("Class 3",35,25,18,3));
        classrooms.add(new Classroom("Class 4",47,36,24,3));
        classrooms.add(new Classroom("Class 5",59,48,24,2));
        classrooms.add(new Classroom("Class 6",Integer.MAX_VALUE,60,30,2)); 
    }
    
    public void ImmunizationRules () {
  	  immuniRules = new HashMap<>();
  	  immuniRules.put("MMR", 240);
  	  immuniRules.put("Varicella", 60);
  	  immuniRules.put("DTaP", 180);
  	  immuniRules.put("Hepatitis B", 360);
  	  immuniRules.put("Polio", 80);
  	  immuniRules.put("Hib", 120);
  }
    public static Datainit getInstance() {
	if(datainit == null)
            datainit = new Datainit();
        return datainit;
    }
    public List<Rules> getRules() {
        return rules;
    }

    public void setRules(List<Rules> rules) {
        this.rules = rules;
    }

    public List<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }
    public Map<String, Integer> getImmuniRules() {
		return immuniRules;
	}

	public void setImmuniRules(Map<String, Integer> immuniRules) {
		this.immuniRules = immuniRules;
	}
}
