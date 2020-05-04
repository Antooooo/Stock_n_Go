package com.example.stock_n_go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

public class voirliste extends AppCompatActivity {

    //déclaration des boutons qui seront utilisés pour changer d'actvité
    private Button suppression;
    private Button boutonacc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voirliste);

        //on créé une arraylist de type produit
        final ArrayList<produit> ficheproduit;

//chargement des données comme précédemment avec le shared préférence
        //recupération des préférences stockées
        SharedPreferences prefsStockees = getSharedPreferences("mesPrefs", MODE_PRIVATE);
        Gson gson = new Gson();
        //on associe un string aux valeurs de la liste pour les stocker ici, on utilise la clé pour y acceder
        String listeproduitGson = prefsStockees.getString("cle_listeproduit", "");
        //on creer une array list respectant le format et les critères donc de la classe produit et en y insérant les valeurs stockées dans Sharedpreference
        if (listeproduitGson.equals("")) {
            ficheproduit = new ArrayList<produit>();
        } else {
            //tableau temporaire ayant les données en Json pour basculer les activités dans la arraylist
            produit[] tableaufichestempo = gson.fromJson(listeproduitGson, produit[].class);
            //arraylist finale de type produit avec les données chargées
            ficheproduit = new ArrayList<produit>(Arrays.asList(tableaufichestempo));
        }


        //creation du base adapter afin de modifier la list view comme on veut et ainsi mettre les items que l'ont veut avec le format désiré
        BaseAdapter customBaseAdapter = new BaseAdapter() {
            @Override
            //récupération de la taille de la arraylist
            public int getCount() {
                return ficheproduit.size();
            }

            @Override
            //on prends les données une par unes en prenant l'élément à la position i
            public Object getItem(int i) {
                return ficheproduit.get(i);
            }

            @Override
            //indice de récupération
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(final int itemIndex, View itemView, ViewGroup viewGroup) {

                if (itemView == null) {
                    //on associe à l'item pris le design prédéfini dans la layout corpsproduit afin d'avoir le rendu voulu
                    itemView = LayoutInflater.from(voirliste.this).inflate(R.layout.corpsproduit, null);
                }

                //on récupère les cadres spécifiques pour chaque partie de l'item que l'on voudra créer
                TextView nomtypeprod = (TextView) itemView.findViewById(R.id.textView1);
                TextView dateperemp = (TextView) itemView.findViewById(R.id.textView2);

                //récupération des données et stockage dans des valeurs string pour les mettres ou on veut après
                produit affichageproduit = (produit) ficheproduit.get(itemIndex);
                final String produitnom = affichageproduit.nomproduit;
                final String produittype = affichageproduit.typeproduit;
                final String peremption = affichageproduit.datedeperemption;
                final String descproduit = affichageproduit.descriptionprod;

                //on associe aux cadres défini précédemment les valeurs que l'on vient de récupérer
                nomtypeprod.setText(produitnom + "  " + produittype);
                dateperemp.setText("Date de péremption : " + peremption);


                //on crée un évènement si on clique sur un item de la listview créée
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //intent pour changer d'activité et aller sur le descriptif du produit
                        Intent intent = new Intent(voirliste.this, descriptif_produit.class);
                        //Extra utiliser pour stocker la valeur de l'index pour savoir sur quel item on a cliqué
                        //on réutilise l'extra pour afficher les bonnes informations dans descriptif produit
                        intent.putExtra("ficheproduitclic", itemIndex);
                        startActivity(intent);
                    }
                });
                return itemView;
            }
        };
        //on récupère la list view classique
        ListView listeproduit = (ListView) findViewById(R.id.listproduit);
        //on adapte la list view modifiée qu'on vient de créer
        listeproduit.setAdapter(customBaseAdapter);




        //on associe les boutons aux méthodes voulus pour aller sur ladite activité

        suppression = (Button) findViewById(R.id.buttonsupp);
        suppression.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensuppression();

            }
        });

        boutonacc = (Button) findViewById(R.id.buttonacc1);
        boutonacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retouracc();
            }
        });


    }


    //comme avant on retrouve les méthodes pour retourner aux activités désirées

    public void opensuppression() {
        Intent intent = new Intent(this, suppressionproduit.class);
        startActivity(intent);
    }

    public void retouracc (){
        Intent intent2 = new Intent(this, MainActivity.class);
                startActivity(intent2);
    }

    public void pagelogin(View view){
        Intent intent3 = new Intent(this, connexion.class);
        startActivity(intent3);
    }

}

