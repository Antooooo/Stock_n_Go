package com.example.stock_n_go;

import androidx.appcompat.app.AppCompatActivity;

import android.database.CursorJoiner;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.Result;
import com.google.zxing.client.result.ResultParser;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class scanner extends AppCompatActivity {

    private ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

    }

    public void scancode (View view){
        scannerView = new ZXingScannerView(this);
        scannerView.setResultHandler(new ZxingscannerResultHandler());
        setContentView(scannerView);
        scannerView.startCamera();

    }

    public void onPause(){
        super.onPause();
        scannerView.stopCamera();
    }

    class ZxingscannerResultHandler implements ZXingScannerView.ResultHandler
    {

        public void handleResult (Result result){

        String resultatscan = result.getText();
        Toast.makeText(scanner.this, resultatscan , Toast.LENGTH_SHORT).show();

            setContentView(R.layout.activity_scanner);
            scannerView.stopCamera();
        }

    }


}
