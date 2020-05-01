package com.example.stock_n_go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.ArrayList;

public class newfiches extends AppCompatActivity {
    private Button buttonaccueil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newfiches);

       EditText textenomliste = findViewById(R.id.editText2);
       EditText texttypelist = findViewById(R.id.editText);
       Button bouttonajouter = findViewById(R.id.button4);

        buttonaccueil = (Button) findViewById(R.id.buttonacc1);
        buttonaccueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retouracceuil1();
            }
        });


        //enregistrement

        bouttonajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefsStockees = getSharedPreferences("mesPrefs", MODE_PRIVATE);
                Gson gson= new Gson();
         String listeproduitGson = prefsStockees.getString("cle_listeproduit", "");
         if (listeproduitGson.equals("")){
             listedesproduits = new ArrayList<Produit>();

         }

            }
        });



        }



        public void retouracceuil1() {
            Intent intent2 = new Intent(this, MainActivity.class);
            startActivity(intent2);
        }



}
