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

public class descriptif_produit extends AppCompatActivity {
 private Button retourlist;

 //initiatlisation des 4 editText des données nécessaires
    EditText nom;
    EditText type;
    EditText date;
    EditText descrip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descriptif_produit);


//chargement des données stockées dans le Shared preference et mise dans un tableau fiche produit basé sur la structure crée dans la classe produit
        //comme précédemment on utilise le sharedpréference avec la bonne clé et on met les valeur récupérée
        //dans une arraylist de produit
        Intent intent = getIntent();
        int indiceproduit = intent.getIntExtra("ficheproduitclic", 0);
        SharedPreferences prefsStockees = getSharedPreferences("mesPrefs", MODE_PRIVATE);
        Gson gson = new Gson();
        String listeproduitGson = prefsStockees.getString("cle_listeproduit", "");
        produit[] tableaufichestempo = gson.fromJson(listeproduitGson, produit[].class);
        produit ficheproduit = tableaufichestempo[indiceproduit];


//on récupère les editstext voulus pour les remplir
        nom =  findViewById(R.id.Edittext1);
        type =  findViewById(R.id.Edittext2);
        date =  findViewById(R.id.Edittext3);
        descrip = findViewById(R.id.Edittext4);

        // remplissage des Editiext avec les données récupérées plus haut
        // Les edittext ne sont pas editables manuellements (android:editable="false" dans le layout)
        nom.setText(ficheproduit.nomproduit);
        type.setText(ficheproduit.typeproduit);
        date.setText(ficheproduit.datedeperemption);
        descrip.setText(ficheproduit.descriptionprod);




        //onclick listener pour lorsqu'on appuie sur le bouton de retour a la liste avec la méthode associée
        retourlist = (Button) findViewById(R.id.retourlist);
        retourlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retournerliste();

            }
        });

    }

    //méthode pour retournée à la page de la liste
    public void retournerliste() {
        Intent intent = new Intent(this, voirliste.class);
        startActivity(intent);
    }

    //méthode pour accéder a la page de login (associée à l'image bouton)
    public void pagelogin(View view){
        Intent intent3 = new Intent(this, connexion.class);
        startActivity(intent3);
    }
}