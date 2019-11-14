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
public class Constructible extends Achetable{
    private int coefMaison; 
    private int coefHotel; 
    private int loyer;
    private int prixMaison;
    private int prixHotel;
    private int nbMaisons;
    private int nbHotels;

    public Constructible(String nom, int prix, int coefMaison, int coefHotel, int loyer, int prixMaison, int prixHotel) {
        super(nom, prix);
        this.coefMaison = coefMaison;
        this.coefHotel = coefHotel;
        this.loyer = loyer;
        this.prixMaison = prixMaison;
        this.prixHotel = prixHotel;
        this.nbMaisons = 0;
        this.nbHotels = 0;
    }

    public Constructible(Constructible c) {
        super(c.getNom(), c.getPrix(), c.getProprietaire());
        this.coefMaison = c.coefMaison;
        this.coefHotel = c.coefHotel;
        this.loyer = c.loyer;
        this.prixMaison = c.prixMaison;
        this.prixHotel = c.prixHotel;
        this.nbMaisons = c.nbMaisons;
        this.nbHotels = c.nbHotels;
    }
    
    public Constructible(){
        super();
        this.coefMaison = 0;
        this.coefHotel = 0;
        this.loyer = 0;
        this.nbMaisons = 0;
        this.nbHotels = 0;
    }

    public int getCoefMaison() {
        return coefMaison;
    }

    public void setCoefMaison(int coefMaison) {
        this.coefMaison = coefMaison;
    }

    public int getCoefHotel() {
        return coefHotel;
    }

    public void setCoefHotel(int coefHotel) {
        this.coefHotel = coefHotel;
    }
    
    public int getLoyer() {
        return loyer;
    }

    public void setLoyer(int loyer) {
        this.loyer = loyer;
    }

    public int getPrixMaison() {
        return prixMaison;
    }

    public void setPrixMaison(int prixMaison) {
        this.prixMaison = prixMaison;
    }

    public int getPrixHotel() {
        return prixHotel;
    }

    public void setPrixHotel(int prixHotel) {
        this.prixHotel = prixHotel;
    }

    public int getNbMaisons() {
        return nbMaisons;
    }

    public void setNbMaisons(int nbMaisons) {
        this.nbMaisons = nbMaisons;
    }

    public int getNbHotels() {
        return nbHotels;
    }

    public void setNbHotels(int nbHotels) {
        this.nbHotels = nbHotels;
    }
    
    @Override
    public String toString(){
        if(this.getProprietaire() == null){
            return this.getNom() + " (coût : " + this.getPrix() + "€) - sans proprietaire";  
        }
        else{
            return this.getNom() + " (coût : " + this.getPrix() + "€) - propriétaire : " + this.getProprietaire().getNom() +
                    ", " + this.getNbMaisons() + " maison(s), " + this.nbHotels + " hotel(s), loyer = " + this.getLoyer();  
        }
    }

    @Override
    public int calculLoyer() {
        if(this.getProprietaire() == null){
            return 0;
        }
        else{
            return this.getLoyer() + this.getA()*this.getNbMaisons() + this.getB()*this.getNbHotels();
        }
    }
    
    
}
