package com.example.stock_n_go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class inscription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);


    }

    public void pagelogin(View view){
        Intent intent3 = new Intent(this, connexion.class);
        startActivity(intent3);
    }

    public void validation(View view){
        Intent intent2 = new Intent(this, MainActivity.class);
        Toast.makeText(inscription.this,"Vous êtes bien inscrit",Toast.LENGTH_SHORT).show();
        startActivity(intent2);
    }
}
