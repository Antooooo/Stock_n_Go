package com.example.stock_n_go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mesfiches extends AppCompatActivity {

    private Button bouttonaccueil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesfiches);



        bouttonaccueil = (Button) findViewById(R.id.accueil);
        bouttonaccueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retouracceuil2();
            }
        });




    }
    public void retouracceuil2() {
        Intent intent2 = new Intent(this, MainActivity.class);
        startActivity(intent2);
    }
    }
