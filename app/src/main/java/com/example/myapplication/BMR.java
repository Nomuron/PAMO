//Author: Patryk Klimek
package com.example.myapplication;

import static java.lang.Math.round;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;
import java.util.Objects;

public class BMR extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] sexes = {"Male", "Female"};
    String selectedSex;
    Spinner spino;
    EditText heightTextView;
    EditText weightTextView;
    EditText ageTextView;
    TextView resultBMR;
    Button calculateBMRButton;
    Button bmrReturnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.bmr);

        spino = findViewById(R.id.sexSpinner);
        spino.setOnItemSelectedListener(this);

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, sexes);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spino.setAdapter(ad);

        heightTextView = findViewById(R.id.BMRHeight);
        weightTextView = findViewById(R.id.BMRWeight);
        ageTextView = findViewById(R.id.BMRAge);
        resultBMR = findViewById(R.id.resultBMR);
        calculateBMRButton = findViewById(R.id.calculateBMRButton);
        bmrReturnButton = findViewById(R.id.BMRReturnButton);

        calculateBMRButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float height = Float.parseFloat(heightTextView.getText().toString());
                float weight = Float.parseFloat(weightTextView.getText().toString());
                int age = Integer.parseInt(ageTextView.getText().toString());
                String sex = selectedSex;

                double BMR;

                if (Objects.equals(sex, "Male")) {
                    BMR = ((13.7516 * weight) + (5.0033 * height) - (6.755 * age) + 66.473);
                } else {
                    BMR = ((9.5634 * weight) + (1.8496 * height) - (4.6756 * age) + 655.0955);
                }

                DecimalFormat df = new DecimalFormat("#.##");
                resultBMR.setText(df.format(BMR) + " kcal");
            }
        });


        bmrReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BMR.this, MainActivity.class);
                startActivity(i);
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedSex = sexes[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}