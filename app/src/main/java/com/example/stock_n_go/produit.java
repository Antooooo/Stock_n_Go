package com.example.stock_n_go;

public class produit {
    // attributs personnalisés pour la classe Etudiant
    public String nomproduit;
    public String typeproduit;
    public String datedeperemption;
    public String descriptionprod;

    // constructeur classique (3 parametres affectant les attributs)
    public produit (String prodnom,  String prodtype, String prodperemp, String proddesc ) {
        nomproduit = prodnom;
        typeproduit = prodtype;
        datedeperemption = prodperemp;
        descriptionprod = proddesc;
    }

    // la méthode toString. Classique mais inutilisée ici
    // employée seulement à des fins de debug
    @Override
    public String toString() {
        return "Nouveau produit : " + nomproduit + "qui est un " + typeproduit + "\n";
    }



}
