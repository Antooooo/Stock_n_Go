package com.example.stock_n_go;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList <newfiches> nomnewlist;
    private Button boutonnewfiche;
    private Button boutonmesfiches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boutonnewfiche = (Button) findViewById(R.id.button3);
        boutonnewfiche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opennewfiche();
            }
            });


        boutonmesfiches   = (Button) findViewById(R.id.button2);
        boutonmesfiches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmesfiches();

            }
        });

    }
    public void opennewfiche() {
        Intent intent1 = new Intent(this, newfiches.class);
                startActivity(intent1);
    }

    public void openmesfiches() {
        Intent intent2 = new Intent(this, mesfiches.class);
        startActivity(intent2);
    }
}
