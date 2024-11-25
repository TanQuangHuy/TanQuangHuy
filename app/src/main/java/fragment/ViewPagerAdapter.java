    package fragment;

    import androidx.annotation.NonNull;
    import androidx.fragment.app.Fragment;
    import androidx.fragment.app.FragmentManager;
    import androidx.lifecycle.Lifecycle;
    import androidx.viewpager2.adapter.FragmentStateAdapter;

    public class ViewPagerAdapter extends FragmentStateAdapter {
        public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position){
                case 0:
                    return new News_Fragment();
                case 1:
                    return new Student_Fragment();
                case 2:
                    return new Call_Fragment();
                default:
                    return new News_Fragment();
            }
        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }
