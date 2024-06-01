/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.MahasiswaController;
import model.Mahasiswa;

import javax.swing.*;
import java.awt.*;
import java.util.List;


/**
 *
 * @author Nazlya
 */
public class MahasiswaView extends JFrame {
    private final JTextField nimField;
    private final JTextField namaField;
    private final JRadioButton lakiRadioButton;
    private final JRadioButton perempuanRadioButton;
    private final JTextField emailField;
    private final JComboBox<String> provinsiComboBox;
    private final JTextArea alamatArea;
    private final JTable mahasiswaTable;
    private final MahasiswaController controller;

    public MahasiswaView() {
        controller = new MahasiswaController(this);
        setTitle("Mahasiswa");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 2));

        panel.add(new JLabel("NIM:"));
        nimField = new JTextField();
        panel.add(nimField);

        panel.add(new JLabel("Nama:"));
        namaField = new JTextField();
        panel.add(namaField);

        panel.add(new JLabel("Jenis Kelamin:"));
        JPanel genderPanel = new JPanel();
        lakiRadioButton = new JRadioButton("Laki-laki");
        perempuanRadioButton = new JRadioButton("Perempuan");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(lakiRadioButton);
        genderGroup.add(perempuanRadioButton);
        genderPanel.add(lakiRadioButton);
        genderPanel.add(perempuanRadioButton);
        panel.add(genderPanel);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("Provinsi:"));
        String[] provinsi = {"Jawa Timur", "Jawa Barat", "Jawa Tengah", "Sumatra", "Kalimantan"};
        provinsiComboBox = new JComboBox<>(provinsi);
        panel.add(provinsiComboBox);

        panel.add(new JLabel("Alamat:"));
        alamatArea = new JTextArea();
        panel.add(new JScrollPane(alamatArea));

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> addMahasiswa());
        panel.add(addButton);

        mahasiswaTable = new JTable();
        refreshTable(controller.getAllMahasiswa());

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(mahasiswaTable), BorderLayout.CENTER);

        setVisible(true);
    }

    private void addMahasiswa() {
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNim(nimField.getText());
        mahasiswa.setNama(namaField.getText());
        mahasiswa.setJenisKelamin(lakiRadioButton.isSelected() ? "Laki-laki" : "Perempuan");
        mahasiswa.setEmail(emailField.getText());
        mahasiswa.setProvinsi((String) provinsiComboBox.getSelectedItem());
        mahasiswa.setAlamat(alamatArea.getText());
        controller.addMahasiswa(mahasiswa);
    }

    public void refreshTable(List<Mahasiswa> list) {
        String[] columnNames = {"NIM", "Nama", "Jenis Kelamin", "Email", "Provinsi", "Alamat"};
        String[][] data = new String[list.size()][6];
        for (int i = 0; i < list.size(); i++) {
            Mahasiswa m = list.get(i);
            data[i][0] = m.getNim();
            data[i][1] = m.getNama();
            data[i][2] = m.getJenisKelamin();
            data[i][3] = m.getEmail();
            data[i][4] = m.getProvinsi();
            data[i][5] = m.getAlamat();
        }
        mahasiswaTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }
}