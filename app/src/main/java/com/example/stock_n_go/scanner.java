package com.example.stock_n_go;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.zxing.Result;
import java.util.ArrayList;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class scanner extends AppCompatActivity {

    private ZXingScannerView scannerView;
    ArrayList<produitscanner> fichescanner;
    String codeproduit;
    EditText code_scanner;
    private Button retour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
/*
        Button enregistrementscanner = findViewById(R.id.scanload);
        enregistrementscanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefscanner = getSharedPreferences("stockagescan", MODE_PRIVATE);
                Gson gson= new Gson();
                String produitscannerGson = prefscanner.getString("cle_scanner", "");
                if (produitscannerGson.equals("")){
                    fichescanner = new ArrayList<produitscanner>(); }
                else {
                    produitscanner[] tableauscannertempo = gson.fromJson(produitscannerGson, produitscanner[].class);
                    fichescanner = new ArrayList<produitscanner>(Arrays.asList(tableauscannertempo));
            }
        });
        }
    } */
        retour = (Button) findViewById(R.id.button8);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmesfiches();
            }
        });

    }

    public void scancode(View view) {
        scannerView = new ZXingScannerView(this);
        scannerView.setResultHandler(new ZxingscannerResultHandler());
        setContentView(scannerView);
        scannerView.startCamera();

    }

    public void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    class ZxingscannerResultHandler implements ZXingScannerView.ResultHandler {

        public void handleResult(Result result) {

            String resultatscan = result.getText();
            Toast.makeText(scanner.this, resultatscan, Toast.LENGTH_SHORT).show();

            setContentView(R.layout.activity_scanner);
            scannerView.stopCamera();

            code_scanner = findViewById(R.id.edit_scanner);
            code_scanner.setText(resultatscan);
        }


    }

    public void openmesfiches() {
        Intent intent2 = new Intent(this, newfiches.class);
        startActivity(intent2);
    }


}
