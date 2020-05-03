package com.example.stock_n_go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

public class newlist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newlist);

        ArrayList<produit> ficheproduit;

//charge
        SharedPreferences prefsStockees = getSharedPreferences("mesPrefs", MODE_PRIVATE);
        Gson gson = new Gson();
        String listeproduitGson = prefsStockees.getString("cle_listeproduit", "");
        if (listeproduitGson.equals("")){
            ficheproduit = new ArrayList<produit>(); }
        else {
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
                    itemView = LayoutInflater.from(ficheproduit.this).inflate(R.layout.corpsproduit, null);
                }















    }
}
