package com.example.hydrotrack;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TargetActivity extends AppCompatActivity {

    private EditText etWeight;
    private TextView tvResult;
    private Button btnCalculate;
    private PrefManager pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        etWeight = findViewById(R.id.etWeight);
        tvResult = findViewById(R.id.tvResult);
        btnCalculate = findViewById(R.id.btnCalculate);
        pref = new PrefManager(this);

        btnCalculate.setOnClickListener(v -> {
            String weightText = etWeight.getText().toString().trim();

            if (weightText.isEmpty()) {
                Toast.makeText(this, "Please enter your weight", Toast.LENGTH_SHORT).show();
                return;
            }

            int weight = Integer.parseInt(weightText);
            int target = weight * 35; // 35ml per kg body weight
            pref.setTarget(target);
            pref.setWeight(weight); // Save weight for history

            // Calculate glasses and bottles
            int glasses = target / 200; // 200ml per glass
            int bottles = target / 500; // 500ml per bottle

            String result = "✅ Target Calculated!\n\n" +
                    "Your Weight: " + weight + " kg\n" +
                    "Daily Water Need: " + target + " ml\n" +
                    "Glasses: ~" + glasses + "\n" +
                    "Bottles: ~" + bottles;

            tvResult.setText(result);
            Toast.makeText(this, "Daily target set to " + target + " ml 🎯", Toast.LENGTH_SHORT).show();
            etWeight.setText("");
        });
    }
}