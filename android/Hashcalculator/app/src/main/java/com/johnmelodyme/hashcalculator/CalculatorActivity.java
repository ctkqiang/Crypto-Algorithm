package com.johnmelodyme.hashcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class CalculatorActivity extends AppCompatActivity {
    public static final String TAG = "HashCalculator";
    private EditText __plainTextInput;

    private void __init__declaration() {
        // refer : https://www.geeksforgeeks.org/sha-256-hash-in-java/
        __plainTextInput = findViewById(R.id.plaintextinput);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Starting  " + CalculatorActivity.class.getSimpleName());
        __init__declaration();
    }
}
