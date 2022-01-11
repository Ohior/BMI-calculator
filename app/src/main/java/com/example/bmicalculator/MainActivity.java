package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onButtonClicked();
    }

    private void onButtonClicked(){

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView BMICategory = (TextView) findViewById(R.id.BMICategory);

                final EditText heightText = (EditText) findViewById(R.id.heightInput);
                String heightStr = heightText.getText().toString();
                double height = Double.parseDouble(heightStr);

                 final EditText weightText = (EditText) findViewById(R.id.weightInput);
                 String weightStr = weightText.getText().toString();
                 double weight = Double.parseDouble(weightStr);

                 final EditText BMIResult = (EditText) findViewById(R.id.BMIResult);

                 double BMI_raw = (weight) / (height*height);
//                 approximate the BMI_raw data to 1 decimal point
                 double BMI = Double.parseDouble(new DecimalFormat("#.#").format(BMI_raw));
                 BMIResult.setText(Double.toString(BMI));
                 String BMI_Cat;
                 if (BMI < 15)BMI_Cat = "Very Severely underweight";
                 else if (BMI < 16) BMI_Cat = "Severely underweight";
                 else if (BMI < 18.5) BMI_Cat = "Underweight";
                 else if (BMI < 20) BMI_Cat = "Normal";
                 else if (BMI < 30) BMI_Cat = "Overweight";
                 else if (BMI < 35) BMI_Cat = "Obese Class 1 - Moderately Obese";
                 else if (BMI < 40) BMI_Cat = "Obese Class 1 - Severely Obese";
                 else BMI_Cat = "Obese Class 1 - Very Severely Obese";

                 BMICategory.setText(BMI_Cat);

            }
        });
    }
}