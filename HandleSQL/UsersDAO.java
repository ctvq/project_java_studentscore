package src.Manager_Score.HandleSQL;

import src.Manager_Score.ClassJava.DAOinterface;
import src.Manager_Score.ClassJava.Main;
import src.Manager_Score.ClassJava.users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsersDAO implements DAOinterface<users> {
    public  static UsersDAO getInstance(){
    return new  UsersDAO();
}

    @Override
    public int insert(users users) throws SQLException {
        Connection conn=ConnectDatabase.Connect();
        try {
            Statement statement = conn.createStatement();
            String sql ="INSERT INTO users(users_id,users_name,users_password," +
                    "users_age,users_gender,users_fullname) "+"values " +
                    "("+"'"+users.getUsers_id()+"',"+
                    "'"+users.getUsers_name()+"',"+
                    "'"+users.getUsers_password()+"',"+
                    "'"+users.getUsers_age()+"',"+
                    "'"+users.getUsers_gender()+"',"+
                    "'"+users.getUsers_fullname()+"')";
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
    public int update(users users) {
        return 0;
    }

    @Override
    public int delete(users users) {
        return 0;
    }

    @Override
    public ArrayList<users> selectAll() {
        return null;
    }

    @Override
    public users selectById(users users) {
        return null;
    }

    @Override
    public ArrayList<users> selectByCondition(String condition) {
        return null;
    }
}
