
package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.repository.StudentRepository;

/**
 * @author Congcong
 * @version $ Id: StudentCotroller.java, v 0.1 2020年08月11日 8:33 下午 Congcong Exp $
 */
public class StudentController extends BaseController {

    private static final StudentController INSTANCE = new StudentController();

    private StudentRepository studentRepository = StudentRepository.getInstance();

    public static StudentController getINSTANCE() {
        return INSTANCE;
    }

    public Student getStudent(String sid) {
        return studentRepository.selectById(sid);
    }

    private StudentController() {
    }
}
