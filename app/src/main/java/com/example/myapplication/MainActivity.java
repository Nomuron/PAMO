//Author: Patryk Klimek
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button BMIButton;
    Button CaloriesButton;
    Button RecipiesButton;
    Button ShoppingList;
    Button BMIChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        BMIButton = findViewById(R.id.calculateBMIButton);
        CaloriesButton = findViewById(R.id.calculateCalories);
        RecipiesButton = findViewById(R.id.recipies);
        ShoppingList = findViewById(R.id.shoppingList);
        BMIChart = findViewById(R.id.BMIChart);

        BMIButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bmiIntent = new Intent(MainActivity.this, BMI.class);
                startActivity(bmiIntent);
            }
        });

        CaloriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bmrIntent = new Intent(MainActivity.this, BMR.class);
                startActivity(bmrIntent);
            }
        });

        RecipiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recipiesIntent = new Intent(MainActivity.this, Recipies.class);
                startActivity(recipiesIntent);
            }
        });

        ShoppingList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recipiesIntent = new Intent(MainActivity.this, ShoppingList.class);
                startActivity(recipiesIntent);
            }
        });

        BMIChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recipiesIntent = new Intent(MainActivity.this, BMIChart.class);
                startActivity(recipiesIntent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}