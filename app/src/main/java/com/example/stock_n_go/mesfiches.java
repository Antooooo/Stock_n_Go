package com.example.stock_n_go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mesfiches extends AppCompatActivity {

    private Button bouttonaccueil;
    private Button connexion;
    private Button bouttonfiche;
    private Button scanner;

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

        connexion = (Button) findViewById(R.id.button3);
        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pageconnexion();
            }
        });

        bouttonfiche = (Button) findViewById(R.id.button4);
        bouttonfiche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gofiche1();
            }
        });



    }
    public void retouracceuil2() {
        Intent intent2 = new Intent(this, MainActivity.class);
        startActivity(intent2);
    }

    public void pageconnexion() {
        Intent intent3 = new Intent(this, inscription.class);
        startActivity(intent3);
    }

    public void gofiche1() {
        Intent intent4 = new Intent(this, voirliste.class);
        startActivity(intent4);
    }
    public void pagelogin(View view){
        Intent intent3 = new Intent(this, connexion.class);
        startActivity(intent3);
    }

    }
