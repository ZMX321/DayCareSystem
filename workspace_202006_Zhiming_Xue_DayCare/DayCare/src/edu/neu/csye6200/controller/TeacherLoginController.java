package edu.neu.csye6200.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import edu.neu.csye6200.data.TeacherData;
import edu.neu.csye6200.display.TeacherLogin;
import edu.neu.csye6200.display.TeacherManagement;

public class TeacherLoginController {
	
	private TeacherLogin teacherLogin;
	
	private static TeacherLoginController instance;
	
	private TeacherLoginController(TeacherLogin teacherLogin) {
		this.teacherLogin = teacherLogin;
		teacherLogin();
	}
	
	public static void getInstance(TeacherLogin teacherLogin) {
		instance = new TeacherLoginController(teacherLogin);
	}
	
	private void teacherLogin() {
		try {
			this.teacherLogin.getLogin().addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int teacherID = Integer.parseInt(teacherLogin.getTeacherID().getText());
//					System.out.println(teacherID);
					TeacherData teacherData = new TeacherData();
					Map<String,String> map = teacherData.getDataList(teacherID);
					
//					System.out.println(map);
					//需要判断teacherID是否在csv文件中
					if(map != null) {
	 					teacherLogin.setVisible(false);
						//登录成功之后需要跳转到teacherManagement
						java.awt.EventQueue.invokeLater(new Runnable() {
		    	            public void run() {
		    	                TeacherManagement teacherManagement = new TeacherManagement();
		    	                TeacherManagementController.getInstance(teacherManagement);
		    	                teacherManagement.setLocationRelativeTo(null);
		    	                teacherManagement.setVisible(true);
		    	                TeacherManagementController.setTeacher_id(String.valueOf(teacherID));
		    	            }
		    	        });
					} else {
						JOptionPane.showMessageDialog(null, "Please enter correct teacher ID", "Error", JOptionPane.WARNING_MESSAGE);
					}
				}
			});
			
		} catch (Exception e) {
			System.out.println("Please enter Integer");
		}
		
	}
	

}
