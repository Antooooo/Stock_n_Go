package com.example.stock_n_go;

public class produit {


    //iniitalisation des chaines de caractères nécessaires pour la mise en forme d'un produit
    public String nomproduit;
    public String typeproduit;
    public String datedeperemption;
    public String descriptionprod;


    //constructeur avec les 4 paramètres voulus afin de créer des arraylists récupérant ces données plus tard
    public produit (String prodnom,  String prodtype, String prodperemp, String proddesc ) {
        nomproduit = prodnom;
        typeproduit = prodtype;
        datedeperemption = prodperemp;
        descriptionprod = proddesc;
    }

    }

