/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Nazlya
 */

public class HomeView extends JFrame {
    public HomeView() {
        setTitle("Home");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem mahasiswaItem = new JMenuItem("Mahasiswa");
        mahasiswaItem.addActionListener(e -> new MahasiswaView());
        menu.add(mahasiswaItem);

        JMenuItem nilaiItem = new JMenuItem("Nilai Mahasiswa");
        nilaiItem.addActionListener(e -> new NilaiView());
        menu.add(nilaiItem);

        menuBar.add(menu);
        setJMenuBar(menuBar);

        setVisible(true);
    }
}
