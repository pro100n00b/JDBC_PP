package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    public Connection getConnectionJDBC()  {
        String URL = "jdbc:mysql://localhost:3306/mysql";
        String USER = "root";
        String PASS = "1234";
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
