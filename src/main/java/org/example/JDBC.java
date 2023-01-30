package org.example;

import java.sql.*;
import java.util.*;
class DC {


    public static void main(String args[]) throws SQLException {
        DC n = DC.getInstance();

        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        System.out.println("Enter the password");
        Scanner sc = new Scanner(System.in);
        String pass = sc.next();
        Connection connection = DriverManager.getConnection(url, user, pass);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * from student");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
            System.out.println("DB Connection Working");
        }
        /*} catch (Exception e) {
            e.printStackTrace();
        }*/


        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                n.connect(url, user, pass);
                break;
            case 2:
                n.closeconnection();
                break;

            default:

                System.exit(0);
        }
    }
        private static DC instance=null;
        private Connection connection;
        public Connection getC() {
            return connection;
        }
public void connect(String url,String user,String pass){
    try {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, user, pass);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
        public void closeconnection(){
            closeconnection();
        }
        public static DC getInstance() throws SQLException {
            if (instance == null) {
                instance = new DC();
            }
            return instance;
        }

    }
