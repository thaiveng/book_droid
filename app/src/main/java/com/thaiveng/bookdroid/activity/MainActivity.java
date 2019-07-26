package com.thaiveng.bookdroid.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.thaiveng.bookdroid.R;
import com.thaiveng.bookdroid.fragment.Book_fragment;
import com.thaiveng.bookdroid.fragment.Feed_fragment;
import com.thaiveng.bookdroid.fragment.Notification_fragment;
import com.thaiveng.bookdroid.fragment.Post_fragment;
import com.thaiveng.bookdroid.fragment.Profile_Fragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
//        initToolBar();

        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        HompageFragmentPageAdapter adapter = new HompageFragmentPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(adapter.getCount() - 1);

        setUpNavigationView();

    }

    private void initView() {
        bottomNavigationView = findViewById(R.id.bottom_home);
        viewPager = findViewById(R.id.pager_home);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.nav_main);
        toolbar = findViewById(R.id.toolBar);
    }

    private void initToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
    }


    private void setUpNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.item_store:
                        Toast.makeText(getApplicationContext(), "You are selected store", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.item_about_us:
                        Toast.makeText(getApplicationContext(), "You are selected about us", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.item_term_of_use:
                        Toast.makeText(getApplicationContext(), "You are selected term", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.item_signout:
                        Toast.makeText(getApplicationContext(), "You are selected sign out", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        return true;
                }

                return false;
            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            switch (menuItem.getItemId()) {
                case R.id.item_all_book:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.item_feed:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.item_post:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.item_notification:
                    viewPager.setCurrentItem(3);
                    return true;
                case R.id.item_profile:
                    Log.e("profile", menuItem.getItemId() + "");
                    viewPager.setCurrentItem(4);
                    return true;
            }
            return false;
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_tool_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class HompageFragmentPageAdapter extends FragmentPagerAdapter {
        private HompageFragmentPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return Book_fragment.newInstance();
                case 1:
                    return Feed_fragment.newInstance();
                case 2:
                    return Post_fragment.newInstance();
                case 3:
                    return Notification_fragment.newInstance();
                case 4:
                    return Profile_Fragment.newInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}
