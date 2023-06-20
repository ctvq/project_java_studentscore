package src.Manager_Score.HandleSQL;

import src.Manager_Score.ClassJava.DAOinterface;
import src.Manager_Score.ClassJava.question;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QuestionDAO implements DAOinterface<question> {

    @Override
    public int insert(question question) throws SQLException {
        Connection conn = ConnectDatabase.Connect();
        try {
            Statement statement = conn.createStatement();
            String sql ="INSERT INTO question(question_id,question_content,question_point) "+"values " +
                    "("+"'"+question.getQuestion_id()+"',"+
                    "'"+question.getQuestion_content()+"',"+
                    "'"+question.getQuestion_point()+"')";
            System.out.println(sql);
            int kq =  statement.executeUpdate(sql);
            if(kq!=0) System.out.println("Insert successfully !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        conn.close();
        return 0;
    }

    @Override
    public int update(question question) {
        return 0;
    }

    @Override
    public int delete(question question) {
        return 0;
    }

    @Override
    public ArrayList<question> selectAll() {
        return null;
    }

    @Override
    public question selectById(question question) {
        return null;
    }

    @Override
    public ArrayList<question> selectByCondition(String condition) {
        return null;
    }
}
