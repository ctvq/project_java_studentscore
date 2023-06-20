package src.Manager_Score.HandleSQL;

import src.Manager_Score.ClassJava.DAOinterface;
import src.Manager_Score.ClassJava.course;
import src.Manager_Score.ClassJava.users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CourseDAO implements DAOinterface<course> {

    @Override
    public int insert(course course) throws SQLException {
        Connection conn = ConnectDatabase.Connect();
        try {
            Statement statement = conn.createStatement();
            String sql ="INSERT INTO course(course_name,course_id) "+"values " +
                    "("+"'"+course.getCourse_name()+"',"+
                    "'"+course.getCourse_id()+"')";
            System.out.println(sql);
            int kq =  statement.executeUpdate(sql);
            if(kq!=0) System.out.println("Update successfully !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        conn.close();
        return 0;
    }

    @Override
    public int update(course course) {
        return 0;
    }

    @Override
    public int delete(course course) {
        return 0;
    }

    @Override
    public ArrayList<course> selectAll() {
        return null;
    }

    @Override
    public course selectById(course course) {
        return null;
    }

    @Override
    public ArrayList<course> selectByCondition(String condition) {
        return null;
    }
}
