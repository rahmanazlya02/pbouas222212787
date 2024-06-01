/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoImpl;
import dao.UserDAO;
import model.User;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.HashUtil;

/**
 *
 * @author Nazlya
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public User getUser(String username) {
        User user = null;
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM user WHERE username=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        user = new User();
                        user.setUsername(resultSet.getString("username"));
                        user.setPassword(resultSet.getString("password"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

@Override
public void insert(User user) {
    try (Connection connection = DatabaseConnection.getConnection()) {
        String query = "INSERT INTO user (username, password) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getUsername());
            String hashedPassword = HashUtil.hashPassword(user.getPassword()); // Menggunakan HashUtil.hashPassword()
            statement.setString(2, hashedPassword); // Menyimpan kata sandi yang sudah dienkripsi
            statement.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}
