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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;

public class suppressionproduit extends AppCompatActivity {
    //déclaration du bouton de retour au fiche et de la arraylist de type produit pour récupérer les valeurs stockées dans shared preference
    private Button boutonfiches;
    ArrayList<produit> ficheproduit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suppressionproduit);

//chargement des données comme précédemment avec le shared préférence
        //recupération des préférences stockées
        SharedPreferences prefsStockees = getSharedPreferences("mesPrefs", MODE_PRIVATE);
        Gson gson = new Gson();
        //on associe un string aux valeurs de la liste pour les stocker ici, on utilise la clé pour y acceder
        String listeproduitGson = prefsStockees.getString("cle_listeproduit", "");
        //tableau temporaire ayant les données en Json pour basculer les activités dans la arraylist
        produit[] tableaufichestempo = gson.fromJson(listeproduitGson, produit[].class);
        //on creer une array list respectant le format et les critères donc de la classe produit et en y insérant les valeurs stockées dans Sharedpreference
        ficheproduit = new ArrayList<produit>(Arrays.asList(tableaufichestempo));

        //creation du base adapter afin de modifier la list view comme on veut et ainsi mettre les items que l'ont veut avec le format désiré
        BaseAdapter customBaseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                //récupération de la taille de la arraylist
                return ficheproduit.size();
            }

            @Override
            public Object getItem(int i) {
                //on prends les données une par unes en prenant l'élément à la position i
                return ficheproduit.get(i);
            }

            @Override
            public long getItemId(int i) {
                //indice de récupération
                return i;
            }

            @Override
            public View getView(final int itemIndex, View itemView, ViewGroup viewGroup) {

                if (itemView == null) {
                    //on associe à l'item pris le design prédéfini dans la layout corpsproduit afin d'avoir le rendu voulu
                    itemView = LayoutInflater.from(suppressionproduit.this).inflate(R.layout.corpsproduit, null);
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

                //on crée un évènement si on clique sur un item de la listview créée en l'occurrence la supression
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //on récupère l'item voulu dans la liste
                        produit produitciao =  (produit) getItem(itemIndex);
                        //on enlève le produit choisi de la arraylist
                        ficheproduit.remove(produitciao);
                        //on affiche un message comme quoi le produit est bien supprimé
                        Toast.makeText(suppressionproduit.this, "Le produit a bien été supprimé ", Toast.LENGTH_SHORT).show();
                        //on actualise la list view afin de faire disparaitre le produit définitivement de partout
                        notifyDataSetChanged();
                    }
                });
                return itemView;
            }
        };
        ListView listeproduit = (ListView) findViewById(R.id.listviewsupp);
        listeproduit.setAdapter(customBaseAdapter);





        //on associe au bouton dit de "sauvegarde" cet évènement
        boutonfiches = (Button) findViewById(R.id.buttonfiche);
        boutonfiches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //on modifie les données dans le shared preference afin de l'actualiser
                SharedPreferences prefsStockees = getSharedPreferences("mesPrefs", MODE_PRIVATE);
                SharedPreferences.Editor prefsEditor = prefsStockees.edit();
                Gson gson = new Gson();
                String  listeproduitGson = gson.toJson(ficheproduit);
                //on edit le shared préference avec la bonne clé
                prefsEditor.putString("cle_listeproduit", listeproduitGson);
                //on l'actualise
                prefsEditor.commit();
                //on revient à l'activité mes fiches
                openmesfiches();

            }
        });
    }

    public void openmesfiches() {
        Intent intent = new Intent(this, mesfiches.class);
        startActivity(intent);
    }


}
