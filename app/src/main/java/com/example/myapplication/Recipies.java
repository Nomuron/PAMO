//Author: Patryk Klimek
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Recipies extends AppCompatActivity {

    TextView recipieTitle;
    TextView recipiePlan;
    Button nextRecipie;
    Button recipiesReturnButton;
    String[] recipies;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.recipies);

        recipieTitle = findViewById(R.id.recipieTitle);
        recipiePlan = findViewById(R.id.recipiePlan);
        nextRecipie = findViewById(R.id.nextRecipie);
        recipiesReturnButton = findViewById(R.id.recipiesReturnButton);

        recipies = getResources().getStringArray(R.array.recipies);

        String[] recipie = recipies[index].split("\\|");
        recipieTitle.setText(recipie[0]);
        recipiePlan.setText(recipie[1]);

        nextRecipie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(String.valueOf(index), String.valueOf(index));
                index++;

                if (index >= recipies.length) {
                    index = 0;
                }

                String[] recipie = recipies[index].split("\\|");
                recipieTitle.setText(recipie[0]);
                recipiePlan.setText(recipie[1]);
            }
        });

        recipiesReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Recipies.this, MainActivity.class);
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