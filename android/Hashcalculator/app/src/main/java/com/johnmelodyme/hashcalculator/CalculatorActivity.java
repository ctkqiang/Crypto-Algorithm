package com.johnmelodyme.hashcalculator;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.R;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.johnmelodyme.hashcalculator.CalculatorActivity.SHA256.getSHA;


public class CalculatorActivity extends AppCompatActivity {
    public static final String TAG = "HashCalculator";
    private EditText __plainTextInput;

    private TextView __output;
    private Button __send;


    private void __init__declaration() {
        // refer : https://www.geeksforgeeks.org/sha-256-hash-in-java/
        __plainTextInput = findViewById(R.id.plaintextinput);

        __output = findViewById(R.id.output);
        __send = findViewById(R.id.btn_send);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Starting  " + CalculatorActivity.class.getSimpleName());
        __init__declaration();

        __send.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String getUserInput;
                getUserInput = __plainTextInput.toString().trim();
                try {
                    __output.setText("SHA256: " + getUserInput + ":" + toHexString(getSHA(getUserInput)));
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public static class SHA256 {
        public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
            // Static getInstance method is called with hashing SHA:
            MessageDigest __sha256;
            __sha256 = MessageDigest.getInstance("256");
            return __sha256.digest(input.getBytes(StandardCharsets.UTF_8));
        }
    }

    public static String toHexString(byte[] hash) {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);
        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));
        // Pad with leading zeros
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }
}
