package src.Manager_Score.HandleSQL;

import src.Manager_Score.ClassJava.DAOinterface;
import src.Manager_Score.ClassJava.examination_nn_question;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Examination_nn_QuestionDAO implements DAOinterface<examination_nn_question> {


    @Override
    public int insert(examination_nn_question examinationNnQuestion) throws SQLException {
        Connection conn = ConnectDatabase.Connect();
        try {
            Statement statement = conn.createStatement();
            String sql ="INSERT INTO examination_nn_question(question_id,examination_id) "+
                    "values " +
                    "("+"'"+examinationNnQuestion.getQuestion_id()+"',"+
                    "'"+examinationNnQuestion.getExamination_id()+
                    "')";
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
    public int update(examination_nn_question examinationNnQuestion) {
        return 0;
    }

    @Override
    public int delete(examination_nn_question examinationNnQuestion) {
        return 0;
    }

    @Override
    public ArrayList<examination_nn_question> selectAll() {
        return null;
    }

    @Override
    public examination_nn_question selectById(examination_nn_question examinationNnQuestion) {
        return null;
    }

    @Override
    public ArrayList<examination_nn_question> selectByCondition(String condition) {
        return null;
    }
}
