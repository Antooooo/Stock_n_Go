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




public class nouvelle_fiche extends AppCompatActivity {
    //création du bouton de retour a l'accueil et scanner et des références pour les Edittexts qui contiennent les informations
    private Button buttonaccueil;
    //création de la array list répondant aux critères créés dans la classe produit
    ArrayList<produit> ficheproduit;
    EditText nomduproduit;
    EditText typedeproduit;
    EditText datedeperemptionduproduit;
    EditText descriptionduproduit;
    private Button bouttonscanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouvelle_fiche);


        //méthode pour le retour à l'activité accueil
        buttonaccueil = (Button) findViewById(R.id.buttonacc1);
        buttonaccueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retouraccueuil1();
            }
        });

        // association des variables aux editText concernés
        nomduproduit = findViewById(R.id.editText2);
        typedeproduit = findViewById(R.id.editText);
        datedeperemptionduproduit = findViewById(R.id.editText3);
        descriptionduproduit = findViewById(R.id.editText4);

        //récupération de la valeur du code barre scanner
        Intent intent = getIntent();
        if (intent!=null){
            String valeurscanner="";
            if(intent.hasExtra("Valeurducode")){
                valeurscanner=intent.getStringExtra("Valeurducode");

                //vérification si le code barre est connu avec le switch case et si oui remplissage des champs pour la création du nouvel objet
                //si la valeur n'est pas reconnue on affiche le message comme quoi ce n'est pas reconnu
                // pour plus de code barres utilisable on utilisera une base de données et des tableaux pour pouvoir stocker les données et remplir les champs
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
                        descriptionduproduit.setText("Magret de Canard délicatement préparé par notre ami Tanguy dans sa maison à Auch, il nous a bien régalé");
                        break;

                    case "87512345":
                        nomduproduit.setText("Chocapik");
                        typedeproduit.setText("Comestible sec");
                        datedeperemptionduproduit.setText("08/03/2021");
                        descriptionduproduit.setText("Pour un petit déjeuner plein d'énergie et une journée bien réussie les Chocapik vont vous accompagnés sur cette longue journée");
                        break;

                    default: Toast.makeText(nouvelle_fiche.this, "Ce code barre n'est pas reconnu ! Veuillez remplir manuellement", Toast.LENGTH_SHORT).show();

                }
            }
        }

      //enregistrement des varaibles rentrée avec l'association du bouton enregistrement

        Button bouttonenregistrement = findViewById(R.id.button4);
        bouttonenregistrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //recupération des préférences stockées
                SharedPreferences prefsStockees = getSharedPreferences("mesPrefs", MODE_PRIVATE);
                Gson gson= new Gson();
                //on associe un string aux valeurs de la liste pour les stocker ici, on utilise la clé pour y acceder
         String listeproduitGson = prefsStockees.getString("cle_listeproduit", "");

        //on creer une array list respectant le format et les critères donc de la classe produit et en y insérant les valeurs stockées dans Sharedpreference
         if (listeproduitGson.equals("")){
             ficheproduit = new ArrayList<produit>(); }
             else {
             produit[] tableaufichestempo = gson.fromJson(listeproduitGson, produit[].class);
             ficheproduit = new ArrayList<produit>(Arrays.asList(tableaufichestempo));
         }

                //Récupération des données dans chaque Edit Text sous la forme d'un string
                String nomproduit = nomduproduit.getText().toString();
                String typeproduit = typedeproduit.getText().toString();
                String dateperemption = datedeperemptionduproduit.getText().toString();
                String descprod = descriptionduproduit.getText().toString();
                //ajout de ces données dans la arraylist créée précedemment en passant par un objet de type produit
                produit ajoutduproduit = new produit(nomproduit, typeproduit, dateperemption,descprod);
                ficheproduit.add(ajoutduproduit);
                //ajout au shared preference
                SharedPreferences.Editor prefsEditor = prefsStockees.edit();
                String listeproduitJson = gson.toJson(ficheproduit);
                prefsEditor.putString("cle_listeproduit", listeproduitJson);
                //sauvegarde des données
                prefsEditor.commit();

                //message de création de la fiche et retour à l'accueil
                Toast.makeText(nouvelle_fiche.this, "Vous avez bien créé une nouvelle fiche produit", Toast.LENGTH_SHORT).show();
                retouraccueuil1();
            }
       });


        //accès au scanner
        bouttonscanner =(Button) findViewById(R.id.bouttonscanner);
        bouttonscanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scan();
            }
        });

    }

// les trois méthodes suivantes permettent d'accéder aux activity concernées(meme principe a chaque fois)

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
