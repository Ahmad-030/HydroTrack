package com.example.hydrotrack;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProgressActivity extends AppCompatActivity {

    private TextView tvProgress;
    private ProgressBar progressBar;
    private PrefManager pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        tvProgress = findViewById(R.id.tvProgress);
        progressBar = findViewById(R.id.progressBar);
        pref = new PrefManager(this);

        updateProgress();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateProgress();
    }

    private void updateProgress() {
        int water = pref.getWater();
        int target = pref.getTarget();

        if (target == 0) {
            tvProgress.setText("Please set your daily target first!");
            progressBar.setProgress(0);
            return;
        }

        int progress = (water * 100) / target;
        progressBar.setProgress(Math.min(progress, 100));

        tvProgress.setText("Today's Progress\n" + water + " ml / " + target + " ml\n" + progress + "%");
    }
}