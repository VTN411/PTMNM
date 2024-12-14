package com.example.lab7.model;

import java.io.Serializable;

public class NhanVien implements Serializable {
    private int manv;
    private String tennv;
    private int luongcb;
    private float songaycong;

    public NhanVien() {
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public int getLuongcb() {
        return luongcb;
    }

    public void setLuongcb(int luongcb) {
        this.luongcb = luongcb;
    }

    public float getSongaycong() {
        return songaycong;
    }

    public void setSongaycong(float songaycong) {
        this.songaycong = songaycong;
    }

    @Override
    public String toString() {
        return  "Ma NV :" + manv +
                "\n Ten NV : " + tennv +
                "\n Luong CB: " + luongcb +
                "\n So Ngay Cong : " + songaycong ;
    }
}
