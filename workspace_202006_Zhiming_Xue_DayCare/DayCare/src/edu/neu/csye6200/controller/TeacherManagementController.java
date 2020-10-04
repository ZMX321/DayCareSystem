package edu.neu.csye6200.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;

import edu.neu.csye6200.display.ClassroomList;
import edu.neu.csye6200.display.GroupInfoFromTeacher;
import edu.neu.csye6200.display.ImmunizationManagement;
import edu.neu.csye6200.display.StudentsManagement;
import edu.neu.csye6200.display.TeacherManagement;
import edu.neu.csye6200.function.Days;
import edu.neu.csye6200.model.Datainit;
import edu.neu.csye6200.util.FileIO;

public class TeacherManagementController {
	
	//get instance
	private static String teacher_id ;
	

	public static void setTeacher_id(String teacherID) {
		teacher_id = teacherID;
	}
	

	private TeacherManagement teacherManagement;
	private static TeacherManagementController instance;
	
	private TeacherManagementController(TeacherManagement teacherManagement) {
		this.teacherManagement = teacherManagement;
		InitManagement();
	}

	public static void getInstance(TeacherManagement teacherManagement) {
		instance = new TeacherManagementController(teacherManagement);
	}
	
	public void InitManagement() {
		try {
			//student management
			this.teacherManagement.getStudents().addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					teacherManagement.setVisible(false);
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
			
			//teacher management
//			this.teacherManagement.getTeachers().addMouseListener(new MouseAdapter() {
//				public void mouseClicked(MouseEvent e) {
//					teacherManagement.setVisible(false);
//					java.awt.EventQueue.invokeLater(new Runnable() {
//	    	            public void run() {
//	    	            	GroupInfoFromTeacher groupInfoFromTeacher = new GroupInfoFromTeacher();
//	    	            	GroupInfoFromTeacherController.getInstance(groupInfoFromTeacher);
//	    	            	groupInfoFromTeacher.setVisible(true);
//	    	            }
//	    	        });
//				}
//			});
			
			//classroom management
			this.teacherManagement.getClassroom().addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					teacherManagement.setVisible(false);
					java.awt.EventQueue.invokeLater(new Runnable() {
	    	            public void run() {
	    	            	ClassroomList classroomList = new ClassroomList();
	    	            	ClassroomListController.getInstance(classroomList).setTableData();
	    	            	classroomList.setLocationRelativeTo(null);
	    	            	classroomList.setVisible(true);
	    	            }
	    	        });
				}
			});
			
			//immunization management
			this.teacherManagement.getImmunization().addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					teacherManagement.setVisible(false);
					java.awt.EventQueue.invokeLater(new Runnable() {
	    	            public void run() {
	    	            	ImmunizationManagement immunizationManagement = new ImmunizationManagement();
	    	            	ImmunizationManagementController.getInstance(immunizationManagement);
	    	            	immunizationManagement.setLocationRelativeTo(null);
	    	            	immunizationManagement.setVisible(true);
	    	            	ImmunizationManagementController.setTeacher_id(teacher_id);
	    	            	
	    	            	//get all student data
	    	            	
	    	            	immunizationManagement.getNearlyAlert().setEditable(false);
	    	            	List<Map<String, String>> students = FileIO.readFile("Student.csv");
	    	            	Datainit datainit = Datainit.getInstance();
	    	            	datainit.ImmunizationRules();
	    	            	Map<String, Integer> duration = datainit.getImmuniRules();
	    	            	for (Map<String, String> student : students) {
	    	            		int currentHib = duration.get("Hib") - Days.count(student.get("Hib"));
	    	            		int currentDTaP = duration.get("DTaP") - Days.count(student.get("DTaP"));
	    	            		int currentPolio = duration.get("Polio") -  Days.count(student.get("Polio"));
	    	            		int currentHepatitis_B = duration.get("Hepatitis B") -  Days.count(student.get("Hepatitis B"));
	    	            		int currentMMR = duration.get("MMR") -  Days.count(student.get("MMR"));
	    	            		int currentVaricella = duration.get("Varicella") -  Days.count(student.get("Varicella"));
	    	            		
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
			System.out.println("Please enter Integer");
		}
		
	}
}
