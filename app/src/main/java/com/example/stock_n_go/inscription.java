package com.example.stock_n_go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class inscription extends AppCompatActivity {

    private Button retourconnexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);


        retourconnexion = (Button) findViewById(R.id.retourlog);
        retourconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retourpageconnexion();
            }
        });

    }

    public void retourpageconnexion() {
        Intent intent1 = new Intent(this, connexion.class);
        startActivity(intent1);
    }
}
