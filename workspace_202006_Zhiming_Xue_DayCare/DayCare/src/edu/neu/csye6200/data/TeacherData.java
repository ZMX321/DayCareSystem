package edu.neu.csye6200.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.neu.csye6200.util.FileIO;

public class TeacherData {
	

	public List<Map<String, String>> getDataList(){
		
		List<Map<String, String>> teachers = FileIO.readFile("Teacher.csv");
	
		return teachers;
		}
	
	
	public Map<String, String> getDataList(int i){
		List<Map<String, String>> allteachers = this.getDataList();
		Map<String, String> teacher = null;
		String str = String.valueOf(i);
		
		for(Map<String,String> map : allteachers) {
			if(map.get("id").equals(str)) {
				teacher = map;
				break;
			}
		}
		return teacher;
	}
	
	public String[] getDataList(String Cid,int x) {
		
		List<Map<String, String>> tea = this.getDataList();
		String[] str=new String[x];
		Map<String, String> teacher = null;
		String Tid=null;
		int i=0;
		for (Map<String, String> map : tea) {
			if (map.get("classroom_id").equals(Cid)) {
				Tid= map.get("id");
				str[i]=Tid;
				i=i+1;

			}

		}
		return str;
	}
}
