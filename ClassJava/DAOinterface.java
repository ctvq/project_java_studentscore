package src.Manager_Score.ClassJava;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAOinterface<T> {
    public int insert(T t) throws SQLException;
    public int update(T t);
    public int delete(T t);
    public ArrayList<T> selectAll();
    public T selectById(T t);
    public ArrayList<T> selectByCondition(String condition);
}
