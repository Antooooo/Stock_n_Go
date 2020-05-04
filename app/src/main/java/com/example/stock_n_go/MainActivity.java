package com.example.stock_n_go;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList <nouvelle_fiche> nomnewlist;
    private Button boutonnewfiche;
    private Button boutonmesfiches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boutonnewfiche = (Button) findViewById(R.id.button3);
        boutonnewfiche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opennewfiche();
            }
            });


        boutonmesfiches   = (Button) findViewById(R.id.button2);
        boutonmesfiches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmesfiches();

            }
        });

    }
    public void opennewfiche() {
        Intent intent1 = new Intent(this, nouvelle_fiche.class);
                startActivity(intent1);
    }

    public void openmesfiches() {
        Intent intent2 = new Intent(this, mesfiches.class);
        startActivity(intent2);
    }
}






















