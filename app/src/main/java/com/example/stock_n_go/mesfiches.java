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


        //listener pour appeler les méthodes correcpondantes lorsque le clic est fait sur le bon bouton
        bouttonaccueil = (Button) findViewById(R.id.accueil);
        bouttonaccueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retouracceuil2();
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

    //On a ici les 3 méthodes pour les 3 activity correspondantes respectivement : accueil, voir la liste et page de connexion

    public void retouracceuil2() {
        Intent intent2 = new Intent(this, MainActivity.class);
        startActivity(intent2);
    }

    public void gofiche1() {
        Intent intent4 = new Intent(this, voirliste.class);
        startActivity(intent4);
    }

    //la méthode est directement liée au bouton par la ligne Onclick dans la layout et non par un listener ci dessus
    public void pagelogin(View view){
        Intent intent3 = new Intent(this, connexion.class);
        startActivity(intent3);
    }

    }
