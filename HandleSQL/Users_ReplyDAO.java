package src.Manager_Score.HandleSQL;

import src.Manager_Score.ClassJava.DAOinterface;
import src.Manager_Score.ClassJava.users_reply;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Users_ReplyDAO implements DAOinterface<users_reply> {
    @Override
    public int insert(users_reply usersReply) throws SQLException {
        Connection conn = ConnectDatabase.Connect();
        try {
            Statement statement = conn.createStatement();
            String sql ="INSERT INTO users_reply(users_reply_id,users_id,question_id,answer_id) "+"values " +
                    "("+"'"+usersReply.getUsers_reply_id()+"',"+
                    "("+"'"+usersReply.getUsers_id()+"',"+
                    "("+"'"+usersReply.getQuestion_id()+"',"+
                    "("+"'"+usersReply.getAnswer_id()+ "')";
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
    public int update(users_reply usersReply) {
        return 0;
    }

    @Override
    public int delete(users_reply usersReply) {
        return 0;
    }

    @Override
    public ArrayList<users_reply> selectAll() {
        return null;
    }

    @Override
    public users_reply selectById(users_reply usersReply) {
        return null;
    }

    @Override
    public ArrayList<users_reply> selectByCondition(String condition) {
        return null;
    }
}
