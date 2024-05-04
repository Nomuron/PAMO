//Author: Patryk Klimek
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BMIChart extends AppCompatActivity {

    WebView BmiChart;
    Button bmiChartReturnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.bmichart);

        BmiChart = findViewById(R.id.BMIChart);
        bmiChartReturnButton = findViewById(R.id.BmiChartReturnButton);

        BmiChart.getSettings().setJavaScriptEnabled(true);

        BmiChart.setWebViewClient(new WebViewClient());

        BmiChart.loadUrl("file:///android_asset/html/bmi_chart.html");

        bmiChartReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BMIChart.this, MainActivity.class);
                startActivity(i);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.bmi_chart), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public static float countBMI(float weight, float height) {
        return weight / (height * height);
    }
}