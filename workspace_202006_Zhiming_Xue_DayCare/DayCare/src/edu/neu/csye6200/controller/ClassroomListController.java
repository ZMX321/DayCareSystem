package edu.neu.csye6200.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;

import edu.neu.csye6200.display.ClassroomList;
import edu.neu.csye6200.display.TeacherManagement;
import edu.neu.csye6200.display.GroupInfo;
import edu.neu.csye6200.model.Rules;
import edu.neu.csye6200.model.Datainit;

public class ClassroomListController {
	
	    //get instance
            public static int selectedRow;
		private ClassroomList classroomList;
		private static ClassroomListController instance;
		
		private ClassroomListController(ClassroomList classroomList) {
			this.classroomList = classroomList;
			InitClassroomList();
		}

		public static ClassroomListController getInstance(ClassroomList classroomList) {
			instance = new ClassroomListController(classroomList);
                        return instance;
		}
                
                public void setTableData(){
                    DefaultTableModel dtm = (DefaultTableModel)classroomList.getJTable1().getModel();
                    dtm.setRowCount(0);
                    int i = 1;
                    for(Rules rule : Datainit.getInstance().getRules()){
                        Object[] row = new Object[dtm.getColumnCount()];
                        
                        row[0] = "Classroom " + i;
                        i++;
                        if(rule.getMaxAge() == Integer.MAX_VALUE){
                            row[1] = rule.getMinAge() + " on up";
                        }
                        else{
                            row[1] = rule.getMinAge() + "-" + rule.getMaxAge();
                        }
                        row[2]=rule.getGroupSize();
                        row[3]=rule.getRatio();
                        row[4]= rule.getMaxGroup();
                        dtm.addRow(row);
                    }
                }
		
		
		public void InitClassroomList() {
			try {
	    		//back
	        	this.classroomList.getBack().addMouseListener(new MouseAdapter() {
	        		public void mouseClicked(MouseEvent e) {
	        			classroomList.setVisible(false);
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
                        
            try {
	    		//enter
	        	this.classroomList.getEnter().addMouseListener(new MouseAdapter() {
	        		public void mouseClicked(MouseEvent e) {
                                        selectedRow = classroomList.getJTable1().getSelectedRow();
	        			classroomList.setVisible(false);
	        			java.awt.EventQueue.invokeLater(new Runnable() {
	        	            public void run() {
	        	                GroupInfo groupInfo = new GroupInfo();
	        	                GroupInfoController.getInstance(groupInfo).setStudentData();
	        	                groupInfo.setLocationRelativeTo(null);
	        	                groupInfo.setVisible(true);
                                       
	        	            }
	        	        });
	        		}
	    		});
				
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	
		}

}
