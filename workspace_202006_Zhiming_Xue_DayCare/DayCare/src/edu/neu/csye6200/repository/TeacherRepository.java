/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.repository;

import edu.neu.csye6200.model.Teacher;

import java.util.*;

/**
 *
 * @author Congcong
 */
public class TeacherRepository extends BaseRepository<Teacher> {

    private static final TeacherRepository INSTANCE = new TeacherRepository();

    private final Map<String, List<Teacher>> classroomId2Teachers = new HashMap<>();

    static {
        INSTANCE.loadFromCsv("teacher.csv");
    }

    public static TeacherRepository getInstance() {
        return INSTANCE;
    }

    public void save(Teacher teacher) {
        id2Model.put(teacher.getId(), teacher);
        saveToCsv("teacher.csv", teacher);
    }

    public String getNextId() {
        return id2Model.size() + 1 + "";
    }

    public Teacher selectById(String id) {
        return id2Model.get(id);
    }

    public List<Teacher> selectByClassroomId(String classroomId) {
        return classroomId2Teachers.get(classroomId);
    }

    @Override
    public Teacher columnsToModel(Map<String, String> columns) {
        Teacher teacher = new Teacher();
        teacher.setId(columns.get("id"));
        teacher.setFirst_name(columns.get("first_name"));
        teacher.setLast_name(columns.get("last_name"));
        teacher.setClassroom_id(columns.get("classroom_id"));
        teacher.setPassword(columns.get("password"));

        classroomId2Teachers.computeIfAbsent(teacher.getClassroom_id(), k -> new ArrayList<>());
        classroomId2Teachers.get(teacher.getClassroom_id()).add(teacher);
        return teacher;
    }

    @Override
    public List<String> modelToColumns(Teacher teacher) {
        return Arrays.asList(teacher.getId(), teacher.getFirst_name(), teacher.getLast_name(), teacher.getClassroom_id(),
            teacher.getPassword());
    }

    private TeacherRepository() {
    }
}
