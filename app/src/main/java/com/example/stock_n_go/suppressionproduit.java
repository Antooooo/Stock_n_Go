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

    private Button boutonfiches;
    ArrayList<produit> ficheproduit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suppressionproduit);

//charge
        SharedPreferences prefsStockees = getSharedPreferences("mesPrefs", MODE_PRIVATE);
        Gson gson = new Gson();
        String listeproduitGson = prefsStockees.getString("cle_listeproduit", "");
        produit[] tableaufichestempo = gson.fromJson(listeproduitGson, produit[].class);
        ficheproduit = new ArrayList<produit>(Arrays.asList(tableaufichestempo));

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
                    itemView = LayoutInflater.from(suppressionproduit.this).inflate(R.layout.corpsproduit, null);
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
                    public void onClick(View view) {
                        produit produitciao =  (produit) getItem(itemIndex);
                        Toast.makeText(suppressionproduit.this, "Le produit a bien été supprimé ", Toast.LENGTH_SHORT).show();
                        ficheproduit.remove(produitciao);
                        notifyDataSetChanged();
                    }
                });
                return itemView;
            }
        };
        ListView listeproduit = (ListView) findViewById(R.id.listviewsupp);
        listeproduit.setAdapter(customBaseAdapter);





        boutonfiches = (Button) findViewById(R.id.buttonfiche);
        boutonfiches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefsStockees = getSharedPreferences("mesPrefs", MODE_PRIVATE);
                SharedPreferences.Editor prefsEditor = prefsStockees.edit();
                Gson gson = new Gson();
                String  listeproduitGson = gson.toJson(ficheproduit);
                prefsEditor.putString("cle_listeproduit", listeproduitGson);
                prefsEditor.commit();
                openmesfiches();

            }
        });
    }

    public void openmesfiches() {
        Intent intent = new Intent(this, mesfiches.class);
        startActivity(intent);
    }


}
