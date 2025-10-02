package com.example.gridgaurd;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        frameLayout = findViewById(R.id.framelayout);

        if (savedInstanceState == null) {
            loadFragment(new UserHomeFragment());
            bottomNavigationView.setSelectedItemId(R.id.nav_home);
        }

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int itemId = menuItem.getItemId();
                Fragment fragment;
                if (itemId == R.id.nav_home) {
                    fragment = new UserHomeFragment();
                } else if (itemId == R.id.nav_add) {
                    fragment = new UserReportFragment(); // example different fragment
                } else if (itemId == R.id.nav_history) {
                    fragment = new UserHistoryFragment(); // example different fragment
                } else {
                    fragment = new UserProfileFragment();
                }
                loadFragment(fragment);
                return true;
            }
        });

//        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
//            Fragment fragment;
//            switch (menuItem.getItemId()) {
//                case R.id.nav_home:
//                    fragment = new UserHomeFragment();
//                    break;
//                case R.id.nav_add:
//                    fragment = new UserReportFragment(); // example
//                    break;
//                case R.id.nav_history:
//                    fragment = new UserHistoryFragment(); // example
//                    break;
//                default:
//                    fragment = new UserProfileFragment();
//            }
//            loadFragment(fragment);
//            return true;
//        });


    }

//    private void loadFragment(Fragment fragment) {
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.framelayout, fragment)
//                .commit();
//    }


    private void loadFragment(Fragment fragment){
//        boolean isAppIntitialized
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        if(isAppIntitialized){
//            fragmentTransaction.add(R.id.framelayout,fragment);
//            fragmentTransaction.commit();
//        } else {
//            fragmentTransaction.replace(R.id.framelayout,fragment);
//            fragmentTransaction.commit();
//        }

        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.commit();
    }
}