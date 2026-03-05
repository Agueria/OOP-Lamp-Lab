package com.example.lab1;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity {
    private StringBuilder results = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        TextView testResultsTextView = findViewById(R.id.testResultsTextView);
        runTests();
        testResultsTextView.setText(results.toString());
    }

    private void runTests() {
        logTest("1. Turn lamp on and off", testTurnOnOff());
        logTest("2. Brighten to 10", testBrightenTo10());
        logTest("3. Brighten above 10 (Burn)", testBurnBulb());
        logTest("4. Dim to 0", testDimToOff());
        logTest("5. Replace bulb while off", testReplaceBulbWhileOff());
        logTest("6. Replace bulb while on", testReplaceBulbWhileOn());
        logTest("7. Turn on with burned bulb", testTurnOnBurned());
    }

    private void logTest(String name, boolean passed) {
        String result = name + ": " + (passed ? "PASS" : "FAIL");
        results.append(result).append("\n");
        Log.i("LampTest", result);
    }

    private boolean testTurnOnOff() {
        Lamp lamp = new Lamp();
        lamp.turnOn();
        if (!lamp.isOn() || lamp.getIntensity() != 1) return false;
        lamp.turnOff();
        return !lamp.isOn() && lamp.getIntensity() == 0;
    }

    private boolean testBrightenTo10() {
        Lamp lamp = new Lamp();
        lamp.turnOn();
        for (int i = 1; i < 10; i++) {
            lamp.brighten();
        }
        return lamp.getIntensity() == 10 && lamp.isOn() && !lamp.isBulbBurned();
    }

    private boolean testBurnBulb() {
        Lamp lamp = new Lamp();
        lamp.turnOn();
        for (int i = 0; i < 15; i++) {
            lamp.brighten();
        }
        return !lamp.isOn() && lamp.getIntensity() == 0 && lamp.isBulbBurned();
    }

    private boolean testDimToOff() {
        Lamp lamp = new Lamp();
        lamp.turnOn();
        lamp.brighten(); // intensity 2
        lamp.dim(); // intensity 1
        lamp.dim(); // intensity 0 -> off
        return !lamp.isOn() && lamp.getIntensity() == 0;
    }

    private boolean testReplaceBulbWhileOff() {
        Lamp lamp = new Lamp();
        lamp.turnOn();
        for (int i = 0; i < 11; i++) lamp.brighten(); // Burn it
        return lamp.replaceBulb() && !lamp.isBulbBurned();
    }

    private boolean testReplaceBulbWhileOn() {
        Lamp lamp = new Lamp();
        lamp.turnOn();
        return !lamp.replaceBulb();
    }

    private boolean testTurnOnBurned() {
        Lamp lamp = new Lamp();
        lamp.turnOn();
        for (int i = 0; i < 11; i++) lamp.brighten(); // Burn it
        lamp.turnOn();
        return !lamp.isShining();
    }
}
