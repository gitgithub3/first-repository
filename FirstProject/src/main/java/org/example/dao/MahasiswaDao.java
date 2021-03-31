package org.example.dao;

import org.example.entities.Mahasiswa;

import java.util.List;

public interface MahasiswaDao {

    public Mahasiswa getMahasiswa(String nim);

    public Mahasiswa insertMahasiswa(Mahasiswa mahasiswa);

    public Mahasiswa updateMahasiswa(Mahasiswa mahasiswa);

    public Mahasiswa deleteMahasiswa(Mahasiswa mahasiswa);

    public List<Mahasiswa> getListMahasiswa();
}
