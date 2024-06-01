/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;
import model.Mahasiswa;
import java.util.List;

/**
 *
 * @author Nazlya
 */
public interface MahasiswaDAO {
    void insert(Mahasiswa mahasiswa);
    void update(Mahasiswa mahasiswa);
    void delete(String nim);
    List<Mahasiswa> getAll();
}
