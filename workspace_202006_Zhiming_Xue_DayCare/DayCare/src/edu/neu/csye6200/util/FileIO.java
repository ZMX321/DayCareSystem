package edu.neu.csye6200.util;

import java.io.*;
import java.util.*;

public class FileIO {

    public static <T> void writeFile(List<T> data,  String fileName) {
    	String filePath = "src/main/java/resources/" + fileName;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath)))) {
        	bw.append("nothing,first_name,last_name,id,classroom_id,teacher_name,teacher_id,age,father_name,mother_name,Hib,DTaP,Polio,Hepatitis B,MMR,Varicella");
        	bw.newLine();
            for (T t : data) {
                bw.append(t.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeFileAppended(String fileName, List<String> columns) {
        String filePath = "src/main/java/resources/" + fileName;
        StringBuilder output = new StringBuilder();
        Iterator<String> iterator = columns.iterator();
        while (iterator.hasNext()) {
            String column = iterator.next();
            if (column != null) {
                output.append(column);
            }
            if (iterator.hasNext()) {
                output.append(",");
            }
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath), true))) {
            bw.newLine();
            bw.append(output.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
  

    public static <T> void writeFileAppended(List<T> data, String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName), true))) {
            for (T t : data) {
                bw.append(t.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Map<String, String>> readFile(String fileName) {
        List<Map<String, String>> data = new ArrayList<>();
        String filePath = "src/main/java/resources/" + fileName;
        try (BufferedReader inLine = new BufferedReader(new FileReader(filePath))) {
            String inputLine;    // read one line from file at a time
            String[] fieldNames;
            if ((inputLine = inLine.readLine()) != null) {
                fieldNames = inputLine.split(",");
            } else {
                return null;
            }
            while ((inputLine = inLine.readLine()) != null) {
                // Parse line converting each string token into a Student object field
                Map<String, String> map = new HashMap<>();
                String[] fields = inputLine.split(",");
                for (int i = 0; i < fieldNames.length; i++) {
                    if (i >= fields.length) {
                        // 防止null时数组越界
                        map.put(fieldNames[i], null);
                    } else {
                        map.put(fieldNames[i], fields[i]);
                    }
                }
                data.add(map);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
