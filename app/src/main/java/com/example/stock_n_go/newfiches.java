package com.example.stock_n_go;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
    private Button bouttonscanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newfiches);



        Button bouttonenregistrement = findViewById(R.id.button4);
        buttonaccueil = (Button) findViewById(R.id.buttonacc1);
        buttonaccueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retouraccueuil1();
            }
        });
        nomduproduit = findViewById(R.id.editText2);
        typedeproduit = findViewById(R.id.editText);
        datedeperemptionduproduit = findViewById(R.id.editText3);
        descriptionduproduit = findViewById(R.id.editText4);

        Intent intent = getIntent();
        if (intent!=null){
            String valeurscanner="";
            if(intent.hasExtra("Valeurducode")){
                valeurscanner=intent.getStringExtra("Valeurducode");


                switch (valeurscanner) {
                    case "123456789":
                        nomduproduit.setText("Vinaigre blanc");
                        typedeproduit.setText("Produit ménagé");
                        datedeperemptionduproduit.setText("21/01/2022");
                        descriptionduproduit.setText("Vinaigre blanc de qualité supérieur acheté a l'intermarché et provenant de Marseille");
                        break;

                    case "52486975":
                        nomduproduit.setText("Magret de canard ");
                        typedeproduit.setText("Comestible frais");
                        datedeperemptionduproduit.setText("17/08/2020");
                        descriptionduproduit.setText("Magret de Canard délicatement préparé par notre ami Tanguy dans sa maison à Hoche, il nous a bien régalé");
                        break;

                    case "87512345":
                        nomduproduit.setText("Chocapik");
                        typedeproduit.setText("Comestible sec");
                        datedeperemptionduproduit.setText("08/03/2021");
                        descriptionduproduit.setText("Pour un petit déjeuner plein d'énergie et une journée bien réussie les Chocapik vont vous accompagnés sur cette longue journée");
                        break;



                }
            }
        }

      //enregistrement

        bouttonenregistrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefsStockees = getSharedPreferences("mesPrefs", MODE_PRIVATE);
                Gson gson= new Gson();
         String listeproduitGson = prefsStockees.getString("cle_listeproduit", "");
         if (listeproduitGson.equals("")){
             ficheproduit = new ArrayList<produit>(); }
             else {
             produit[] tableaufichestempo = gson.fromJson(listeproduitGson, produit[].class);
             ficheproduit = new ArrayList<produit>(Arrays.asList(tableaufichestempo));
         }

                String nomproduit = nomduproduit.getText().toString();
                String typeproduit = typedeproduit.getText().toString();
                String dateperemption = datedeperemptionduproduit.getText().toString();
                String descprod = descriptionduproduit.getText().toString();
                produit ajoutduproduit = new produit(nomproduit, typeproduit, dateperemption,descprod);
                ficheproduit.add(ajoutduproduit);
                SharedPreferences.Editor prefsEditor = prefsStockees.edit();
                String listeproduitJson = gson.toJson(ficheproduit);
                prefsEditor.putString("cle_listeproduit", listeproduitJson);
                prefsEditor.commit();


                Toast.makeText(newfiches.this, "Vous avez bien créé une nouvelle fiche produit", Toast.LENGTH_SHORT).show();
                retouraccueuil1();
            }
       });

        bouttonscanner =(Button) findViewById(R.id.bouttonscanner);
        bouttonscanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scan();
            }
        });

    }



    public void scan() {
        Intent intent5 = new Intent(this, scanner.class);
        startActivity(intent5);
    }

        public void retouraccueuil1() {
            Intent intent2 = new Intent(this, MainActivity.class);
            startActivity(intent2);
        }

    public void pagelogin(View view){
        Intent intent3 = new Intent(this, connexion.class);
        startActivity(intent3);
    }


}
