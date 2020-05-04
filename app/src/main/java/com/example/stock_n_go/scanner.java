package com.example.stock_n_go;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.zxing.Result;
import java.util.ArrayList;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class scanner extends AppCompatActivity {

    private ZXingScannerView scannerView;
    ArrayList<produitscanner> fichescanner;
    String codeproduit;
    private Button retour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

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

            TextView code_scanner = findViewById(R.id.edit_scanner);
            code_scanner.setText(resultatscan);
        }

    }

    public void enregistrevalduscan (View view){
        TextView code_scanner = (TextView) findViewById(R.id.edit_scanner);
        String valeurduscanner = code_scanner.getText().toString();
        Intent intent = new Intent(this, nouvelle_fiche.class);

        intent.putExtra("Valeurducode",valeurduscanner);

        startActivity(intent);
    }



}
