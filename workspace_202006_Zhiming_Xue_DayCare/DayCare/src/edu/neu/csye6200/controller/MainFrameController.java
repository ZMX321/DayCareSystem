/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import edu.neu.csye6200.display.MainFrame;
import edu.neu.csye6200.display.StudentLogin;
import edu.neu.csye6200.display.TeacherLogin;
import edu.neu.csye6200.display.TeacherLoginFrame;

/**
 * @author fengpeng
 */
public class MainFrameController {

    private MainFrame view;

    public MainFrameController(MainFrame view) {
        this.view = view;
        view.setLocationRelativeTo(null);
        InitMainFrame();
    }

    public MainFrame getView() {
        return view;
    }

    public void setView(MainFrame view) {
        this.view = view;
    }

    private void InitMainFrame() {
        try {


        } catch (Exception e) {
            // TODO: handle exception
        }


    }


}
