/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.NilaiController;
import model.Nilai;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 *
 * @author Nazlya
 */
public class NilaiView extends JFrame {
    private final JTextField nimField;
    private final JTextField tugasField;
    private final JTextField utsField;
    private final JTextField uasField;
    private final JTextField praktikumField;
    private final JCheckBox praktikumCheckBox;
    private final JTable nilaiTable;
    private final NilaiController controller;

    public NilaiView() {
        controller = new NilaiController(this);
        setTitle("Nilai Mahasiswa");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2));

        panel.add(new JLabel("NIM:"));
        nimField = new JTextField();
        panel.add(nimField);

        panel.add(new JLabel("Nilai Tugas:"));
        tugasField = new JTextField();
        panel.add(tugasField);

        panel.add(new JLabel("Nilai UTS:"));
        utsField = new JTextField();
        panel.add(utsField);

        panel.add(new JLabel("Nilai UAS:"));
        uasField = new JTextField();
        panel.add(uasField);

        panel.add(new JLabel("Nilai Praktikum:"));
        praktikumField = new JTextField();
        panel.add(praktikumField);

        praktikumCheckBox = new JCheckBox("Ada nilai praktikum?");
        panel.add(praktikumCheckBox);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> addNilai());
        panel.add(addButton);

        nilaiTable = new JTable();
        refreshTable(controller.getAllNilai());

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(nilaiTable), BorderLayout.CENTER);

        setVisible(true);
    }

    private void addNilai() {
        Nilai nilai = new Nilai();
        nilai.setNim(nimField.getText());
        nilai.setNilaiTugas(Double.parseDouble(tugasField.getText()));
        nilai.setNilaiUts(Double.parseDouble(utsField.getText()));
        nilai.setNilaiUas(Double.parseDouble(uasField.getText()));
        if (praktikumCheckBox.isSelected()) {
            nilai.setNilaiPraktikum(Double.parseDouble(praktikumField.getText()));
            nilai.setNilaiAkhir(nilai.getNilaiTugas() * 0.1 + nilai.getNilaiUts() * 0.3 + nilai.getNilaiUas() * 0.3 + nilai.getNilaiPraktikum() * 0.3);
        } else {
            nilai.setNilaiAkhir(nilai.getNilaiTugas() * 0.3 + nilai.getNilaiUts() * 0.35 + nilai.getNilaiUas() * 0.35);
        }
        controller.addNilai(nilai);
    }

    public void refreshTable(List<Nilai> list) {
        String[] columnNames = {"NIM", "Nilai Tugas", "Nilai UTS", "Nilai UAS", "Nilai Praktikum", "Nilai Akhir"};
        String[][] data = new String[list.size()][6];
        for (int i = 0; i < list.size(); i++) {
            Nilai n = list.get(i);
            data[i][0] = n.getNim();
            data[i][1] = String.valueOf(n.getNilaiTugas());
            data[i][2] = String.valueOf(n.getNilaiUts());
            data[i][3] = String.valueOf(n.getNilaiUas());
            data[i][4] = String.valueOf(n.getNilaiPraktikum());
            data[i][5] = String.valueOf(n.getNilaiAkhir());
        }
        nilaiTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }
}
