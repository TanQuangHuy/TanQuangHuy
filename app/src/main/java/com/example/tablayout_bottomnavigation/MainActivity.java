package com.example.tablayout_bottomnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.util.Collections;

import fragment.ViewPagerAdapter;


public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager ;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);/*ánh xạ viewpager*/
        bottomNavigationView = findViewById(R.id.bottomNavigation);/*ánh xạ bottom navigation*/

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        /*getLifecycle()  là một phương thứctrong Android cung cấp quyền truy cập vào Lifecycle của một Activity hoặc Fragment*/
        viewPager.setAdapter(adapter);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNavigationView.findViewById(R.id.menu_news);
                        break;
                    case 1:
                        bottomNavigationView.findViewById(R.id.menu_student);
                        break;
                    case 2:
                        bottomNavigationView.findViewById(R.id.menu_call);
                        break;
                    default:
                        break;

                }
            }
        });
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.menu_news) {
                    viewPager.setCurrentItem(0);
                    return true;
                } else if (item.getItemId() == R.id.menu_student) {
                    viewPager.setCurrentItem(1);
                    return true;
                } else if (item.getItemId() == R.id.menu_call) {
                    viewPager.setCurrentItem(2);
                    return true;
                }
                return false;
            }
        });
    }


}