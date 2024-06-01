/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.MahasiswaDAO;
import daoImpl.MahasiswaDAOImpl;
import java.io.File;
import model.Mahasiswa;
import view.MahasiswaView;

import java.util.List;
import util.ExportUtil;

/**
 *
 * @author Nazlya
 */
public class MahasiswaController {
    private final MahasiswaView view;
    private final MahasiswaDAO mahasiswaDAO;

    public MahasiswaController(MahasiswaView view) {
        this.view = view;
        this.mahasiswaDAO = new MahasiswaDAOImpl();
    }

    public void addMahasiswa(Mahasiswa mahasiswa) {
        mahasiswaDAO.insert(mahasiswa);
        view.refreshTable(mahasiswaDAO.getAll());
    }

    public void updateMahasiswa(Mahasiswa mahasiswa) {
        mahasiswaDAO.update(mahasiswa);
        view.refreshTable(mahasiswaDAO.getAll());
    }

    public void deleteMahasiswa(String nim) {
        mahasiswaDAO.delete(nim);
        view.refreshTable(mahasiswaDAO.getAll());
    }

    public List<Mahasiswa> getAllMahasiswa() {
        return mahasiswaDAO.getAll();
    }
    
    
}
