package com.example.stock_n_go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

public class descriptif_produit extends AppCompatActivity {
 private Button retourlist;

    EditText nom;
    EditText type;
    EditText date;
    EditText descrip;
    ArrayList<produit> ficheproduit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descriptif_produit);


//charge
        Intent intent = getIntent();
        int indiceproduit = intent.getIntExtra("ficheproduitclic", 0);
        SharedPreferences prefsStockees = getSharedPreferences("mesPrefs", MODE_PRIVATE);
        Gson gson = new Gson();
        String listeproduitGson = prefsStockees.getString("cle_listeproduit", "");
        produit[] tableaufichestempo = gson.fromJson(listeproduitGson, produit[].class);
        produit ficheproduit = tableaufichestempo[indiceproduit];



        nom =  findViewById(R.id.Edittext1);
        type =  findViewById(R.id.Edittext2);
        date =  findViewById(R.id.Edittext3);
        descrip = findViewById(R.id.Edittext4);

        nom.setText(ficheproduit.nomproduit);
        type.setText(ficheproduit.typeproduit);
        date.setText(ficheproduit.datedeperemption);
        descrip.setText(ficheproduit.descriptionprod);





        retourlist = (Button) findViewById(R.id.retourlist);
        retourlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retournerliste();

            }
        });

    }

    public void retournerliste() {
        Intent intent = new Intent(this, newlist.class);
        startActivity(intent);
    }
}