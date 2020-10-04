
package edu.neu.csye6200.repository;

import edu.neu.csye6200.model.Classroom;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Congcong
 * @version $ Id: ClassroomRepository.java, v 0.1 2020年08月11日 4:49 下午 Congcong Exp $
 */
public class ClassroomRepository extends BaseRepository<Classroom> {

    private static final ClassroomRepository INSTANCE = new ClassroomRepository();

    private final StudentRepository studentRepository = StudentRepository.getInstance();
    private final TeacherRepository teacherRepository = TeacherRepository.getInstance();

    static {
        INSTANCE.loadFromCsv("classroom.csv");
    }

    public static ClassroomRepository getInstance() {
        return INSTANCE;
    }

    public Classroom selectById(String id) {
        if (!id2Model.containsKey(id)) {
            return null;
        }
        Classroom classroom = id2Model.get(id);
        classroom.setStudentList(studentRepository.selectByClassroomId(id));
        classroom.setTeacherList(teacherRepository.selectByClassroomId(id));
        return classroom;
    }

    public Classroom columnsToModel(Map<String, String> columns) {
        Classroom classroom = new Classroom();
        classroom.setId(columns.get("id"));
        classroom.setMinAge(Integer.parseInt(columns.get("min_age")));
        String maxAge = columns.get("max_age");
        classroom.setMaxAge(maxAge == null || maxAge.length() == 0 ? null : Integer.parseInt(maxAge));
        classroom.setMaxSize(Integer.parseInt(columns.get("max_size")));
        return classroom;
    }

    @Override
    public List<String> modelToColumns(Classroom classroom) {
        return Arrays.asList(classroom.getId(), classroom.getMinAge().toString(),
            classroom.getMaxAge() == null ? null : classroom.getMaxAge().toString(),
            classroom.getMaxSize().toString());
    }

    private ClassroomRepository() {
    }
}
