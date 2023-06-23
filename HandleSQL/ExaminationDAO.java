package src.Manager_Score.HandleSQL;

import src.Manager_Score.ClassJava.DAOinterface;
import src.Manager_Score.ClassJava.examination;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ExaminationDAO implements DAOinterface<examination> {

    @Override
    public int insert(examination examination) throws SQLException {
        Connection conn = ConnectDatabase.Connect();
        try {
            Statement statement = conn.createStatement();
            String sql ="INSERT INTO examination(examination_id,examination_name,examination_starttime,examination_duration,course_id) "+"values " +
                    "("+"'"+examination.getExamination_id()+"',"+
                    "'"+examination.getExamination_name()+"',"+
                    "'"+examination.getExamination_starttime()+"',"+
                    "'"+examination.getExamination_duration()+"',"+
                    "'"+examination.getCourse_id()+"')";
            System.out.println(sql);
            int kq =  statement.executeUpdate(sql);
            if(kq!=0) System.out.println("Update successfully !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        conn.close();
        return 0;
    }

    @Override
    public int update(examination examination) {
        return 0;
    }

    @Override
    public int delete(examination examination) {
        return 0;
    }

    @Override
    public ArrayList<examination> selectAll() {
        return null;
    }

    @Override
    public examination selectById(examination examination) {
        return null;
    }

    @Override
    public ArrayList<examination> selectByCondition(String condition) {
        return null;
    }
}
