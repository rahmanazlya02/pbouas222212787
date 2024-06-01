/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;
import model.Nilai;
import java.util.List;
/**
 *
 * @author Nazlya
 */
public interface NilaiDAO {
    void insert(Nilai nilai);
    void update(Nilai nilai);
    void delete(String nim);
    List<Nilai> getAll();
}
