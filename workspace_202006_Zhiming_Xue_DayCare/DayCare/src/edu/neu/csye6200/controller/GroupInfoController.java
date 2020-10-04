/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import edu.neu.csye6200.display.GroupInfo;
import edu.neu.csye6200.display.ClassroomList;
import edu.neu.csye6200.data.StudentData;
import javax.swing.table.DefaultTableModel;
import java.util.Map;
import java.util.List;


/**
 *
 * @author wangguojun
 */
public class GroupInfoController {
    private GroupInfo groupInfo;
    private static GroupInfoController instance;
    
    private GroupInfoController(GroupInfo groupInfo){
        this.groupInfo = groupInfo;
        InitGroupInfo();
    }
    
    public static GroupInfoController getInstance(GroupInfo groupInfo){
        instance = new GroupInfoController(groupInfo);
        return instance;
    }
    
    public void setStudentData(){
        groupInfo.getClassroom().setText(Integer.toString(ClassroomListController.selectedRow+1));
        DefaultTableModel dtm = (DefaultTableModel)groupInfo.getJTable1().getModel();
        dtm.setRowCount(0);
        StudentData s = new StudentData();
        List<Map<String,String>> list = s.getDataList();
        for(Map<String,String> map : list){
            Object[] row = new Object[dtm.getColumnCount()];
            if(Integer.parseInt(map.get("classroom_id")) == (ClassroomListController.selectedRow)+1){
                row[0] = map.get("id");
                row[1] = map.get("first_name");
                row[2] = map.get("last_name");
                row[3] = map.get("age");
                dtm.addRow(row);
            }
        }
        
    }
    
    public void InitGroupInfo(){
        try {
	//back
	this.groupInfo.getBack().addMouseListener(new MouseAdapter() {
	    public void mouseClicked(MouseEvent e) {
	            groupInfo.setVisible(false);
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
				
        } catch (Exception e) {
	// TODO: handle exception
	}
    }
    
}
