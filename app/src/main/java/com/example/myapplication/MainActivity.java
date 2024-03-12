//Author: Patryk Klimek
package com.example.myapplication;

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

public class MainActivity extends AppCompatActivity {

    private EditText heightTextView;
    private EditText weightTextView;
    private Button calculate_button;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        heightTextView = (EditText) findViewById(R.id.heightText);
        weightTextView = (EditText) findViewById(R.id.weightText);
        calculate_button = findViewById(R.id.calculateBMIButton);
        result = (TextView) findViewById(R.id.resultBMI);

        calculate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float height = Float.parseFloat(heightTextView.getText().toString());
                float weight = Float.parseFloat(weightTextView.getText().toString());

                System.out.println(height);
                System.out.println(weight);

                Float BMI = weight / (height * height);

                result.setText(String.valueOf(BMI));

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}