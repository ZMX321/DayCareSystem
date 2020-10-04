package edu.neu.csye6200.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import edu.neu.csye6200.data.StudentData;
import edu.neu.csye6200.display.ImmunizationManagement;
import edu.neu.csye6200.display.TeacherManagement;
import edu.neu.csye6200.display.UpdateStudentImmunization;

public class ImmunizationManagementController {
	
	//get instance
		private static String teacher_id;
		
		public static void setTeacher_id(String teacherID) {
			teacher_id = teacherID;
		}
		
		private ImmunizationManagement immunizationManagement;
		private static ImmunizationManagementController instance;
		
		private ImmunizationManagementController(ImmunizationManagement immunizationManagement) {
			this.immunizationManagement = immunizationManagement;
			InitImmunizationManagement();
			
		}

		public static void getInstance(ImmunizationManagement immunizationManagement) {
			instance = new ImmunizationManagementController(immunizationManagement);
		}
		
		public void InitImmunizationManagement() {
			try {
	    		//back
	        	this.immunizationManagement.getBack().addMouseListener(new MouseAdapter() {
	        		public void mouseClicked(MouseEvent e) {
	        			immunizationManagement.setVisible(false);
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
	        	this.immunizationManagement.getSearch().addMouseListener(new MouseAdapter() {
	        		public void mouseClicked(MouseEvent e) {
	        			int studentID = Integer.parseInt(immunizationManagement.getStudentID().getText());
						System.out.println(studentID);
						StudentData studentData = new StudentData();
						Map<String,String> map = studentData.getDataList(studentID);
						System.out.println(map);
						//需要判断studentID是否在csv文件中,存在就跳转，不存在报错
						if (map != null) {
	        			immunizationManagement.setVisible(false);
		        			java.awt.EventQueue.invokeLater(new Runnable() {
		        	            public void run() {
		        	                UpdateStudentImmunization updateStudentImmunization = new UpdateStudentImmunization();
		        	                UpdateStudentImmunizationController.getInstance(updateStudentImmunization);
		        	                updateStudentImmunization.setLocationRelativeTo(null);
		        	                updateStudentImmunization.setVisible(true);
		        	                updateStudentImmunization.getSName().setText(map.get("first_name"));
		        	                updateStudentImmunization.getStudentID().setText(map.get("id"));
		        	                UpdateStudentImmunizationController.setTeacher_id(teacher_id);
		        	                
		        	                
		        	                DefaultTableModel tableModel = (DefaultTableModel)updateStudentImmunization.getImmunizationInfoTable().getModel();
		        	                tableModel.setRowCount(0);
		        	                tableModel.setColumnCount(6);
		        	                Object[] row = new Object[tableModel.getColumnCount()];
		        	                
		        	                if(map.get("Hib").equals("2050/1/1")) {
		        	                	row[0] = "Don't need it.";
		        	                }else {
		        	                	row[0] = map.get("Hib");
		        	                }
		        	                
		        	                row[1] = map.get("DTaP");
		        	                row[2] = map.get("Polio");
		        	                row[3] = map.get("Hepatitis B");
		        	                row[4] = map.get("MMR");
		        	                row[5] = map.get("Varicella");
		        	                tableModel.addRow(row);
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
