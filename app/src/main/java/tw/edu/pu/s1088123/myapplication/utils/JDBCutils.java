package tw.edu.pu.s1088123.myapplication.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCutils {
    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }   catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    }

    public static Connection getcon(){
        Connection conn = null;
        try {
            conn =DriverManager.getConnection("jdbc:mysql:\\10.0.2.2:3306/graute_project,user:"root",password:"0000");
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return conn;
    }
        public static void close(Connection conn){
        try {
            conn.close();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        }

}
