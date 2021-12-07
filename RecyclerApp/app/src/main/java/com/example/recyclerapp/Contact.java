package com.example.recyclerapp;

public class Contact {
    String nom;
    String prenom;
    String imgUrl;


    public Contact(String nom, String prenom, String imgUrl) {
        this.nom = nom;
        this.prenom = prenom;
        this.imgUrl = imgUrl;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
