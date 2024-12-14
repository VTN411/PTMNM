package com.example.lab7.dao;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.widget.ListView;

import com.example.lab7.model.NhanVien;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME ="nhanvien.sqlite";
    private static final int DB_VERSION=1;

    public DBHelper(Activity context){
        super(context,DB_NAME,null,DB_VERSION);

    }
    public  class TABLE implements BaseColumns{
        private  static final String TABLE_NAME= "nhanvien";
        private  static final String COL_MA= "manv";
        private  static final String COL_TEN= "tennv";
        private  static final String COL_LUONGCB= "luongcb";
        private  static final String COL_SONGAYCONG= "songaycong";
    }
    public List<NhanVien> getALL() {
        List<NhanVien> list = new ArrayList<>();
        String[] projection = {
                TABLE.COL_MA,
                TABLE.COL_TEN,
                TABLE.COL_LUONGCB,
                TABLE.COL_SONGAYCONG
        };

        Cursor cursor = getReadableDatabase().query(
                TABLE.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        while (cursor.moveToNext())
        {
            NhanVien nv = new NhanVien();
            nv.setManv(cursor.getInt(cursor.getColumnIndexOrThrow(TABLE.COL_MA)));
            nv.setTennv(cursor.getString(cursor.getColumnIndexOrThrow(TABLE.COL_TEN)));
            nv.setLuongcb(cursor.getInt(cursor.getColumnIndexOrThrow(TABLE.COL_LUONGCB)));
            nv.setSongaycong(cursor.getFloat(cursor.getColumnIndexOrThrow(TABLE.COL_SONGAYCONG)));
            list.add(nv);
        }
        cursor.close();
        return list;
    }
    public long insertNhanVien(NhanVien nv){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TABLE.COL_TEN,nv.getTennv());
        values.put(TABLE.COL_LUONGCB,nv.getLuongcb());
        values.put(TABLE.COL_SONGAYCONG,nv.getSongaycong());
        long newRow =db.insert(TABLE.TABLE_NAME,null,values);
        return newRow;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
