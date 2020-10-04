
package edu.neu.csye6200.repository;

import edu.neu.csye6200.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Congcong
 * @version $ Id: StudentRepository.java, v 0.1 2020年08月11日 6:42 下午 Congcong Exp $
 */
public class StudentRepository extends BaseRepository<Student> {

    private static final StudentRepository INSTANCE = new StudentRepository();

    private final Map<String, List<Student>> classroomId2Students = new HashMap<>();

    static {
        INSTANCE.loadFromCsv("student.csv");
    }

    public static StudentRepository getInstance() {
        return INSTANCE;
    }

    public Student selectById(String id) {
        return id2Model.get(id);
    }

    public List<Student> selectByClassroomId(String classroomId) {
        return classroomId2Students.get(classroomId);
    }

    public Student columnsToModel(Map<String, String> columns) {
        Student student = new Student();
        student.setId(columns.get("id"));
        student.setFirst_name(columns.get("first_name"));
        student.setLast_name(columns.get("last_name"));
        student.setClassroom_id(columns.get("classroom_id"));
        student.setPassword(columns.get("password"));
        student.setAge(columns.get("age"));
        student.setFather_name(columns.get("father_name"));
        student.setMother_name(columns.get("mother_name"));
        student.setHib(columns.get("Hib"));
        student.setDTaP(columns.get("DTaP"));
        student.setPolio(columns.get("Polio"));
        student.setHepatitis_B(columns.get("Hepatitis B"));
        student.setMMR(columns.get("MMR"));
        student.setVaricella(columns.get("Varicella"));

        /*
        String classroomId = student.getClassroomId();
        List<Student> students = classroomId2Student.get(classroomId);
        if (students == null) {
            students = new ArrayList<>();
            classroomId2Student.put(classroomId, students);
        }
        students.add(student);
        */
        classroomId2Students.computeIfAbsent(student.getClassroom_id(), k -> new ArrayList<>());
        classroomId2Students.get(student.getClassroom_id()).add(student);
        return student;
    }

    @Override
    public List<String> modelToColumns(Student student) {
        return null;
    }

    private StudentRepository() {
    }
}
