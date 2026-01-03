package com.example.hydrotrack;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class HistoryActivity extends AppCompatActivity {

    private TextView tvHistory;
    private TextView tvWeightHistory;
    private Button btnClear;
    private PrefManager pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        tvHistory = findViewById(R.id.tvHistory);
        tvWeightHistory = findViewById(R.id.tvWeightHistory);
        btnClear = findViewById(R.id.btnClear);
        pref = new PrefManager(this);

        updateHistory();

        btnClear.setOnClickListener(v -> {
            pref.clearAll();
            Toast.makeText(this, "History cleared!", Toast.LENGTH_SHORT).show();
            updateHistory();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateHistory();
    }

    private void updateHistory() {
        int water = pref.getWater();
        int target = pref.getTarget();
        int weight = pref.getWeight();

        // Update weight history
        if (weight > 0) {
            tvWeightHistory.setText("• " + weight + " kg");
        } else {
            tvWeightHistory.setText("• No weight recorded yet");
        }

        // Update water calculation history
        if (target > 0) {
            int glasses = target / 200; // 200ml per glass
            int bottles = target / 500; // 500ml per bottle
            tvHistory.setText("• Weight: " + weight + ".0 kg → " + target + " ml (" +
                    glasses + " glasses / " + bottles + " bottles)");
        } else {
            tvHistory.setText("• No calculations yet");
        }
    }
}