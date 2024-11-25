package com.example.tanquanghuy_baitaplon;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemReselectedListener(item -> {
            Fragment fragment = null;
            if(item.getItemId()==R.id.nav_home){
                fragment= new HomeFragment();
            }
        });

        ListView listView = findViewById(R.id.listview);

        // Dữ liệu mẫu
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("Tán Quang Huy", "Đẹp trai hiền hòa",R.drawable.ic_account));
        itemList.add(new Item("Phú Huy", "Tốt bụng dẽ tính", R.drawable.ic_account));
        itemList.add(new Item("Trần Bình An", "Thật thà dũng cảm", R.drawable.ic_account));

        // Kết nối adapter
        ListAdapter adapter = new ListAdapter(this, itemList);
        listView.setAdapter(adapter);

    }
}