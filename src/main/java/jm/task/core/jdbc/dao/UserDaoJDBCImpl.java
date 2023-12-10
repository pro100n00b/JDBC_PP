package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final String nameForDb = "root";
    private final String pass = "1234";
    private final String url = "jdbc:mysql://localhost:3306/mysql";

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        try (Connection con = DriverManager.getConnection(url, nameForDb, pass);
             Statement db = con.createStatement()) {
            db.execute("CREATE TABLE IF NOT EXISTS users ( id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(30), lastname VARCHAR(30), age INTEGER(3) )");

        } catch (SQLException e) {

        }

    }

    public void dropUsersTable() {
        try (Connection con = DriverManager.getConnection(url, nameForDb, pass);
             Statement db = con.createStatement()) {
            db.execute("DROP TABLE users");

        } catch (SQLException e) {

        }

    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection con = DriverManager.getConnection(url, nameForDb, pass)) {
            PreparedStatement db = con.prepareStatement("INSERT INTO users (name, lastname, age) VALUES (?, ?, ?)");
            db.setString(1, name);
            db.setString(2, lastName);
            db.setInt(3, age);
            db.execute();
            System.out.printf("User с именем – %s добавлен в базу данных " + "\n", name);
        } catch (SQLException e) {

        }


    }

    public void removeUserById(long id) {
        try (Connection con = DriverManager.getConnection(url, nameForDb, pass);
             Statement db = con.createStatement()) {
            db.execute("DELETE FROM users WHERE id = " + id);

        } catch (SQLException e) {

        }

    }

    public List<User> getAllUsers() {
        ArrayList<User> result = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, nameForDb, pass);

             Statement db = con.createStatement()) {
            ResultSet data = db.executeQuery("SELECT * FROM users");

            while (data.next()) {
                Long id = data.getLong(1);
                String n = data.getNString(2);
                String lN = data.getNString(3);
                Byte age = data.getByte(4);
                User you = new User();
                you.setAge(age);
                you.setLastName(lN);
                you.setName(n);
                you.setId(Long.valueOf(id));
                result.add(you);

            }
            return result;
        } catch (SQLException e) {
            return null;
        }


    }


    public void cleanUsersTable() {
        try (Connection con = DriverManager.getConnection(url, nameForDb, pass);
             Statement db = con.createStatement()) {
            db.execute("TRUNCATE TABLE users");

        } catch (SQLException e) {

        }

    }
}
