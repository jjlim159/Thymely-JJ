package com.example.phobussng_2.thymely;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ExploreTab exploreTab = new ExploreTab();

    private FragmentManager manager;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            manager = getSupportFragmentManager();

            switch (item.getItemId()) {
                case R.id.navigation_explore:
                    exploreTab = new ExploreTab();
                    manager.beginTransaction().replace(R.id.contentLayout,
                            exploreTab, exploreTab.getTag()).commit();
                    return true;
                case R.id.navigation_search:
                    SearchTab searchTab = new SearchTab();
                    manager.beginTransaction().replace(R.id.contentLayout,
                            searchTab, searchTab.getTag()).commit();
                    return true;
                case R.id.navigation_orders:
                    OrdersTab ordersTab = new OrdersTab();
                    manager.beginTransaction().replace(R.id.contentLayout,
                            ordersTab, ordersTab.getTag()).commit();
                    return true;
                case R.id.navigation_user:
                    UserTab userTab = new UserTab();
                    manager.beginTransaction().replace(R.id.contentLayout,
                            userTab, userTab.getTag()).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.bottomNav);
        BottomNavHelper.disableShiftMode(bottomNav);
        Menu menu = bottomNav.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNav.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.contentLayout,
                exploreTab, exploreTab.getTag()).commit();
    }

}
