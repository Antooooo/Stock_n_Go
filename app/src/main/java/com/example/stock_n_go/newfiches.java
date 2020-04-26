package com.example.stock_n_go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class newfiches extends AppCompatActivity {
    private Button buttonaccueil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newfiches);



        buttonaccueil = (Button) findViewById(R.id.buttonacc);
        buttonaccueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retouracceuil1();
            }
        });




        }
        public void retouracceuil1() {
            Intent intent2 = new Intent(this, MainActivity.class);
            startActivity(intent2);
        }


}
