/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;
import model.User;
/**
 *
 * @author Nazlya
 */
public interface UserDAO {
    User getUser(String username);
    void insert(User user);
}
