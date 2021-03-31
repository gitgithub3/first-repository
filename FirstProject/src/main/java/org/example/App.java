package org.example;

import org.example.dao.Impl.MahasiswaDaoImpl;
import org.example.dao.MahasiswaDao;
import org.example.entities.Mahasiswa;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static MahasiswaDao mahasiswaDao;

    public static void main( String[] args )
    {
        boolean operasi=true;
        System.out.println( "Selamat Datang di Aplikasi Manajemen Mahasiswa!" );
        Scanner scanner=new Scanner(System.in);;
        Scanner scanner1=new Scanner(System.in);
        mahasiswaDao=new MahasiswaDaoImpl();
        String nimInput, nama, alamat, fakultas;
        Mahasiswa mahasiswa1=new Mahasiswa();
        while (operasi){
            System.out.println( "Pilih Operasi yang akan dilakukan pada data mahasiswa!" );
            System.out.println( "1-> Melihat List mahasiswa" );
            System.out.println( "2-> Melihat Detail Mahasiswa" );
            System.out.println( "3-> Insert Mahasiswa Baru" );
            System.out.println( "4-> Update Data Mahasiswa" );
            System.out.println( "5-> Delete Data Mahasiswa" );

            System.out.print( "Silahkan Masukkan Pilihan" );
            int choice=scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println( "Anda akan melihat List Mahasiswa" );

                    ArrayList<Mahasiswa> listMahasiswa= (ArrayList<Mahasiswa>) mahasiswaDao.getListMahasiswa();
                    for (Mahasiswa mahasiswa: listMahasiswa){
                        System.out.println(mahasiswa.getNim());
                        System.out.println(mahasiswa.getNama());
                        System.out.println(mahasiswa.getAlamat());
                        System.out.println(mahasiswa.getFakultas());
                    }
                    break;
                case 2:
                    System.out.println( "Anda akan melihat Detail Mahasiswa berdasarkan NIM" );
                    System.out.print( "Masukkan NIM yang dicari :" );
                    nimInput=scanner1.nextLine();
                    Mahasiswa mahasiswa=mahasiswaDao.getMahasiswa(nimInput);
                    System.out.println(mahasiswa.getNim());
                    System.out.println(mahasiswa.getNama());
                    System.out.println(mahasiswa.getAlamat());
                    System.out.println(mahasiswa.getFakultas());
                    break;
                case 3:
                    System.out.println( "Anda akan insert data Mahasiswa Baru" );
                    System.out.println( "Masukkan NIM anda :" );
                    nimInput=scanner1.nextLine();
                    System.out.println( "Masukkan Nama anda :" );
                    nama=scanner1.nextLine();
                    System.out.println( "Masukkan Alamat anda :" );
                    alamat=scanner1.nextLine();
                    System.out.println( "Masukkan Fakultas anda :" );
                    fakultas=scanner1.nextLine();
                    mahasiswa1.setNim(nimInput);
                    mahasiswa1.setNama(nama);
                    mahasiswa1.setAlamat(alamat);
                    mahasiswa1.setFakultas(fakultas);
                    mahasiswa1=mahasiswaDao.insertMahasiswa(mahasiswa1);
                    System.out.println( mahasiswa1.getNim());
                    break;
                case 4:
                    System.out.println( "Anda akan Meng-Update Mahasiswa" );
                    System.out.println( "Cari Nim yang akan diubah:" );
                    nimInput=scanner1.nextLine();
                    mahasiswa1.setNim(nimInput);
                    mahasiswa1=mahasiswaDao.getMahasiswa(mahasiswa1.getNim());
                    if(mahasiswa1!=null){
                        System.out.println( "Masukkan Nama anda :" );
                        nama=scanner1.nextLine();
                        System.out.println( "Masukkan Alamat anda :" );
                        alamat=scanner1.nextLine();
                        System.out.println( "Masukkan Fakultas anda :" );
                        fakultas=scanner1.nextLine();
                        mahasiswa1.setNama(nama);
                        mahasiswa1.setAlamat(alamat);
                        mahasiswa1.setFakultas(fakultas);
                        mahasiswa1=mahasiswaDao.updateMahasiswa(mahasiswa1);
                        System.out.println("Anda Berhasil update data Mahasiswa dengan nim"+mahasiswa1.getNim());
                    }else{
                        System.out.println("Nim untuk di update Tidak ditemukan");
                    }
                case 5:
                    System.out.println( "Anda akan Menghapus data Mahasiswa" );
                    System.out.println( "Cari Nim yang akan diubah:" );
                    nimInput=scanner1.nextLine();
                    mahasiswa1.setNim(nimInput);
                    mahasiswa1=mahasiswaDao.getMahasiswa(mahasiswa1.getNim());
                    if(mahasiswa1!=null){
                        mahasiswa1=mahasiswaDao.deleteMahasiswa(mahasiswa1);
                        System.out.println("Anda berhasil hapus data mahasiswa dengan Nim"+mahasiswa1.getNim());
                    }else {
                        System.out.println("Nim untuk dihapus Tidak ditemukan");
                    }
                default:
            }
            System.out.println( "Ingin melakukan operasi lagi ?? Tekan Y jika Yes dan ketik N jika No" );

            String nextAction=scanner1.nextLine();
            if(nextAction.equals("Y")){
                operasi=true;
            }else  if(nextAction.equals("N")){
                operasi=false;
            }
        }
    }
}
