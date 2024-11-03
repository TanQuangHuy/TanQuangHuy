package com.example.contentprovider;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.contentprovider.Contact;

import java.util.ArrayList;

public class DanhBa extends AppCompatActivity {

    private final int REQUEST_CONTACTS_ASK_PERMISSIONS = 1001;

    ListView lvdanhba;
    ArrayList<Contact> dsDanhBa;
    ArrayAdapter<Contact> adapterDanhBa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_danh_ba);
        addControls();
      showAllContactFromDevice();
      /*  if (checkSelfPermission(android.Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{android.Manifest.permission.READ_CONTACTS}, REQUEST_CONTACTS_ASK_PERMISSIONS);
        } else {
            showAllContactFromDevice();
        }*/

    }

    private void showAllContactFromDevice() {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if (cursor != null) {
            dsDanhBa.clear();
            while (cursor.moveToNext()) {
                String tenCotName = ContactsContract.Contacts.DISPLAY_NAME;
                String tenCotPhone = ContactsContract.CommonDataKinds.Phone.NUMBER;

                int viTriCotName = cursor.getColumnIndex(tenCotName);
                int viTriCotPhone = cursor.getColumnIndex(tenCotPhone);

                String name = cursor.getString(viTriCotName);
                String phone = cursor.getString(viTriCotPhone);

                Contact contact = new Contact(name, phone);
                dsDanhBa.add(contact);
            }
            cursor.close();
            adapterDanhBa.notifyDataSetChanged();
        }
    }

    private void addControls() {
        lvdanhba = findViewById(R.id.lv_danhba);
        dsDanhBa = new ArrayList<>();
        adapterDanhBa = new ArrayAdapter<>(
           DanhBa.this, android.R.layout.simple_list_item_1,dsDanhBa
        );
        lvdanhba.setAdapter(adapterDanhBa);
    }
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CONTACTS_ASK_PERMISSIONS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                showAllContactFromDevice();
            } else {

            }
        }
    }
}