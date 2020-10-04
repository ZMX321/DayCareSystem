package edu.neu.csye6200.controller;

import edu.neu.csye6200.data.StudentData;
import edu.neu.csye6200.data.TeacherData;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import edu.neu.csye6200.display.RegisterForStudent;
import edu.neu.csye6200.display.RegisterForStudent_1;
import edu.neu.csye6200.display.RegisterForStudent_1_1;
import edu.neu.csye6200.display.StudentLogin;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.util.FileIO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class RegisterForStudentController {
	
	//get instance
			private RegisterForStudent registerForStudent;
			private static RegisterForStudentController instance;
			
			private RegisterForStudentController(RegisterForStudent registerForStudent) {
				this.registerForStudent = registerForStudent;
				InitRegisterForStudent();
			}

			public static void getInstance(RegisterForStudent registerForStudent) {
				instance = new RegisterForStudentController(registerForStudent);
			}
			
		
			public void InitRegisterForStudent() {
				try {
		    		//back
		        	this.registerForStudent.getNext().addMouseListener(new MouseAdapter() {
		        		public void mouseClicked(MouseEvent e) {
		        			 String fName=registerForStudent.getFirstname().getText();
//                             根据一个或多个空格分割name
//                             String[] tokens = name.split("\\s+");
//                             String fName=tokens[0];
                             String lName=registerForStudent.getSecondname().getText();
                             String age=registerForStudent.getAge().getText();
                             String fatherName=registerForStudent.getFather().getText();
                             String motherName=registerForStudent.getMother().getText(); 
                             
                             
                             Student student= new Student();
                             Teacher teacher= new Teacher();
                             student.setFirst_name(fName);
                             student.setLast_name(lName);
                             student.setAge(age);
                             student.setFather_name(fatherName);
                             student.setMother_name(motherName);
                             
                             StudentData studentdata = new StudentData();
                             TeacherData teacherdata = new TeacherData();
                             
                             String newid=String.valueOf(studentdata.getDataList().size()+1);
                             student.setId(newid);
                             int studentage=Integer.parseInt(age);
                             if(fName.equals("")||lName.equals("")|| age.equals("")||fatherName.equals("")|| motherName.equals("")){
                                 JOptionPane.showMessageDialog(null,"Name,Age,Father Name, Mother Name are required" );

                             }else {
                            	 if(studentage>=60){
                                	 student.setClassroom_id("6");
                                     String[] str=teacherdata.getDataList("6",2);
                                     System.out.println(str);
                                     if(studentdata.getDataList(str[0])<15) {
                                    	 student.setTeacher_id(str[0]);
                                    	 Map<String,String> map = teacherdata.getDataList(Integer.parseInt(str[0]));
                                         student.setTeacher_name(map.get("first_name")+" "+map.get("last_name"));
                                     }else if(studentdata.getDataList(str[1])<15) {
                                    	 student.setTeacher_id(str[1]);
                                    	 Map<String,String> map = teacherdata.getDataList(Integer.parseInt(str[1]));
                                         student.setTeacher_name(map.get("first_name")+" "+map.get("last_name"));
                                     }
                                 }else if(studentage>=48){
                                	 student.setClassroom_id("5");
                                     String[] str=teacherdata.getDataList("5",2);
                                     System.out.println(str);
                                     if(studentdata.getDataList(str[0])<12) {
                                    	 student.setTeacher_id(str[0]);
                                    	 Map<String,String> map = teacherdata.getDataList(Integer.parseInt(str[0]));
                                         student.setTeacher_name(map.get("first_name")+" "+map.get("last_name"));
                                     }else if(studentdata.getDataList(str[1])<12) {
                                    	 student.setTeacher_id(str[1]);
                                    	 Map<String,String> map = teacherdata.getDataList(Integer.parseInt(str[1]));
                                         student.setTeacher_name(map.get("first_name")+" "+map.get("last_name"));
                                     }
                                 }else if(studentage>=36){
                                	 student.setClassroom_id("4");
                                     String[] str=teacherdata.getDataList("4",3);
                                     System.out.println(str);
                                     if(studentdata.getDataList(str[0])<8) {
                                    	 student.setTeacher_id(str[0]);
                                    	 Map<String,String> map = teacherdata.getDataList(Integer.parseInt(str[0]));
                                         student.setTeacher_name(map.get("first_name")+" "+map.get("last_name"));
                                     }else if(studentdata.getDataList(str[1])<8) {
                                    	 student.setTeacher_id(str[1]);
                                    	 Map<String,String> map = teacherdata.getDataList(Integer.parseInt(str[1]));
                                         student.setTeacher_name(map.get("first_name")+" "+map.get("last_name"));
                                     }else if(studentdata.getDataList(str[2])<8) {
                                    	 student.setTeacher_id(str[2]);
                                    	 Map<String,String> map = teacherdata.getDataList(Integer.parseInt(str[2]));
                                         student.setTeacher_name(map.get("first_name")+" "+map.get("last_name"));
                                     }
                                 }else if(studentage>=25){
                                	 student.setClassroom_id("3");
                                     String[] str=teacherdata.getDataList("3",3);
                                     System.out.println(str);
                                     if(studentdata.getDataList(str[0])<6) {
                                    	 student.setTeacher_id(str[0]);
                                    	 Map<String,String> map = teacherdata.getDataList(Integer.parseInt(str[0]));
                                         student.setTeacher_name(map.get("first_name")+" "+map.get("last_name"));
                                     }else if(studentdata.getDataList(str[1])<6) {
                                    	 student.setTeacher_id(str[1]);
                                    	 Map<String,String> map = teacherdata.getDataList(Integer.parseInt(str[1]));
                                         student.setTeacher_name(map.get("first_name")+" "+map.get("last_name"));
                                     }else if(studentdata.getDataList(str[2])<6) {
                                    	 student.setTeacher_id(str[2]);
                                    	 Map<String,String> map = teacherdata.getDataList(Integer.parseInt(str[2]));
                                         student.setTeacher_name(map.get("first_name")+" "+map.get("last_name"));
                                     }
                                    
                                 }else if(studentage>=13){
                                    	student.setClassroom_id("2");
                                        String[] str=teacherdata.getDataList("2",3);
                                        System.out.println(str);
                                        if(studentdata.getDataList(str[0])<5) {
                                       	 student.setTeacher_id(str[0]);
                                       	 Map<String,String> map = teacherdata.getDataList(Integer.parseInt(str[0]));
                                            student.setTeacher_name(map.get("first_name")+" "+map.get("last_name"));
                                        }else if(studentdata.getDataList(str[1])<5) {
                                       	 student.setTeacher_id(str[1]);
                                       	 Map<String,String> map = teacherdata.getDataList(Integer.parseInt(str[1]));
                                            student.setTeacher_name(map.get("first_name")+" "+map.get("last_name"));
                                        }else if(studentdata.getDataList(str[2])<5) {
                                       	 student.setTeacher_id(str[2]);
                                       	 Map<String,String> map = teacherdata.getDataList(Integer.parseInt(str[2]));
                                            student.setTeacher_name(map.get("first_name")+" "+map.get("last_name"));
                                        }
                                    
                                    
                                 }else if(studentage>=6){
                                     student.setClassroom_id("1");
                                     String[] str=teacherdata.getDataList("1",3);
                                     System.out.println(str);
                                     if(studentdata.getDataList(str[0])<4) {
                                    	 student.setTeacher_id(str[0]);
                                    	 Map<String,String> map = teacherdata.getDataList(Integer.parseInt(str[0]));
                                         student.setTeacher_name(map.get("first_name")+" "+map.get("last_name"));
                                     }else if(studentdata.getDataList(str[1])<4) {
                                    	 student.setTeacher_id(str[1]);
                                    	 Map<String,String> map = teacherdata.getDataList(Integer.parseInt(str[1]));
                                         student.setTeacher_name(map.get("first_name")+" "+map.get("last_name"));
                                     }else if(studentdata.getDataList(str[2])<4) {
                                    	 student.setTeacher_id(str[2]);
                                    	 Map<String,String> map = teacherdata.getDataList(Integer.parseInt(str[2]));
                                         student.setTeacher_name(map.get("first_name")+" "+map.get("last_name"));
                                     }
                                    
                                 }
                                
                             registerForStudent.setVisible(false);
                             if(studentage<36){
                             
                             RegisterForStudent_1 registerForStudentYoung=new RegisterForStudent_1();
                             registerForStudentYoung.setLocationRelativeTo(null);
                             registerForStudentYoung.setVisible(true);   
                             
                             registerForStudentYoung.getAdd().addMouseListener(new MouseAdapter(){
                                 public void mouseClicked(MouseEvent e) {
                             String Hib=registerForStudentYoung.getHib().getText();
                             String DTaP=registerForStudentYoung.getDTaP().getText();
                             String Polio=registerForStudentYoung.getPolio().getText();
                             String Hepatitis_B=registerForStudentYoung.getHepatitis_B().getText();
                             String MMR=registerForStudentYoung.getMMR().getText();
                             String Varicella=registerForStudentYoung.getVaricella().getText();
                                 
                             student.setHib(Hib);
                             student.setDTaP(DTaP);
                             student.setPolio(Polio);
                             student.setHepatitis_B(Hepatitis_B);
                             student.setMMR(MMR);
                             student.setVaricella(Varicella);
                                 //studentdata.upDataList(student);
//                             List<Student> students=new ArrayList<>();
//                             students.add(student);
//                             FileIO.writeFileAppended(students, "src/main/resources/Student.csv");
                             studentdata.apendDataList(student);
                                     JOptionPane.showMessageDialog(null, "Register Sucessful! Your ID is "+newid+", please rember");
                                     registerForStudentYoung.setVisible(false);
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
                             }else{
                                 RegisterForStudent_1_1 registerForStudentOld= new RegisterForStudent_1_1();
                                 registerForStudentOld.setLocationRelativeTo(null);
                                 registerForStudentOld.setVisible(true);
                                 registerForStudentOld.getAdd().addMouseListener(new MouseAdapter(){
                                 public void mouseClicked(MouseEvent e) {
                     
                                 
                                 String DTaP=registerForStudentOld.getDTaP().getText();
      
                                 String Polio=registerForStudentOld.getPolio().getText();
                                 String Hepatitis_B=registerForStudentOld.getHepatitis_B().getText();
                                 String MMR=registerForStudentOld.getMMR().getText();
                                 String Varicella=registerForStudentOld.getVaricella().getText();
                               
                                student.setPolio(Polio);                      
                                student.setDTaP(DTaP);                                
                                 student.setHepatitis_B(Hepatitis_B);
                                 student.setMMR(MMR);
                                 student.setVaricella(Varicella);
                                 //List<Student> students=new ArrayList<>();
                                 //students.add(student);
                                 //FileIO.writeFileAppended(students, "src/main/resources/Student.csv");
                                 studentdata.apendDataList(student);
                                     JOptionPane.showMessageDialog(null, "Register Sucessful! Your ID is "+newid+", please rember");
                                     registerForStudentOld.setVisible(false);
                                     java.awt.EventQueue.invokeLater(new Runnable() {
                                     public void run() {
                                         StudentLogin studentLogin = new StudentLogin();
                                         StudentLoginController.getInstance(studentLogin);
                                         studentLogin.setVisible(true);
                                     }
                                     });
                                 }
                             });
                             }
                             }
                                                                               
                                 
                                       }
		    		});
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				try {
		    		//back
		        	this.registerForStudent.getBack().addMouseListener(new MouseAdapter() {
		        		public void mouseClicked(MouseEvent e) {
		        			registerForStudent.setVisible(false);
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
