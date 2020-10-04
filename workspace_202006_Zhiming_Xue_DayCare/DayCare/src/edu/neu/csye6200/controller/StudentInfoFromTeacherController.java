package edu.neu.csye6200.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import edu.neu.csye6200.data.StudentData;
import edu.neu.csye6200.display.StudentInfoFromTeacher;
import edu.neu.csye6200.display.StudentsManagement;
import edu.neu.csye6200.model.Student;

public class StudentInfoFromTeacherController {
	
	private Map<String,String> student = null;
	//get instance
	private StudentInfoFromTeacher studentInfoFromTeacher;
	private static StudentInfoFromTeacherController instance;
	
	private StudentInfoFromTeacherController(StudentInfoFromTeacher studentInfoFromTeacher) {
		this.studentInfoFromTeacher = studentInfoFromTeacher;
		InitStudentInfoFromTeacher();
		update();
	}

	public static StudentInfoFromTeacherController getInstance(StudentInfoFromTeacher studentInfoFromTeacher) {
		instance = new StudentInfoFromTeacherController(studentInfoFromTeacher);
		return instance;
	}

	public void InitStudentInfoFromTeacher() {
		try {
    		//back
        	this.studentInfoFromTeacher.getBack().addMouseListener(new MouseAdapter() {
        		public void mouseClicked(MouseEvent e) {
        			studentInfoFromTeacher.setVisible(false);
        			java.awt.EventQueue.invokeLater(new Runnable() {
        	            public void run() {
        	                StudentsManagement studentsManagement = new StudentsManagement();
        	                StudentsManagementController.getInstance(studentsManagement);
        	                studentsManagement.setLocationRelativeTo(null);
        	                studentsManagement.setVisible(true);
        	            }
        	        });
        		}
    		});
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
	}
	public void update() {
		this.studentInfoFromTeacher.getRenewal().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					Integer.parseInt(studentInfoFromTeacher.getSID().getText());
				} catch (NumberFormatException e1) {
					
					JOptionPane.showMessageDialog(null, "Please enter Integer in ID", "Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}
				int id = Integer.parseInt(studentInfoFromTeacher.getSID().getText());
				try {
					Integer.parseInt(studentInfoFromTeacher.getSAge().getText());
				} catch (NumberFormatException e1) {
					
					JOptionPane.showMessageDialog(null, "Please type Integer in Age", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				int age = Integer.parseInt(studentInfoFromTeacher.getSAge().getText());
				System.out.println("id:" + id + "age:" + age);
				String fname = studentInfoFromTeacher.getSFather().getText();
				String mname = studentInfoFromTeacher.getSMother().getText();
				StudentData studentdata = new StudentData();
				Map<String,String> studentMap = studentdata.getDataList(id);
				System.out.println(studentMap);
				studentMap.put("age", String.valueOf(age));
				studentMap.put("father_name", fname);
				studentMap.put("mother_name", mname);
				
				Student stu = new Student();
				
				stu.setFirst_name(studentMap.get("first_name"));
				stu.setLast_name(studentMap.get("last_name"));
				stu.setId(studentMap.get("id"));
				stu.setClassroom_id(studentMap.get("classroom_id"));
				stu.setTeacher_name(studentMap.get("teacher_name"));
				stu.setTeacher_id(studentMap.get("teacher_id"));
				stu.setAge(studentMap.get("age"));
				stu.setFather_name(studentMap.get("father_name"));
				stu.setMother_name(studentMap.get("mother_name"));
				stu.setHib(studentMap.get("Hib"));
				stu.setDTaP(studentMap.get("DTaP"));
				stu.setPolio(studentMap.get("Polio"));
				stu.setHepatitis_B(studentMap.get("Hepatitis B"));
				stu.setMMR(studentMap.get("MMR"));
				stu.setVaricella(studentMap.get("Varicella"));
				studentdata.upDataList(stu);
				
				JOptionPane.showMessageDialog(null, "Thanks for your update!");
			}
		});
	}

}
