package src.Manager_Score.HandleSQL;

import src.Manager_Score.ClassJava.DAOinterface;
import src.Manager_Score.ClassJava.users_nn_course;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Users_nn_CourseDAO implements DAOinterface<users_nn_course> {

    @Override
    public int insert(users_nn_course usersNnCourse) throws SQLException {
        Connection conn = ConnectDatabase.Connect();
        try {
            Statement statement = conn.createStatement();
            String sql ="INSERT INTO users_nn_course(users_id_nn_course,users_id_nn,course_id_nn) "+"values " +
                    "("+"'"+usersNnCourse.getUsers_id_nn_course()+"',"+
                    "'"+usersNnCourse.getUsers_id_nn()+"',"+
                    "'"+usersNnCourse.getCourse_id_nn()+ "')";
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
    public int update(users_nn_course usersNnCourse) {
        return 0;
    }

    @Override
    public int delete(users_nn_course usersNnCourse) {
        return 0;
    }

    @Override
    public ArrayList<users_nn_course> selectAll() {
        return null;
    }

    @Override
    public users_nn_course selectById(users_nn_course usersNnCourse) {
        return null;
    }

    @Override
    public ArrayList<users_nn_course> selectByCondition(String condition) {
        return null;
    }
}
