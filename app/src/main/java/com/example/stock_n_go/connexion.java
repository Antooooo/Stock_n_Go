package com.example.stock_n_go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class connexion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);


    }
//méthode pour aller à la page d'inscription via le bouton

    public void pageincript(View view){
        Intent intent1 = new Intent(this, inscription.class); //utilisation de l'intent pour naviguer entre les activity
        startActivity(intent1);
    }


}
