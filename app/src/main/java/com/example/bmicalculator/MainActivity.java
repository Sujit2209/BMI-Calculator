package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name="";
    String gender="";
    ImageView maleicon;
    ImageView femaleicon;
    TextView maleText;
    TextView femaleText;
    EditText name_enter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         Button submit_button =(Button)findViewById(R.id.submit_tag);
         name_enter =(EditText) findViewById(R.id.EnterName);
         maleicon=(ImageView) findViewById(R.id.male);
         femaleicon=(ImageView) findViewById(R.id.female);
         maleText=(TextView) findViewById(R.id.maleText);
         femaleText=(TextView) findViewById(R.id.femaleText);

         femaleicon.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 femaleGender();
             }
         });

         maleicon.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 maleGender();
             }
         });

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=getName();
                if (name.isEmpty() || gender.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter the details", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(MainActivity.this, bmiresult.class);
                    i.putExtra("username",name);
                    i.putExtra("usergender",gender);
                    startActivity(i);
                }
            }
        });
    }
    public void femaleGender(){
        gender="Female";
        femaleicon.setImageResource(R.drawable.femaleicon);
        maleicon.setImageResource(R.drawable.maleicon_light);
    }
    public void maleGender(){
        gender="Male";
        femaleicon.setImageResource(R.drawable.femaleicon_light);
        maleicon.setImageResource(R.drawable.maleicon);
    }
    public String getName(){
        String name=name_enter.getText().toString();
        return name;
    }
}