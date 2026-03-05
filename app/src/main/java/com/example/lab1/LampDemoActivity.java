package com.example.lab1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LampDemoActivity extends AppCompatActivity {
    private Lamp lamp;
    private TextView statusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamp_demo);

        lamp = new Lamp();
        statusTextView = findViewById(R.id.statusTextView);

        Button btnTurnOn = findViewById(R.id.btnTurnOn);
        Button btnTurnOff = findViewById(R.id.btnTurnOff);
        Button btnBrighten = findViewById(R.id.btnBrighten);
        Button btnDim = findViewById(R.id.btnDim);
        Button btnReplaceBulb = findViewById(R.id.btnReplaceBulb);

        btnTurnOn.setOnClickListener(v -> {
            lamp.turnOn();
            updateStatus();
        });

        btnTurnOff.setOnClickListener(v -> {
            lamp.turnOff();
            updateStatus();
        });

        btnBrighten.setOnClickListener(v -> {
            lamp.brighten();
            updateStatus();
        });

        btnDim.setOnClickListener(v -> {
            lamp.dim();
            updateStatus();
        });

        btnReplaceBulb.setOnClickListener(v -> {
            lamp.replaceBulb();
            updateStatus();
        });

        updateStatus();
    }

    private void updateStatus() {
        String status = "Is On: " + lamp.isOn() + "\n" +
                "Intensity: " + lamp.getIntensity() + "\n" +
                "Is Shining: " + lamp.isShining() + "\n" +
                "Is Bulb Burned: " + lamp.isBulbBurned();
        statusTextView.setText(status);
    }
}
