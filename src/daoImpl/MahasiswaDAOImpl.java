/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoImpl;
import dao.MahasiswaDAO;
import model.Mahasiswa;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Nazlya
 */
public class MahasiswaDAOImpl implements MahasiswaDAO {
    @Override
    public void insert(Mahasiswa mahasiswa) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO mahasiswa (nim, nama, jenis_kelamin, email, provinsi, alamat) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, mahasiswa.getNim());
                statement.setString(2, mahasiswa.getNama());
                statement.setString(3, mahasiswa.getJenisKelamin());
                statement.setString(4, mahasiswa.getEmail());
                statement.setString(5, mahasiswa.getProvinsi());
                statement.setString(6, mahasiswa.getAlamat());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Mahasiswa mahasiswa) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE mahasiswa SET nama=?, jenis_kelamin=?, email=?, provinsi=?, alamat=? WHERE nim=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, mahasiswa.getNama());
                statement.setString(2, mahasiswa.getJenisKelamin());
                statement.setString(3, mahasiswa.getEmail());
                statement.setString(4, mahasiswa.getProvinsi());
                statement.setString(5, mahasiswa.getAlamat());
                statement.setString(6, mahasiswa.getNim());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String nim) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM mahasiswa WHERE nim=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, nim);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Mahasiswa> getAll() {
        List<Mahasiswa> list = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM mahasiswa";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    Mahasiswa mahasiswa = new Mahasiswa();
                    mahasiswa.setNim(resultSet.getString("nim"));
                    mahasiswa.setNama(resultSet.getString("nama"));
                    mahasiswa.setJenisKelamin(resultSet.getString("jenis_kelamin"));
                    mahasiswa.setEmail(resultSet.getString("email"));
                    mahasiswa.setProvinsi(resultSet.getString("provinsi"));
                    mahasiswa.setAlamat(resultSet.getString("alamat"));
                    list.add(mahasiswa);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}