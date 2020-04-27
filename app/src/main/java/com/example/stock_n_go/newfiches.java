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

public class newfiches extends AppCompatActivity {
    private Button buttonaccueil;
    private String chainenom;
    ArrayList<newfiches> nomnewlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newfiches);



        buttonaccueil = (Button) findViewById(R.id.buttonacc1);
        buttonaccueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retouracceuil1();
            }
        });

        EditText nom = (EditText) findViewById(R.id.editText2);
        String chainenom = nom.getText().toString();


        Button bouttonenregistrer = findViewById(R.id.button4);
        bouttonenregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            savedonnees();
            }
        });
        }

            private void savedonnees(){
                SharedPreferences sharedPreferences = getSharedPreferences("donnees sauvegardees", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                Gson gson = new Gson();
                String json = gson.toJson(nomnewlist);
                editor.putString("task list", json);
                editor.apply();
            }

        public void retouracceuil1() {
            Intent intent2 = new Intent(this, MainActivity.class);
            startActivity(intent2);
        }

        public String getnom(){
        return chainenom;
        }

}
