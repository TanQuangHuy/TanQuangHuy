    package Student;

    import androidx.annotation.NonNull;
    import androidx.fragment.app.Fragment;
    import androidx.fragment.app.FragmentActivity;
    import androidx.fragment.app.FragmentManager;
    import androidx.lifecycle.Lifecycle;
    import androidx.viewpager2.adapter.FragmentStateAdapter;

    import fragment.Call_Fragment;
    import fragment.News_Fragment;
    import fragment.Student_Fragment;

    public class Student_ViewPagerAdapter extends FragmentStateAdapter {
        public Student_ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

/*        public Student_ViewPagerAdapter(@NonNull Fragment fragment) {
            super(fragment);
        }*/
        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position){
                case 0:
                    return new ThongTinFragment();
                case 1:
                    return new LopFragment();
                default:
                    return new ThongTinFragment();
            }
        }

        @Override
        public int getItemCount() {
            return 2;
        }

        @Override
        public long getItemId(int position) {
            switch (position){
                case 0:
                    return 1;
                case 1:
                    return 2;
                default:
                    return 1;
            }

        }
    }
