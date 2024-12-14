package com.example.lab7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab7.dao.DBHelper;
import com.example.lab7.model.NhanVien;
import com.example.lab7.util.DBConfigUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnThem;
    ListView lv;
    DBHelper helper;
    List<NhanVien> listNV;
    ArrayAdapter adapter;
    NhanVien nv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        DBConfigUtil.coppyDBfromAsset(MainActivity.this);

        addControls();
        addEvents();
        hienthi();
    }
    private void addControls() {
        btnThem = findViewById(R.id.btnthem);
        lv = findViewById(R.id.lvNhanvien);
        helper = new DBHelper(MainActivity.this);

    }
    private void addEvents() {
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivityForResult(intent,1);
            }
        });
    }


    public void hienthi(){
        listNV = new ArrayList<>();
        listNV = helper.getALL();
        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,listNV);
        lv.setAdapter(adapter);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode==2){
                if(data.hasExtra("nv")){
                    nv =(NhanVien) data.getSerializableExtra("nv");
                    long newRow = helper.insertNhanVien(nv);
                    if(newRow >0)
                        Toast.makeText(this,"Them Thanh Cong",Toast.LENGTH_SHORT).show();
                    else      Toast.makeText(this,"Them That Bai",Toast.LENGTH_SHORT).show();
                    hienthi();
                }
            }
        }
    }
}