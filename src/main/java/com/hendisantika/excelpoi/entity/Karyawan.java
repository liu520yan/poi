package com.hendisantika.excelpoi.entity;

/**
 * Created by IntelliJ IDEA.
 * Project : excel-poi
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 28/02/18
 * Time: 06.24
 * To change this template use File | Settings | File Templates.
 */
public class Karyawan {
    private String id;

    public Karyawan(String id, String nama, String alamat, String bagian, String bagian1, String bagian2, String bagian3, String bagian4, String bagian5, String bagian6, String bagian7) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.bagian = bagian;
        this.bagian1 = bagian1;
        this.bagian2 = bagian2;
        this.bagian3 = bagian3;
        this.bagian4 = bagian4;
        this.bagian5 = bagian5;
        this.bagian6 = bagian6;
        this.bagian7 = bagian7;
    }

    private String nama;

    private String alamat;

    private String bagian;
    private String bagian1;
    private String bagian2;
    private String bagian3;
    private String bagian4;
    private String bagian5;
    private String bagian6;
    private String bagian7;


    public String getBagian1() {
        return bagian1;
    }

    public void setBagian1(String bagian1) {
        this.bagian1 = bagian1;
    }

    public String getBagian2() {
        return bagian2;
    }

    public void setBagian2(String bagian2) {
        this.bagian2 = bagian2;
    }

    public String getBagian3() {
        return bagian3;
    }

    public void setBagian3(String bagian3) {
        this.bagian3 = bagian3;
    }

    public String getBagian4() {
        return bagian4;
    }

    public void setBagian4(String bagian4) {
        this.bagian4 = bagian4;
    }

    public String getBagian5() {
        return bagian5;
    }

    public void setBagian5(String bagian5) {
        this.bagian5 = bagian5;
    }

    public String getBagian6() {
        return bagian6;
    }

    public void setBagian6(String bagian6) {
        this.bagian6 = bagian6;
    }

    public String getBagian7() {
        return bagian7;
    }

    public void setBagian7(String bagian7) {
        this.bagian7 = bagian7;
    }

    public Karyawan() {

    }

    public Karyawan(String id, String nama, String alamat, String bagian) {
        super();
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.bagian = bagian;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getBagian() {
        return bagian;
    }

    public void setBagian(String bagian) {
        this.bagian = bagian;
    }
}
