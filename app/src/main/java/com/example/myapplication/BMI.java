//Author: Patryk Klimek
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BMI extends AppCompatActivity {

    EditText heightTextView;
    EditText weightTextView;
    Button calculateButton;
    TextView result;
    Button bmiReturnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.bmi);

        heightTextView = findViewById(R.id.BMIHeight);
        weightTextView = findViewById(R.id.BMIWeight);
        calculateButton = findViewById(R.id.calculateBMIButton);
        result = findViewById(R.id.resultBMI);
        bmiReturnButton = findViewById(R.id.BMIReturnButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float height = (Float.parseFloat(heightTextView.getText().toString()) / 100);
                float weight = Float.parseFloat(weightTextView.getText().toString());

                Float BMI = weight / (height * height);

                result.setText(String.valueOf(BMI));
            }
        });

        bmiReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BMI.this, MainActivity.class);
                startActivity(i);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}