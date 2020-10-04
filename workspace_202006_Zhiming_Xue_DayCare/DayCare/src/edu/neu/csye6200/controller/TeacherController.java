
package edu.neu.csye6200.controller;

import edu.neu.csye6200.data.StudentData;
import edu.neu.csye6200.display.*;
import edu.neu.csye6200.model.Classroom;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.repository.ClassroomRepository;
import edu.neu.csye6200.repository.TeacherRepository;
import edu.neu.csye6200.util.FileIO;

import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.collections.MappingChange.Map;

/**
 * @author Congcong
 * @version $ Id: TeacherController.java, v 0.1 2020年08月11日 10:22 上午 Congcong Exp $
 */
public class TeacherController extends BaseController {

    private static final TeacherController INSTANCE;
    private String account = null;
    private final TeacherRepository teacherRepository = TeacherRepository.getInstance();
    private final ClassroomRepository classroomRepository = ClassroomRepository.getInstance();

    private final ThreadLocal<Teacher> teacherThreadLocal = new ThreadLocal<>();

    static {
        INSTANCE = new TeacherController();
    }

    public static TeacherController getInstance() {
        return INSTANCE;
    }

    public Teacher getCurrentLoginTeacher() {
        return teacherThreadLocal.get();
    }

    public void login(TeacherLoginFrame loginFrame) {
        account = loginFrame.getjTextFieldAccount().getText();
        System.out.println(account);
        if (assertNotBlank(account, "Please input account")) {
            return;
        }
        String password = loginFrame.getjTextFieldPassword().getText();
        if (assertNotBlank(password, "Please input password")) {
            return;
        }
        Teacher teacher = teacherRepository.selectById(account);
        if (teacher == null) {
            BaseFrame.alert("Teacher not registered", null);
        } else if (!password.equals(teacher.getPassword())) {
            BaseFrame.alert("Password wrong", null);
        } else {
            teacherThreadLocal.set(teacher);
            intoTeacherManage(loginFrame);
        }
    }

    public void login(Teacher teacher) {
        teacherThreadLocal.set(teacher);
    }

    public void logout(TeacherMainFrame teacherMainFrame) {
        teacherThreadLocal.remove();
        redirectToLogin(teacherMainFrame);
    }

//    public void showStudentDetail(String studentId) {
//        new ViewStudentJFrame(studentId).display();
//    }

    public boolean checkLogin() {
        return teacherThreadLocal.get() != null;
    }

    public String getTeacherName() {
        Teacher teacher = teacherThreadLocal.get();
        if (teacher == null) {
            return null;
        }
        return teacher.getFirst_name() + " " +  teacher.getLast_name();
    }

    private void intoTeacherManage(TeacherLoginFrame loginFrame) {
        if (!checkLogin()) {
            TeacherLoginFrame.alert("Please login", null);
        }
        TeacherManagementController.setTeacher_id(teacherThreadLocal.get().getId());
        loginFrame.dispose();
        new TeacherManagement().display();
    }

    public void intoTeacherMain() {
        new TeacherMainFrame().display();
    }

    public void register(TeacherRegisterFrame registerFrame) {
        String firstName = registerFrame.getjTextFieldFirstName().getText();
        if (assertNotBlank(firstName, "Please input first name")) {
            return;
        }
        String lastName = registerFrame.getjTextFieldLastName().getText();
        if (assertNotBlank(firstName, "Please input last name")) {
            return;
        }
        String password = registerFrame.getjTextFieldPassword().getText();
        if (assertNotBlank(firstName, "Please input password")) {
            return;
        }
        String classroom_id = registerFrame.getjTextFieldClassroomID().getText();
        if (Integer.parseInt(classroom_id) > 6) {
        	assertNotBlank(firstName, "Classroom id must be small than 6");
        	return;
        }
        String id = register(firstName, lastName, classroom_id, password);
        BaseFrame.alert("Register success. Your ID is: " + id, null);
        redirectToLogin(registerFrame);
    }

    public String register(String firstName, String lastName, String classroom_id, String password) {
        String id = teacherRepository.getNextId();
        Teacher teacher = new Teacher(id, firstName, lastName, classroom_id, password);
        teacherRepository.save(teacher);
        return id;
    }

    public void redirectToLogin(BaseFrame currentFrame) {
        new TeacherLoginFrame().display();
        currentFrame.dispose();
    }

    public void redirectToRegister(BaseFrame currentFrame) {
        new TeacherRegisterFrame().display();
        currentFrame.dispose();
    }

    public String getClassroomId() {
        Teacher teacher = teacherThreadLocal.get();
        if (teacher == null) {
            return null;
        }
        return teacher.getClassroom_id();
    }

    public String getClassroomMinAge() {
        Classroom classroom = getClassroom();
        if (classroom == null) {
            return "";
        }
        return classroom.getMinAge().toString();
    }

    public String getClassroomMaxAge() {
        Classroom classroom = getClassroom();
        if (classroom == null) {
            return "";
        }
        return classroom.getMaxAge().toString();
    }

    public String getClassroomMaxSize() {
        Classroom classroom = getClassroom();
        if (classroom == null) {
            return "";
        }
        return classroom.getMaxSize().toString();
    }

    public String[] getStudentFields() {
        return new String[]{
                "ID", "Name", "Age", "Father", "Mother"
        };
    }

    public String[][] getStudentsInfo() {
    	
    	List<java.util.Map<String, String>> studentsList = FileIO.readFile("Student.csv");
    	System.out.println(studentsList);
    	List<java.util.Map<String, String>> teacherList = new ArrayList<>();
    	for(java.util.Map map :studentsList) {
    		if(map.get("teacher_id").equals(account)) {
    			System.out.println(map);
    			teacherList.add(map);
    		}
    	}
    	System.out.println("size" + teacherList.size());
    	
        
        String[][] data = new String[teacherList.size()][5];
        int i = 0;
        for(java.util.Map<String, String> map:teacherList) {
        	
        	data[i][0] = map.get("id");
            data[i][1] = map.get("first_name") + " " + map.get("last_name");
            data[i][2] = map.get("age");
            data[i][3] = map.get("father_name");
            data[i][4] = map.get("mother_name");
            i++;
        }
        return data;
//    	Classroom classroom = getClassroom();
//        if (classroom == null) {
//            return null;
//        }
//        List<Student> studentList = classroom.getStudentList();
//        String[][] data = new String[studentList.size()][getStudentFields().length];
//        for (int i = 0; i < studentList.size(); i++) {
//            Student student = studentList.get(i);
//            data[i][0] = student.getId();
//            data[i][1] = student.getFirst_name() + " " + student.getLast_name();
//            data[i][2] = student.getAge();
//            data[i][3] = student.getFather_name();
//            data[i][4] = student.getMother_name();
//        }
//        return data;
    }

    private Classroom getClassroom() {
        Teacher teacher = teacherThreadLocal.get();
        if (teacher == null) {
            return null;
        }
        String classroomId = teacher.getClassroom_id();
        return classroomRepository.selectById(classroomId);
    }

    private TeacherController() {
    }
}
