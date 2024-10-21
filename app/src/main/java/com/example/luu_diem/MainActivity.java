package com.example.luu_diem;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    SharedPreferences  sharedPreferences;
    SharedPreferences.Editor editor;
    EditText tdata;
    Button btnSave;
    Button btnLammoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initPreferences();
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tdata = (EditText) findViewById(R.id.data);
        btnSave = (Button) findViewById(R.id.luu);
        btnLammoi = (Button) findViewById(R.id.lammoi);

        String savedData = sharedPreferences.getString("data", "");
        tdata.setText(savedData);

        btnSave.setOnClickListener(this);
        btnLammoi.setOnClickListener(this);

    }
    private void initPreferences() {
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    @Override
    public void onClick(View view) {
        if (view == btnSave) {
            //  lưu dữ liệu lại.
            String data = tdata.getText().toString();
            // "data" là key, data tham số thứ 2 là value.
            editor.putString("data", data);
            editor.commit();
        } else if (view == btnLammoi) {
            // xoá dữ liệu .
            tdata.setText("");
            editor.clear();
            editor.commit();
        }
    }
}