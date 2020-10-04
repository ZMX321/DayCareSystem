
package edu.neu.csye6200.controller;


import edu.neu.csye6200.display.BaseFrame;

/**
 * @author Congcong
 * @version $ Id: BaseController.java, v 0.1 2020年08月11日 11:44 上午 Congcong Exp $
 */
public abstract class BaseController {

    boolean assertNotBlank(String s, String message) {
        if (s == null || s.trim().length() == 0) {
            BaseFrame.alert(message, null);
            return true;
        }
        return false;
    }
}
