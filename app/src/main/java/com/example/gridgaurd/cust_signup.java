package com.example.gridgaurd;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class cust_signup extends AppCompatActivity {

    TextView tvsignin ;
    MaterialButton btnsignup ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cust_signup);

        tvsignin = findViewById(R.id.tvSignIn);

        tvsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cust_signup.this , cust_signin.class);
                startActivity(intent);
                finish();
            }
        });

        btnsignup = findViewById(R.id.btnSignUp);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cust_signup.this , cust_home_dashboard.class);
                startActivity(intent);
                finish();
            }
        });
    }
}