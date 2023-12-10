package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class
Main {
    public static void main(String[] args) {
        UserService db = new UserServiceImpl();
        db.createUsersTable();
        db.saveUser("Vasya", "Pypkin", Byte.parseByte("12"));
        db.saveUser("Petya", "Zapypkin", Byte.parseByte("16"));
        db.saveUser("Fedor", "Chipsik", Byte.parseByte("24"));
        db.saveUser("Plyton", "Greben", Byte.parseByte("22"));
        System.out.println(db.getAllUsers());
        db.cleanUsersTable();
        db.dropUsersTable();
        db.dropUsersTable();

    }
}
