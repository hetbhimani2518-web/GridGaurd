package com.example.gridgaurd;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class cust_home_dashboard extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cust_home_dashboard);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnScrollChangeListener((v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
            if (scrollY > oldScrollY) {
                bottomNav.animate().translationY(bottomNav.getHeight()).setDuration(200); // Hide
            } else {
                bottomNav.animate().translationY(0).setDuration(200); // Show
            }
        });

    }
}