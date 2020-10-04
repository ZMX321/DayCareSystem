package edu.neu.csye6200.controller;

import edu.neu.csye6200.data.StudentData;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import edu.neu.csye6200.display.MainFrame;
import edu.neu.csye6200.display.RegisterForStudent;
import edu.neu.csye6200.display.StudentInfoBySelf;
import edu.neu.csye6200.display.StudentLogin;
//import edu.neu.csye6200.interfaces.StudentDataMangementFactory;
import edu.neu.csye6200.model.Student;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class StudentLoginController {
	private StudentLogin studentLogin;
	
	private static StudentLoginController instance;
	
	private StudentLoginController(StudentLogin studentLogin) {
		this.studentLogin = studentLogin;
		InitstudentLogin();
	}
	
	public static void getInstance(StudentLogin studentLogin) {
		instance = new StudentLoginController(studentLogin);
	}
	
	private void InitstudentLogin() {
		try {
			this.studentLogin.getLogin().addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int studentID = Integer.parseInt(studentLogin.getStudentID().getText());
					System.out.println("studentID="+studentID);
                                        StudentData studentData = new StudentData();
					Map<String,String> map = studentData.getDataList(studentID);
                                        System.out.println(map);
                                        if(map == null){
                                            JOptionPane.showMessageDialog(null, "Please enter a valid student id!","Warning",JOptionPane.WARNING_MESSAGE);
                                        }else{
                                            
                                            studentLogin.setVisible(false);
                                            StudentInfoBySelf studentInfoBySelf = new StudentInfoBySelf(); 
                                            StudentInfoBySelfController.getInstance(studentInfoBySelf);
                                            studentInfoBySelf.setLocationRelativeTo(null);
                                            studentInfoBySelf.setVisible(true);
                                            
                                            studentInfoBySelf.getSID().setText(map.get("id"));
                                            studentInfoBySelf.getClassroom().setText(map.get("classroom_id"));
                                            studentInfoBySelf.getSAge().setText(map.get("age"));
                                            studentInfoBySelf.getSFather().setText(map.get("father_name"));
                                            studentInfoBySelf.getSMother().setText(map.get("mother_name"));
                                            studentInfoBySelf.getSName().setText(map.get("first_name") + " " + map.get("last_name"));
                                            studentInfoBySelf.getTeacher().setText(map.get("teacher_name"));
                                            
                                            DefaultTableModel tableModel = (DefaultTableModel)studentInfoBySelf.getImmunizationTable().getModel();
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
        		        	                
        		        	                
                                        }
                                }
                        });
			
			
			this.studentLogin.getBack().addMouseListener(new MouseAdapter(){
              public void mouseClicked(MouseEvent e) {
            	 studentLogin.setVisible(false);
              java.awt.EventQueue.invokeLater(new Runnable() {
              public void run() {
            	  MainFrame mainFrame = new MainFrame();
            	  MainFrameController mainFrameController = new MainFrameController(mainFrame);
            	  mainFrame.setLocationRelativeTo(null);
            	  mainFrame.setVisible(true);
              }
              });
          }
      });
                                        

			
			//Register for new student
        	this.studentLogin.getRegister().addMouseListener(new MouseAdapter() {
        		public void mouseClicked(MouseEvent e) {
        			studentLogin.setVisible(false);
        			java.awt.EventQueue.invokeLater(new Runnable() {
        	            public void run() {
        	                RegisterForStudent registerForStudent = new RegisterForStudent();
        	                RegisterForStudentController.getInstance(registerForStudent);
        	                registerForStudent.setLocationRelativeTo(null);
        	                registerForStudent.setVisible(true);
        	            }
        	        });
        		}
    		});
			
		} catch (Exception e) {
			System.out.println("Please enter Integer");
		}
		
		
		
		
	}

}
