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

    private String nama;

    private String alamat;

    private String bagian;

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
