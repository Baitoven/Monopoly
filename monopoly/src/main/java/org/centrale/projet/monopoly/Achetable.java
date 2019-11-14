/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.projetmedevei2;

/**
 *
 * @author louis-alexandre
 */
public abstract class Achetable extends Case{
    private int prix;
    private Joueur proprietaire;

    public Achetable(String nom, int prix) {
        super(nom);
        this.prix = prix;
    }
    
    public Achetable(Achetable a){
        super(a.getNom());
        this.prix = a.prix;
        this.proprietaire = new Joueur(a.proprietaire);
    }
    
    public Achetable(){
        super();
        this.prix = 0;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }
    
    public abstract int calculLoyer(PlateauDeJeu p);
    
}
