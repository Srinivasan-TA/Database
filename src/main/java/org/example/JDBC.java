package org.example;

import java.sql.*;

class DC {


    public static void main(String args[]) throws SQLException {
        DC n = DC.getInstance();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Srini@067");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from student");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
                System.out.println("DB Connection Working");
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        public static DC getInstance() throws SQLException {
            if (instance == null) {
                instance = new DC();
            }
            return instance;
        }

    }
