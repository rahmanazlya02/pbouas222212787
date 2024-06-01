/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UserDAO;
import daoImpl.UserDAOImpl;
import model.User;
import util.HashUtil;
import view.LoginView;
import view.HomeView;

import javax.swing.*;

/**
 *
 * @author Nazlya
 */
public class LoginController {
    private final LoginView view;
    private final UserDAO userDAO;

    public LoginController(LoginView view) {
        this.view = view;
        this.userDAO = new UserDAOImpl();
    }

    public void login() {
        String username = view.getUsername();
        String password = view.getPassword(); // Menggunakan HashUtil.hashPassword()
        User user = userDAO.getUser(username);
        if (user != null && user.getPassword().equals(password)) { // Membandingkan dengan kata sandi yang dienkripsi dari database
            JOptionPane.showMessageDialog(view, "Login successful!");
            view.dispose();
            new HomeView();
        } else {
            JOptionPane.showMessageDialog(view, "Invalid username or password!");
        }
    }
}
