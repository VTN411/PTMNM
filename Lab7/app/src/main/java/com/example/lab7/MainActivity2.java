package com.example.lab7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab7.model.NhanVien;

public class MainActivity2 extends AppCompatActivity {
    Button btnLuu;
    EditText txtTen,txtluongcb,txtsongaycong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControls();
        addEvents();
    }

    private void addControls() {
        btnLuu = findViewById(R.id.btnluu);
        txtTen = findViewById(R.id.txtten);
        txtluongcb = findViewById(R.id.txtluongcb);
        txtsongaycong = findViewById(R.id.txtsongaycong);
    }

    private void addEvents() {
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhanVien nv = new NhanVien();
                nv.setTennv(txtTen.getText().toString());
                nv.setLuongcb(Integer.parseInt(txtluongcb.getText().toString()));
                nv.setSongaycong(Float.parseFloat(txtsongaycong.getText().toString()));

                Intent returnintent = new Intent();
                returnintent.putExtra("nv",nv);
                setResult(2,returnintent);
                finish();
            }
        });
    }
}