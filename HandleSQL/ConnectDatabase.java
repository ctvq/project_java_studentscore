package src.Manager_Score.HandleSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    public static Connection Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/managerschool";
            String user = "root";
            String pass = "123456";
            Connection conn = DriverManager.getConnection(url, user, pass);
            if (conn != null) {
                System.out.println("Data connection successfully !");
                return conn;
            } else System.out.println("Data connection failed");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
