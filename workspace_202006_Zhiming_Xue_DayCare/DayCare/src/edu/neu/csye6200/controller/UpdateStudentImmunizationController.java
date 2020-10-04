package edu.neu.csye6200.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import edu.neu.csye6200.data.StudentData;
import edu.neu.csye6200.display.ImmunizationManagement;
import edu.neu.csye6200.display.UpdateStudentImmunization;
import edu.neu.csye6200.function.Days;
import edu.neu.csye6200.model.Datainit;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.util.FileIO;

public class UpdateStudentImmunizationController {
	
	//get instance
			
			private UpdateStudentImmunization updateStudentImmunization;
			private static UpdateStudentImmunizationController instance;
			private static String teacher_id;
			
			public static void setTeacher_id(String teacherID) {
				teacher_id = teacherID;
			}
	
			private UpdateStudentImmunizationController(UpdateStudentImmunization updateStudentImmunization) {
				this.updateStudentImmunization = updateStudentImmunization;
				InitUpdateStudentImmunization();
				update();
			}

			public static void getInstance(UpdateStudentImmunization updateStudentImmunization) {
				instance = new UpdateStudentImmunizationController(updateStudentImmunization);
			}
			
			
			
			public void InitUpdateStudentImmunization() {
				try {
		    		//back
		        	this.updateStudentImmunization.getBack().addMouseListener(new MouseAdapter() {
		        		public void mouseClicked(MouseEvent e) {
		        			updateStudentImmunization.setVisible(false);
		        			java.awt.EventQueue.invokeLater(new Runnable() {
		        	            public void run() {
		        	                ImmunizationManagement immunizationManagement = new ImmunizationManagement();
		        	                ImmunizationManagementController.getInstance(immunizationManagement);
		        	                immunizationManagement.setLocationRelativeTo(null);
		        	                immunizationManagement.setVisible(true);
		        	                ImmunizationManagementController.setTeacher_id(teacher_id);
		        	                System.out.println("teacher_id:" + teacher_id);
		        	              //get all student data
			    	            	immunizationManagement.getNearlyAlert().setEditable(false);
			    	            	List<Map<String, String>> students = FileIO.readFile("Student.csv");
			    	            	Datainit datainit = Datainit.getInstance();
			    	            	datainit.ImmunizationRules();
			    	            	Map<String, Integer> duration = datainit.getImmuniRules();
			    	            	
			    	            	System.out.println(students.size());
			    	            	for (Map<String, String> student : students) {
			    	            		int currentHib = duration.get("Hib") - Days.count(student.get("Hib"));
			    	            		int currentDTaP = duration.get("DTaP") - Days.count(student.get("DTaP"));
			    	            		int currentPolio = duration.get("Polio") -  Days.count(student.get("Polio"));
			    	            		int currentHepatitis_B = duration.get("Hepatitis B") -  Days.count(student.get("Hepatitis B"));
			    	            		int currentMMR = duration.get("MMR") -  Days.count(student.get("MMR"));
			    	            		int currentVaricella = duration.get("Varicella") -  Days.count(student.get("Varicella"));
//			    	            		System.out.println(teacher_id);
//			    	            		System.out.println(currentMMR);
			    	            		
			    	            		if (student.get("teacher_id").equals(teacher_id) && currentHib <= 10) {
			    	            			if (currentHib <= 0) {
			    	            				immunizationManagement.getNearlyAlert().append("student_id: " + student.get("id") + student.get("first_name") + " " + student.get("last_name") +  " needs to receive Hib right now\n");
			    	            			} else {
			    	            				immunizationManagement.getNearlyAlert().append("student_id: " + student.get("id") + student.get("first_name") + " " + student.get("last_name") +  " needs to receive Hib in " + currentHib + " days\n");
			    	            			}
			    	            		}
			    	            		
			    	            		if (student.get("teacher_id").equals(teacher_id) && currentDTaP <= 10) {
			    	            			if (currentDTaP <= 0) {
			    	            				immunizationManagement.getNearlyAlert().append("student_id: " + student.get("id") + student.get("first_name") + " " + student.get("last_name") +  " needs to receive DTaP right now\n");
			    	            			} else {
			    	            				immunizationManagement.getNearlyAlert().append("student_id: " + student.get("id") + student.get("first_name") + " " + student.get("last_name") +  " needs to receive DTaP in " + currentDTaP + " days\n");
			    	            			}
			    	            		}
			    	            		
			    	            		if (student.get("teacher_id").equals(teacher_id) && currentPolio <= 10) {
			    	            			if (currentPolio <= 0) {
			    	            				immunizationManagement.getNearlyAlert().append("student_id: " + student.get("id") + student.get("first_name") + " " + student.get("last_name") +  " needs to receive Polio right now\n");
			    	            			} else {
			    	            				immunizationManagement.getNearlyAlert().append("student_id: " + student.get("id") + student.get("first_name") + " " + student.get("last_name") +  " needs to receive Polio in " + currentPolio + " days\n");
			    	            			}
			    	            		}
			    	            		
			    	            		if (student.get("teacher_id").equals(teacher_id) && currentHepatitis_B <= 10) {
			    	            			if (currentHepatitis_B <= 0) {
			    	            				immunizationManagement.getNearlyAlert().append("student_id: " + student.get("id") + student.get("first_name") + " " + student.get("last_name") +  " needs to receive Hepatitis B right now\n");
			    	            			} else {
			    	            				immunizationManagement.getNearlyAlert().append("student_id: " + student.get("id") + student.get("first_name") + " " + student.get("last_name") +  " needs to receive Hepatitis B in " + currentHepatitis_B + " days\n");
			    	            			}
			    	            		}
			    	            		
			    	            		if (student.get("teacher_id").equals(teacher_id) && currentMMR <= 10) {
			    	            			if (currentMMR <= 0) {
			    	            				immunizationManagement.getNearlyAlert().append("student_id: " + student.get("id") + student.get("first_name") + " " + student.get("last_name") +  " needs to receive MMR right now\n");
			    	            			} else {
			    	            				immunizationManagement.getNearlyAlert().append("student_id: " + student.get("id") + student.get("first_name") + " " + student.get("last_name") +  " needs to receive MMR in " + currentMMR + " days\n");
			    	            			}
			    	            		}
			    	            		
			    	            		if (student.get("teacher_id").equals(teacher_id) && currentVaricella <= 10) {
			    	            			if (currentVaricella <= 0) {
			    	            				immunizationManagement.getNearlyAlert().append("student_id: " + student.get("id") + student.get("first_name") + " " + student.get("last_name") +  " needs to receive Varicella right now\n");
			    	            			} else {
			    	            				immunizationManagement.getNearlyAlert().append("student_id: " + student.get("id") + student.get("first_name") + " " + student.get("last_name") +  " needs to receive Varicella in " + currentVaricella + " days\n");
			    	            			}
			    	            		}
			    	            	}
		        	            }
		        	        });
		        		}
		    		});
		        	
				} catch (Exception e) {
					// TODO: handle exception
				}
		    	
			}
			public void update() {
				this.updateStudentImmunization.getFinish().addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						int studentID = Integer.parseInt(updateStudentImmunization.getStudentID().getText());
						String Hib = String.valueOf(updateStudentImmunization.getImmunizationInfoTable().getValueAt(0, 0));
						String DTaP = String.valueOf(updateStudentImmunization.getImmunizationInfoTable().getValueAt(0, 1));
						String Polio = String.valueOf(updateStudentImmunization.getImmunizationInfoTable().getValueAt(0, 2));
						String Hepatitis_B = String.valueOf(updateStudentImmunization.getImmunizationInfoTable().getValueAt(0, 3));
						String MMR = String.valueOf(updateStudentImmunization.getImmunizationInfoTable().getValueAt(0, 4));
						String Varicella = String.valueOf(updateStudentImmunization.getImmunizationInfoTable().getValueAt(0, 5));
						
						StudentData studentdata = new StudentData();
						
						Map<String,String> studentMap = studentdata.getDataList(studentID);
						System.out.println(studentMap);
						
						studentMap.put("Hib", Hib);
						studentMap.put("DTaP", DTaP);
						studentMap.put("Polio", Polio);
						studentMap.put("Hepatitis B", Hepatitis_B);
						studentMap.put("MMR", MMR);
						studentMap.put("Varicella", Varicella);
						
						
						
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
						
						JOptionPane.showMessageDialog(null, "Thank you for your contribution to the children's health！");
						
					}
				});
			}

}
