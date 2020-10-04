
package edu.neu.csye6200.repository;

import edu.neu.csye6200.model.Model;
import edu.neu.csye6200.util.FileIO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Congcong
 * @version $ Id: BaseRepository.java, v 0.1 2020年08月11日 4:50 下午 Congcong Exp $
 */
public abstract class BaseRepository<T extends Model> {

    final Map<String, T> id2Model = new HashMap<>();

    public void loadFromCsv(String fileName) {
        List<Map<String, String>> lines = FileIO.readFile(fileName);
        if (lines == null) {
            return;
        }
        for (Map<String, String> columns : lines) {
            T t = columnsToModel(columns);
            id2Model.put(t.getId(), t);
        }
    }

    public void saveToCsv(String fileName, T t) {
        FileIO.writeFileAppended(fileName, modelToColumns(t));
    }

    public abstract T columnsToModel(Map<String, String> columns);

    public abstract List<String> modelToColumns(T t);
}
