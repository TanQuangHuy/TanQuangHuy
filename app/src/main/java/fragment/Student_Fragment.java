package fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tablayout_bottomnavigation.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import Student.Student_ViewPagerAdapter;


public class Student_Fragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2 ;
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_student, container, false);

        tabLayout  = mView.findViewById(R.id.tablayout);
        viewPager2 = mView.findViewById(R.id.student_viewpager);

        Student_ViewPagerAdapter adapter =  new Student_ViewPagerAdapter(getChildFragmentManager(), getLifecycle());
        viewPager2.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                // Cài đặt tiêu đề cho các tab dựa trên vị trí
                switch (position) {
                    case 0:
                        tab.setText("Thông tin chung");
                        break;
                    case 1:
                        tab.setText("Lớp sinh hoạt");
                        break;
                    // Thêm các tab khác nếu cần thiết
                }
            }
        }).attach(); // Attach để liên kết TabLayout và ViewPager2

        return mView;
    }
}