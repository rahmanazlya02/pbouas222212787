/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.NilaiDAO;
import daoImpl.NilaiDAOImpl;
import model.Nilai;
import view.NilaiView;

import java.util.List;

/**
 *
 * @author Nazlya
 */
public class NilaiController {
    private final NilaiView view;
    private final NilaiDAO nilaiDAO;

    public NilaiController(NilaiView view) {
        this.view = view;
        this.nilaiDAO = new NilaiDAOImpl();
    }

    public void addNilai(Nilai nilai) {
        nilaiDAO.insert(nilai);
        view.refreshTable(nilaiDAO.getAll());
    }

    public void updateNilai(Nilai nilai) {
        nilaiDAO.update(nilai);
        view.refreshTable(nilaiDAO.getAll());
    }

    public void deleteNilai(String nim) {
        nilaiDAO.delete(nim);
        view.refreshTable(nilaiDAO.getAll());
    }

    public List<Nilai> getAllNilai() {
        return nilaiDAO.getAll();
    }
}
