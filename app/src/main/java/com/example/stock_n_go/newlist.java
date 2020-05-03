package com.example.stock_n_go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

public class newlist extends AppCompatActivity {

    private Button suppression;
    private Button boutonacc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newlist);

        final ArrayList<produit> ficheproduit;

//charge
        SharedPreferences prefsStockees = getSharedPreferences("mesPrefs", MODE_PRIVATE);
        Gson gson = new Gson();
        String listeproduitGson = prefsStockees.getString("cle_listeproduit", "");
        if (listeproduitGson.equals("")) {
            ficheproduit = new ArrayList<produit>();
        } else {
            produit[] tableaufichestempo = gson.fromJson(listeproduitGson, produit[].class);
            ficheproduit = new ArrayList<produit>(Arrays.asList(tableaufichestempo));
        }


        BaseAdapter customBaseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return ficheproduit.size();
            }

            @Override
            public Object getItem(int i) {
                return ficheproduit.get(i);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(final int itemIndex, View itemView, ViewGroup viewGroup) {

                if (itemView == null) {
                    itemView = LayoutInflater.from(newlist.this).inflate(R.layout.corpsproduit, null);
                }

                TextView nomtypeprod = (TextView) itemView.findViewById(R.id.textView1);
                TextView dateperemp = (TextView) itemView.findViewById(R.id.textView2);

                produit affichageproduit = (produit) ficheproduit.get(itemIndex);
                final String produitnom = affichageproduit.nomproduit;
                final String produittype = affichageproduit.typeproduit;
                final String peremption = affichageproduit.datedeperemption;
                final String descproduit = affichageproduit.descriptionprod;

                nomtypeprod.setText(produitnom + "  " + produittype);
                dateperemp.setText("Date de péremption : " + peremption);


                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(newlist.this, descriptif_produit.class);
                        intent.putExtra("ficheproduitclic", itemIndex);
                        startActivity(intent);
                    }
                });
                return itemView;
            }
        };
        ListView listeproduit = (ListView) findViewById(R.id.listproduit);
        listeproduit.setAdapter(customBaseAdapter);





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

    public void opensuppression() {
        Intent intent = new Intent(this, suppressionproduit.class);
        startActivity(intent);
    }

    public void retouracc (){
        Intent intent2 = new Intent(this, MainActivity.class);
                startActivity(intent2);
    }

}

