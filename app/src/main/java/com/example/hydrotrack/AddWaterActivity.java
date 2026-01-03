package com.example.hydrotrack;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddWaterActivity extends AppCompatActivity {

    private EditText etWater;
    private TextView tvResult;
    private Button btnCalculate;
    private PrefManager pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_water);

        etWater = findViewById(R.id.etWater);
        tvResult = findViewById(R.id.tvResult);
        btnCalculate = findViewById(R.id.btnCalculate);
        pref = new PrefManager(this);

        btnCalculate.setOnClickListener(v -> {
            String waterText = etWater.getText().toString().trim();

            if (waterText.isEmpty()) {
                Toast.makeText(this, "Please enter water amount", Toast.LENGTH_SHORT).show();
                return;
            }

            int intake = Integer.parseInt(waterText);
            int total = pref.getWater() + intake;
            pref.setWater(total);

            // Calculate glasses and bottles
            int glasses = intake / 200; // 200ml per glass
            int bottles = intake / 500; // 500ml per bottle

            String result = "✅ Water Logged!\n\n" +
                    "Amount: " + intake + " ml\n" +
                    "Glasses: ~" + glasses + "\n" +
                    "Bottles: ~" + bottles;

            tvResult.setText(result);
            Toast.makeText(this, "Water Added 💧", Toast.LENGTH_SHORT).show();
            etWater.setText("");
        });
    }
}