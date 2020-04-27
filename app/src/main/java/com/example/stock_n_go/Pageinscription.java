package com.example.stock_n_go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pageinscription extends AppCompatActivity {

    private Button retourlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pageinscription);
    }

    retourlogin = (Button) findViewById(R.id.retourlog);
    retourlogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            retourpageconnex();
        }
    });



    public void retourpageconnex() {
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }
}
