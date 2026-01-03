package com.example.hydrotrack;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Navigate to MainMenuActivity after 2 seconds
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MainMenuActivity.class));
            finish();
        }, 2000);
    }
}