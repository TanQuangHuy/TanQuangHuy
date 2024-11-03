package com.example.contentprovider;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.CallLog.Calls;
import android.provider.MediaStore;
import android.provider.MediaStore.Audio.Media;
import android.app.Activity;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.content.SharedPreferences;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity  {

    private static final int REQUEST_CONTACT_ASK_PERMISSONS = 1001;
    private static final int REQUEST_SMS_ASK_PERMISSONS = 1002;

    Button btn1, btn2 ;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvents();

    }

    private void addEvents() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyMoManHinhDanhBa();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyMoManHinhTinNhan();
            }
        });
    }
    private void xulyMoManHinhTinNhan() {
        if(ContextCompat.checkSelfPermission(
               this, Manifest.permission.READ_SMS)!= PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{"" + "android.permisson.READ_SMS"}, REQUEST_SMS_ASK_PERMISSONS);
        }else {
            Intent intent = new Intent(MainActivity.this, DocTinNhan.class);
            intent.setClassName("com.example.contentprovider","com.example.contentprovider.DocTinNhan");
            startActivity(intent);
        }
    }
    private void xulyMoManHinhDanhBa() {
        if(ContextCompat.checkSelfPermission(
                this, Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{"" + "android.permisson.READ_CONTACTS"}, REQUEST_CONTACT_ASK_PERMISSONS);
        }else {
            Intent intent = new Intent(MainActivity.this, DanhBa.class);
            intent.setClassName("com.example.contentprovider","com.example.contentprovider.DanhBa");
            startActivity(intent);
        }
    }

    private void addControl() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
    }
}
