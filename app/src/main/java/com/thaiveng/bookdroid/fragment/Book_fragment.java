package com.thaiveng.bookdroid.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thaiveng.bookdroid.R;


public class Book_fragment extends Fragment {
    public static Book_fragment newInstance() {
        return new Book_fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.book_fragment, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager viewPager = view.findViewById(R.id.pager_book);
        Book_fragment_adapter adapter = new Book_fragment_adapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(adapter.getCount() - 1);
        TabLayout tabLayout = view.findViewById(R.id.tab_book);
        tabLayout.setupWithViewPager(viewPager);
    }

    public class Book_fragment_adapter extends FragmentPagerAdapter {
        private String[] cat_book = new String[]{
                "Novel",
                "Sport",
                "Programming",
                "Mind Set",
                "Tourist",
                "Mathematics"
        };

        Book_fragment_adapter(FragmentManager childFragmentManager) {
            super(childFragmentManager);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return Book_child_fragment.newInstance(i);
                case 1:
                    return Book_child_fragment.newInstance(i);
                case 2:
                    return Book_child_fragment.newInstance(i);
                case 3:
                    return Book_child_fragment.newInstance(i);
                case 4:
                    return Book_child_fragment.newInstance(i);
                default:
                    return Book_child_fragment.newInstance(i);
            }
        }

        @Override
        public int getCount() {
            return cat_book.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return cat_book[position];
        }
    }
}
