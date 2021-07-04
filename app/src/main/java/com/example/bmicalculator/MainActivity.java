package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name;
    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button submit_button =(Button)findViewById(R.id.submit_tag);
        final EditText name_enter =(EditText) findViewById(R.id.EnterName);
        final ImageView female_gender =(ImageView) findViewById(R.id.female);
        final ImageView male_gender =(ImageView) findViewById(R.id.male);

        female_gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = "female";
            }
        });
        male_gender.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = "male";
            }
        }));
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = name_enter.getText().toString();
                if (name == "") {
                    Toast.makeText(MainActivity.this, "Enter Your Name", Toast.LENGTH_SHORT).show();
                } else if (gender == "") {
                    Toast.makeText(MainActivity.this, "Select the Gender", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(MainActivity.this, bmiresult.class);
                    i.putExtra("username",name);
                    i.putExtra("usergender",gender);
                    startActivity(i);
                }
            }
        });
    }
}