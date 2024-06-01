/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoImpl;

import dao.NilaiDAO;
import model.Nilai;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nazlya
 */
public class NilaiDAOImpl implements NilaiDAO {
    @Override
    public void insert(Nilai nilai) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO nilai (nim, nilai_tugas, nilai_uts, nilai_uas, nilai_praktikum, nilai_akhir) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, nilai.getNim());
                statement.setDouble(2, nilai.getNilaiTugas());
                statement.setDouble(3, nilai.getNilaiUts());
                statement.setDouble(4, nilai.getNilaiUas());
                statement.setDouble(5, nilai.getNilaiPraktikum());
                statement.setDouble(6, nilai.getNilaiAkhir());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Nilai nilai) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE nilai SET nilai_tugas=?, nilai_uts=?, nilai_uas=?, nilai_praktikum=?, nilai_akhir=? WHERE nim=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setDouble(1, nilai.getNilaiTugas());
                statement.setDouble(2, nilai.getNilaiUts());
                statement.setDouble(3, nilai.getNilaiUas());
                statement.setDouble(4, nilai.getNilaiPraktikum());
                statement.setDouble(5, nilai.getNilaiAkhir());
                statement.setString(6, nilai.getNim());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String nim) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM nilai WHERE nim=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, nim);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Nilai> getAll() {
        List<Nilai> list = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM nilai";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    Nilai nilai = new Nilai();
                    nilai.setNim(resultSet.getString("nim"));
                    nilai.setNilaiTugas(resultSet.getDouble("nilai_tugas"));
                    nilai.setNilaiUts(resultSet.getDouble("nilai_uts"));
                    nilai.setNilaiUas(resultSet.getDouble("nilai_uas"));
                    nilai.setNilaiPraktikum(resultSet.getDouble("nilai_praktikum"));
                    nilai.setNilaiAkhir(resultSet.getDouble("nilai_akhir"));
                    list.add(nilai);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
