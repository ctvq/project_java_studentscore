package src.Manager_Score.HandleSQL;

import src.Manager_Score.ClassJava.DAOinterface;
import src.Manager_Score.ClassJava.answer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AnswerDAO implements DAOinterface<answer> {

    @Override
    public int insert(answer answer) throws SQLException {
        Connection conn = ConnectDatabase.Connect();
        try {
            Statement statement = conn.createStatement();
            String sql ="INSERT INTO answer(answer_id,answer_replycontent,answer_yesno,question_id) "+
                    "values " +
                    "("+"'"+answer.getAnswer_id()+"',"+
                    "'"+answer.getAnswer_replycontent()+"',"+
                    "'"+answer.getAnswer_yesno()+"',"+
                    "'"+answer.getQuestion_id()+
                    "')";
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
    public int update(answer answer) {
        return 0;
    }

    @Override
    public int delete(answer answer) {
        return 0;
    }

    @Override
    public ArrayList<answer> selectAll() {
        return null;
    }

    @Override
    public answer selectById(answer answer) {
        return null;
    }

    @Override
    public ArrayList<answer> selectByCondition(String condition) {
        return null;
    }
}
