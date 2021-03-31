package org.example.dao.Impl;

import org.example.dao.MahasiswaDao;
import org.example.db.DBConnection;
import org.example.entities.Mahasiswa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaDaoImpl implements MahasiswaDao {

    private Connection connection;

    @Override
    public Mahasiswa getMahasiswa(String nim) {
        Mahasiswa mahasiswa = null;
        connection=DBConnection.getConnection();
        try {
            Statement statement=connection.createStatement();
            ResultSet resultSet= statement.executeQuery("SELECT NIM, NAMA, ALAMAT, FAKULTAS FROM TB_MAHASISWA WHERE NIM='"+nim+"'");
           while (resultSet.next()){
            mahasiswa=new Mahasiswa();
            mahasiswa.setNim(resultSet.getString(1));
            mahasiswa.setNama(resultSet.getString(2));
            mahasiswa.setAlamat(resultSet.getString(3));
            mahasiswa.setFakultas(resultSet.getString(4));
           }

           connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    return  mahasiswa;
    }

    @Override
    public Mahasiswa insertMahasiswa(Mahasiswa mahasiswa) {
        connection=DBConnection.getConnection();
        try {
            Statement statement=connection.createStatement();
            statement.executeUpdate("INSERT INTO TB_MAHASISWA VALUES('"+mahasiswa.getNim()+"','"+mahasiswa.getNama()+"','"+mahasiswa.getAlamat()+"','"+mahasiswa.getFakultas()+"')");
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return mahasiswa;
    }

    @Override
    public Mahasiswa updateMahasiswa(Mahasiswa mahasiswa) {
        connection=DBConnection.getConnection();
        try {
            Statement statement=connection.createStatement();
            statement.executeUpdate("UPDATE TB_MAHASISWA SET NAMA='"+mahasiswa.getNama()+"',ALAMAT='"+mahasiswa.getAlamat()+"',FAKULTAS='"+mahasiswa.getFakultas()+"' WHERE NIM='"+mahasiswa.getNim()+"'");
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return mahasiswa;
    }

    @Override
    public Mahasiswa deleteMahasiswa(Mahasiswa mahasiswa) {
        connection=DBConnection.getConnection();
        try {
            Statement statement=connection.createStatement();
            statement.executeUpdate("DELETE FROM TB_MAHASISWA WHERE NIM='"+mahasiswa.getNim()+"'");
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return mahasiswa;
    }

    @Override
    public List<Mahasiswa> getListMahasiswa() {
        List<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();

        connection=DBConnection.getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement("ELECT NIM, NAMA, ALAMAT, FAKULTAS FROM TB_MAHASISWA");
            //Statement statement=connection.createStatement();
            ResultSet resultSet= ps.executeQuery("SELECT NIM, NAMA, ALAMAT, FAKULTAS FROM TB_MAHASISWA");
            while (resultSet.next()){
               Mahasiswa mahasiswa=new Mahasiswa();
                mahasiswa.setNim(resultSet.getString("NIM"));
                mahasiswa.setNama(resultSet.getString("NAMA"));
                mahasiswa.setAlamat(resultSet.getString("ALAMAT"));
                mahasiswa.setFakultas(resultSet.getString("FAKULTAS"));
                mahasiswaList.add(mahasiswa);
            }

            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return mahasiswaList;
    }
}
