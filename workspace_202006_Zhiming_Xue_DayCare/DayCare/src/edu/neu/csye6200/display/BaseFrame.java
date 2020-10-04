
package edu.neu.csye6200.display;

import javax.swing.*;

/**
 * @author Congcong
 * @version $ Id: BaseFrame.java, v 0.1 2020年08月11日 10:32 上午 Congcong Exp $
 */
public abstract class BaseFrame extends JFrame {

    public void display() {
        java.awt.EventQueue.invokeLater(() -> {
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        });
    }

    public static void alert(String message, String title) {
        JOptionPane.showConfirmDialog(null, message, title, JOptionPane.DEFAULT_OPTION);
    }
}
