package com.example.contentprovider;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class DocTinNhan extends AppCompatActivity {
    private final int REQUEST_SMS_ASK_PERMISSIONS = 1002;
    ListView lvTinNhan;
    ArrayList<TinNhan> dsTinNhan;
    ArrayAdapter<TinNhan> adapterTinNhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doc_tin_nhan);
        addControls();
        showAllMessagesFromDevice();

    }
    private void addControls() {
        lvTinNhan = findViewById(R.id.lv_tinnhan);
        dsTinNhan = new ArrayList<>();
        adapterTinNhan = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, dsTinNhan
        );
        lvTinNhan.setAdapter(adapterTinNhan);
    }
    private void showAllMessagesFromDevice() {
        Uri uri = Uri.parse("content://sms/inbox");
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if (cursor != null) {
            int addressIndex = cursor.getColumnIndex("address");
            int bodyIndex = cursor.getColumnIndex("body");

            while (cursor.moveToNext()) {
                String address = addressIndex != -1 ? cursor.getString(addressIndex) : "Unknown";
                String body = bodyIndex != -1 ? cursor.getString(bodyIndex) : "No Content";

                TinNhan tinNhan = new TinNhan(address, body);
                dsTinNhan.add(tinNhan);
            }
            cursor.close();
        }
        adapterTinNhan.notifyDataSetChanged();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_SMS_ASK_PERMISSIONS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                showAllMessagesFromDevice();
            } else {

            }
        }
    }
}