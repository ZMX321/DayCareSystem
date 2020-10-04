package edu.neu.csye6200.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import edu.neu.csye6200.display.StudentInfoBySelf;
import edu.neu.csye6200.display.StudentLogin;

public class StudentInfoBySelfController {
	
	
	//get instance
			private StudentInfoBySelf studentInfoBySelf;
			private static StudentInfoBySelfController instance;
			
			private StudentInfoBySelfController(StudentInfoBySelf studentInfoBySelf) {
				this.studentInfoBySelf = studentInfoBySelf;
				InitStudentInfoBySelf();
			}

			public static void getInstance(StudentInfoBySelf studentInfoBySelf) {
				instance = new StudentInfoBySelfController(studentInfoBySelf);
			}
			
		
		
			public void InitStudentInfoBySelf() {
				System.out.println("init student info by self");
				try {
		    		//back
		        	this.studentInfoBySelf.getBack().addMouseListener(new MouseAdapter() {
		        		public void mouseClicked(MouseEvent e) {
		        			System.out.println("click back");
		        			studentInfoBySelf.setVisible(false);
		        			java.awt.EventQueue.invokeLater(new Runnable() {
		        	            public void run() {
		        	                StudentLogin studentLogin = new StudentLogin();
		        	                StudentLoginController.getInstance(studentLogin);
		        	                studentLogin.setLocationRelativeTo(null);
		        	                studentLogin.setVisible(true);
		        	            }
		        	        });
		        		}
		    		});
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				

	    	
			}
			

}
