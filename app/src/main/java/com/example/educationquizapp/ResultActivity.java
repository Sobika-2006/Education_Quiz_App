package com.example.educationquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Get scores from previous activity
        int score1 = getIntent().getIntExtra("score1", 0);
        int score2 = getIntent().getIntExtra("score2", 0);
        int score3 = getIntent().getIntExtra("score3", 0);

        int total = score1 + score2 + score3;

        // Show result
        TextView tvResult = findViewById(R.id.tvResult);

        String resultText =
                "Quiz Completed!\n\n" +
                        "Round 1 - Technical: " + score1 + "/5\n" +
                        "Round 2 - Aptitude: " + score2 + "/5\n" +
                        "Round 3 - Coding: " + score3 + "/5\n\n" +
                        "Total Score: " + total + "/15";

        tvResult.setText(resultText);

        // Restart button
        MaterialButton btnRestart = findViewById(R.id.btnRestart);
        btnRestart.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });

        // Exit button
        MaterialButton btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(v -> finishAffinity());
    }
}