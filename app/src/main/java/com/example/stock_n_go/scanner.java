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

    //cette méthode est directement associée au bouton concerné grace au Onclick trouvable dans le layout au bouton concerné
    public void scancode(View view) {
        //création du scanner a partir de la bibliothèque Zxing importée
        scannerView = new ZXingScannerView(this);
        scannerView.setResultHandler(new ZxingscannerResultHandler());
        setContentView(scannerView);
        //allumage de la camera
        scannerView.startCamera();

    }

    //méthode d'arret de la caméra
    public void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    class ZxingscannerResultHandler implements ZXingScannerView.ResultHandler {

        //méthode pour récupérer les resultats du scanner
        public void handleResult(Result result) {
            //on récupère le résultat du scanner dans la variable resultatscan
            String resultatscan = result.getText();
            Toast.makeText(scanner.this, "Code barre lu !", Toast.LENGTH_SHORT).show();

            setContentView(R.layout.activity_scanner);
            //arret camera
            scannerView.stopCamera();

            //on met le code scanné dans le Text view assigné pour l'avoir en visuel au besoin
            TextView code_scanner = findViewById(R.id.edit_scanner);
            code_scanner.setText(resultatscan);
        }

    }


    //méthode de récupération du code scanné
    public void enregistrevalduscan (View view){
        //on récupère la valeur dans le Textview et on l'associe a la variable valeurduscanner
        TextView code_scanner = (TextView) findViewById(R.id.edit_scanner);
        String valeurduscanner = code_scanner.getText().toString();
        //Intent pour retourner à l'activité nouvelle fiche
        Intent intent = new Intent(this, nouvelle_fiche.class);
        //on utilise un Extra pour stocker la variable du code barre et la récupérer dans l'activité nouvelle fiche
        // et ainsi vérifier le produit grace au code du scanner
        intent.putExtra("Valeurducode",valeurduscanner);

        startActivity(intent);
    }



}
