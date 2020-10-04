package edu.neu.csye6200.data;

import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.util.FileIO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.neu.csye6200.model.*;

public class StudentData {
	public List<Map<String, String>> getDataList() {

		List<Map<String, String>> students = FileIO.readFile("Student.csv");

		return students;
	}

	public Map<String, String> getDataList(int i) {
		
		List<Map<String, String>> stu = this.getDataList();
		Map<String, String> student = null;
		String str = String.valueOf(i);
		
		for (Map<String, String> map : stu) {
			if (map.get("id").equals(str)) {
				student = map;
				break;

			}

		}
		return student;
	}
	
	public int getDataList(String Tid) {
		
		List<Map<String, String>> stu = this.getDataList();
		Map<String, String> student = null;
		
		int i=0;
		for (Map<String, String> map : stu) {
			if (map.get("teacher_id").equals(Tid)) {
				student = map;
				i=i+1;

			}

		}
		return i;
	}
	
//	public List<String> getDataList(String Cid) {
//		
//		List<Map<String, String>> stu = this.getDataList();
//		List<String> l=new ArrayList<>();
//		Map<String, String> student = null;
//		String Tid=null;
//		int i=0;
//		for (Map<String, String> map : stu) {
//			if (map.get("classroom_id").equals(Cid)) {
//				Tid= map.get("teacher_id");
//				l.add(Tid);
//
//			}
//
//		}
//		return l;
//	}
	public void upDataList(Student student) {
		List<Student> students = new ArrayList<>();
		for(Map<String,String> map: getDataList()) {
			if(map.get("id").equals(student.getId())) {
				students.add(student);
			}else {
				students.add(new Student(map.get("first_name"),map.get("last_name"),map.get("id"),map.get("teacher_id"),map.get("classroom_id"),map.get("teacher_name"),map.get("age"),map.get("father_name"),
						map.get("mother_name"),map.get("Hib"),map.get("DTaP"),map.get("Polio"),map.get("Hepatitis B"), map.get("MMR"), map.get("Varicella")));
			}
			
			
		}
		FileIO.writeFile(students, "student.csv");
	}
	
	public void apendDataList(Student student) {
		List<Student> students = new ArrayList<>();
		for(Map<String,String> map: getDataList()) {
				students.add(new Student(map.get("first_name"),map.get("last_name"),map.get("id"),map.get("teacher_id"),map.get("classroom_id"),map.get("teacher_name"),map.get("age"),map.get("father_name"),
						map.get("mother_name"),map.get("Hib"),map.get("DTaP"),map.get("Polio"),map.get("Hepatitis B"), map.get("MMR"), map.get("Varicella")));
			
		}
		students.add(new Student(student.getFirst_name(),student.getLast_name(),student.getId(),student.getTeacher_id(),student.getClassroom_id(),student.getTeacher_name(),student.getAge(),student.getFather_name(),
				student.getMother_name(),student.getHib(),student.getDTaP(),student.getPolio(),student.getHepatitis_B(), student.getMMR(), student.getVaricella()));
	
		FileIO.writeFile(students, "student.csv");
	}
}
