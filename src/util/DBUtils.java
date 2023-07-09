package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/assignment2";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "Huyyuh00!";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
