package com.example.stock_n_go;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    //initialisation des boutons pour aller aux pages voulus
    private Button boutonnewfiche;
    private Button boutonmesfiches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //onclick listener pour aller a l'activity nouvelle fiche une fois le bouton correspondant cliqué (on utilise la méthode ci dessous)
        boutonnewfiche = (Button) findViewById(R.id.button3);
        boutonnewfiche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opennewfiche();
            }
            });

        //meme chose que précedemment mais pour voir les listes
        boutonmesfiches   = (Button) findViewById(R.id.button2);
        boutonmesfiches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmesfiches();

            }
        });

    }

    //méthode pour aller vers l'activity  nouvelle fiche avec l'intent
    public void opennewfiche() {
        Intent intent1 = new Intent(this, nouvelle_fiche.class);
                startActivity(intent1);
    }

    //méthode pour aller vers l'activity  mes fiche avec l'intent
    public void openmesfiches() {
        Intent intent2 = new Intent(this, mesfiches.class);
        startActivity(intent2);
    }
}






















