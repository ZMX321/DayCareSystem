package edu.neu.csye6200.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import edu.neu.csye6200.data.StudentData;
import edu.neu.csye6200.display.StudentInfoFromTeacher;
import edu.neu.csye6200.display.StudentsManagement;
import edu.neu.csye6200.display.TeacherManagement;

public class StudentsManagementController {
	
	
	private StudentsManagement studentsManagement;
	
	private static StudentsManagementController instance;
	private StudentInfoFromTeacherController studentInfoFromTeacherController;
	
	private StudentsManagementController(StudentsManagement studentsManagement) {
		this.studentsManagement = studentsManagement;
		InitStudentsManagement();
	}

	public static void getInstance(StudentsManagement studentsManagement) {
		instance = new StudentsManagementController(studentsManagement);
	}
	
	public void InitStudentsManagement() {
		try {
    		//back
        	this.studentsManagement.getBack().addMouseListener(new MouseAdapter() {
        		public void mouseClicked(MouseEvent e) {
        			studentsManagement.setVisible(false);
        			java.awt.EventQueue.invokeLater(new Runnable() {
        	            public void run() {
        	                TeacherManagement teacherManagement = new TeacherManagement();
        	                TeacherManagementController.getInstance(teacherManagement);
        	                teacherManagement.setLocationRelativeTo(null);
        	                teacherManagement.setVisible(true);
        	            }
        	        });
        		}
    		});
        	
        	//search
        	this.studentsManagement.getSearch().addMouseListener(new MouseAdapter() {
        		public void mouseClicked(MouseEvent e) {
        			int studentID = Integer.parseInt(studentsManagement.getStudentID().getText());
					//System.out.println(studentID);
					StudentData studentData = new StudentData();
					Map<String,String> map = studentData.getDataList(studentID);
					//System.out.println(map);
        			//判断这个studentID是否存在
        			if (map != null) {
					//跳转
	        			studentsManagement.setVisible(false);
	        			java.awt.EventQueue.invokeLater(new Runnable() {
	        	            public void run() {
	        	                StudentInfoFromTeacher studentInfoFromTeacher = new StudentInfoFromTeacher();
	        	                StudentInfoFromTeacherController.getInstance(studentInfoFromTeacher);
	        	                studentInfoFromTeacher.setLocationRelativeTo(null);
	        	                studentInfoFromTeacher.setVisible(true);
	        	                studentInfoFromTeacher.getSID().setText(map.get("id"));
	        	                studentInfoFromTeacher.getSAge().setText(map.get("age"));
	        	                studentInfoFromTeacher.getSFather().setText(map.get("father_name"));
	        	                studentInfoFromTeacher.getSMother().setText(map.get("mother_name"));
	        	                studentInfoFromTeacher.getSName().setText(map.get("first_name") + " " + map.get("last_name"));
	        	                studentInfoFromTeacher.getTeacher().setText(map.get("teacher_name"));
	        	                studentInfoFromTeacher.getClassroom().setText(map.get("classroom_id"));
	        	                
	        	                DefaultTableModel tableModel = (DefaultTableModel)studentInfoFromTeacher.getImmunizationTable().getModel();
	        	                tableModel.setRowCount(0);
	        	                tableModel.setColumnCount(6);
	        	                Object[] row = new Object[tableModel.getColumnCount()];
	        	                
	        	                row[0] = map.get("Hib");
	        	                row[1] = map.get("DTaP");
	        	                row[2] = map.get("Polio");
	        	                row[3] = map.get("Hepatitis B");
	        	                row[4] = map.get("MMR");
	        	                row[5] = map.get("Varicella");
	        	                tableModel.addRow(row);
	        	                //System.out.println(tableModel.getColumnName(1));
	        	            }
	        	        });
        			} else {
        				JOptionPane.showMessageDialog(null, "Please enter correct Student ID", "Error", JOptionPane.WARNING_MESSAGE);
        			}
        		}
    		});
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	
	}

}
