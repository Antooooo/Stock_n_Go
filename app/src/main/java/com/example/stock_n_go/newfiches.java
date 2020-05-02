package com.example.stock_n_go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;




public class newfiches extends AppCompatActivity {
    private Button buttonaccueil;
    ArrayList<produit> ficheproduit;
    EditText nomduproduit;
    EditText typedeproduit;
    EditText datedeperemptionduproduit;
    EditText descriptionduproduit;

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

        nomduproduit = findViewById(R.id.editText2);
        typedeproduit = findViewById(R.id.editText);
        datedeperemptionduproduit = findViewById(R.id.editText3);
        descriptionduproduit = findViewById(R.id.editText4);

      //enregistrement

       bouttonajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefsStockees = getSharedPreferences("mesPrefs", MODE_PRIVATE);
                Gson gson= new Gson();
         String listeproduitGson = prefsStockees.getString("cle_listeproduit", "");
         if (listeproduitGson.equals("")){
             ficheproduit = new ArrayList<produit>(); }
             else {
             produit[] tableaufichestempo = gson.fromJson(listeproduitGson, produit[].class);
             // reconstitution d'une arrayList a partir du tableau tableauEtudiantsTemporaire
             ficheproduit = new ArrayList<produit>(Arrays.asList(tableaufichestempo));
         }
                /** creation d'un nouvel étudiant **/
                String nomproduit = nomduproduit.getText().toString();
                String typeproduit = typedeproduit.getText().toString();
                String dateperemption = datedeperemptionduproduit.getText().toString();
                String descprod = descriptionduproduit.getText().toString();
                produit ajoutduproduit = new produit(nomproduit, typeproduit, dateperemption,descprod);
                ficheproduit.add(ajoutduproduit);
                SharedPreferences.Editor prefsEditor = prefsStockees.edit();
                String listeproduitGson = gson.toJson(ficheproduit);
                prefsEditor.putString("cle_listeproduit", listeproduitGson);
                prefsEditor.commit();


                Toast.makeText(newfiches.this, "Vous avez bien créé une nouvelle fiche produit", Toast.LENGTH_SHORT).show();
            }
       });

    }

        public void retouracceuil1() {
            Intent intent2 = new Intent(this, MainActivity.class);
            startActivity(intent2);
        }



}
