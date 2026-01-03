package com.example.hydrotrack;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        LinearLayout btnTarget = findViewById(R.id.btnTarget);
        LinearLayout btnAddWater = findViewById(R.id.btnAddWater);
        LinearLayout btnHistory = findViewById(R.id.btnHistory);
        LinearLayout btnTips = findViewById(R.id.btnTips);
        LinearLayout btnAbout = findViewById(R.id.btnAbout);

        btnTarget.setOnClickListener(v ->
                startActivity(new Intent(this, TargetActivity.class)));

        btnAddWater.setOnClickListener(v ->
                startActivity(new Intent(this, AddWaterActivity.class)));

        btnHistory.setOnClickListener(v ->
                startActivity(new Intent(this, HistoryActivity.class)));

        btnTips.setOnClickListener(v ->
                startActivity(new Intent(this, TipsActivity.class)));

        btnAbout.setOnClickListener(v ->
                startActivity(new Intent(this, AboutActivity.class)));
    }
}