package edu.neu.csye6200.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import edu.neu.csye6200.display.GroupInfoFromTeacher;
import edu.neu.csye6200.display.TeacherManagement;

public class GroupInfoFromTeacherController {
	
	
		//get instance
		private GroupInfoFromTeacher groupInfoFromTeacher;
		private static GroupInfoFromTeacherController instance;
		
		private GroupInfoFromTeacherController(GroupInfoFromTeacher groupInfoFromTeacher) {
			this.groupInfoFromTeacher = groupInfoFromTeacher;
			InitGroupInfoFromTeacher();
		}

		public static void getInstance(GroupInfoFromTeacher groupInfoFromTeacher) {
			instance = new GroupInfoFromTeacherController(groupInfoFromTeacher);
		}
		
	
		public void InitGroupInfoFromTeacher() {
			try {
	    		//back
	        	this.groupInfoFromTeacher.getBack().addMouseListener(new MouseAdapter() {
	        		public void mouseClicked(MouseEvent e) {
	        			groupInfoFromTeacher.setVisible(false);
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
				
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	
		}

}
