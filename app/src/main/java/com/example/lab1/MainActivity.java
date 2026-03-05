package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHello = findViewById(R.id.btnHello);
        Button btnLampDemo = findViewById(R.id.btnLampDemo);
        Button btnRunTests = findViewById(R.id.btnRunTests);

        btnHello.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, HelloActivity.class)));
        btnLampDemo.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LampDemoActivity.class)));
        btnRunTests.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, TestActivity.class)));
    }
}
