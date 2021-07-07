package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class bmiresult extends AppCompatActivity {
    String username;
    String usergender;
    String height;
    String weight;
    Double finalheight=0.0, finalweight=0.0;
    String bmi;
    TextView bmi_statement;
    EditText weight_enter;
    EditText height_enter;
    TextView bmi_result;
    ImageView bmi_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiresult);
        bmi_statement=(TextView)findViewById(R.id.result_statement);
        bmi_result=(TextView)findViewById(R.id.bmi_result);
        bmi_image=(ImageView)findViewById(R.id.result_image);
        weight_enter =(EditText) findViewById(R.id.weight);
        height_enter =(EditText) findViewById(R.id.height);
        final Button calculate_button =(Button) findViewById(R.id.bmi_calculate);
        final CheckBox cm_box =(CheckBox)findViewById(R.id.centimetre);
        final CheckBox in_box =(CheckBox)findViewById(R.id.inch);
        final CheckBox kb_box =(CheckBox) findViewById(R.id.kilogram);
        final CheckBox lbs_box =(CheckBox) findViewById(R.id.pound);
        username=getIntent().getStringExtra("username");
        usergender=getIntent().getStringExtra("usergender");

        calculate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight=getWeight();
                height=getHeight();
                if(weight.isEmpty() || height.isEmpty()){
                    Toast.makeText(bmiresult.this,"Enter the details",Toast.LENGTH_SHORT).show();
                }else{
                    boolean isin = in_box.isChecked();
                    boolean islbs = lbs_box.isChecked();
                    finalheight = getfinalheight(height,isin);
                    finalweight = getfinalweight(weight,islbs);
                    bmi = bmicalculate(finalheight, finalweight);
                    bmi_result.setText(bmi);
                display(bmi);
            }
        }});
    }
    public String getWeight(){
        String w=weight_enter.getText().toString();
        return w;
    }
    public String getHeight(){
        String h=height_enter.getText().toString();
        return h;
    }
    public double getfinalheight(String height,Boolean isin) {
        double h = Double.parseDouble(height);
        if (isin)
            h = h * 2.54;
        else
            h = h * 0.01;
        return h;
    }
    public double getfinalweight(String weight,Boolean islbs) {
        double w = Double.parseDouble(weight);
        if (islbs)
            w = w * 0.45;
        else
            w = w;
        return w;
    }
    public String bmicalculate(Double finalheight, Double finalweight) {
        double bmi = (finalweight) / Math.pow(finalheight, 2);
        String bmivalue = String.format("%.2f", bmi);
        return bmivalue;
    }
    public void display(String bmi){
        double value = Double.parseDouble(bmi);
        String printmessage="";
        printmessage+=username + " you are ";
        if (usergender == "Female") {
            if (value < 18.5) {
                printmessage += "Underweight";
                bmi_image.setImageResource(R.drawable.underweightfemale);
            } else if (value >= 18.5 && value <= 24.9) {
                printmessage += "Normal";
                bmi_image.setImageResource(R.drawable.normafemale);
            } else if (value > 24.9 && value <= 29.9) {
                printmessage += "Overweight";
                bmi_image.setImageResource(R.drawable.overweightfemale);
            } else if (value > 29.9 && value <= 34.9) {
                printmessage += "Obese";
                bmi_image.setImageResource(R.drawable.obesefemale);
            } else {
                printmessage += "Extremely Obese";
                bmi_image.setImageResource(R.drawable.extremeobesefemale);
            }
        } else {
            if (value < 18.5) {
                printmessage += "Underweight";
                bmi_image.setImageResource(R.drawable.underweightmale);
            } else if (value >= 18.5 && value <= 24.9) {
                printmessage += "Normal";
                bmi_image.setImageResource(R.drawable.normalmale);
            } else if (value > 24.9 && value <= 29.9) {
                printmessage += "Overweight";
                bmi_image.setImageResource(R.drawable.overweightmale);
            } else if (value > 29.9 && value <= 34.9) {
                printmessage += "Obese";
                bmi_image.setImageResource(R.drawable.obesemale);
            } else {
                printmessage += "Extremely Obese";
                bmi_image.setImageResource(R.drawable.extremeobesemale);
            }}
        bmi_statement.setText(printmessage);
    }
}