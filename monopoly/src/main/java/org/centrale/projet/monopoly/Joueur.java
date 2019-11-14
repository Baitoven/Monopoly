/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.centrale.projet.monopoly;

import org.centrale.projet.monopoly.monopoly.master.NoMoreMoney;

/**
 *
 * @author Julien
 */
public class Joueur {
    private Case position;
    private Plateau refPlateau;
    private int fortune;
    private String nom;
    private LinkedList<Case> possession = new LinkedList<>();
    
    public Joueur(String nom, Plateau refPlateau){
        this.nom = new String(nom);
        fortune = 1000000;
        this.refPlateau = refPlateau;
        nbGare = 0;
    }
    
    public Case getPosition(){
        return position;
    }
    
    public void setPosition(Case position){
        this.position = position;
    }
    
     public Plateau getRefPlateau(){
        return refPlateau;
    }
    
    public void setRefPlateau(Plateau refPlateau){
        this.refPlateau = refPlateau;
    }
    
    public int getFortune(){
        return fortune;
    }
    
    public void setFortune(int value){
        fortune = value;
    }
    
    public String getNom(){
        return(nom);
    }
    
    public void setNom(String value){
        nom = new String(value);
    }
    
    public int nbGare(){
        int compteur = 0;
        for(int i =0; i<possession.size();i++){
            if ((possession.get(i)) instanceof Gare)
                compteur++;
        }
        return(compteur)
    }
    
    public void gagneArgent(int value){
        fortune = fortune + value;
    }
    
    public void perdArgent(int value){
        fortune = fortune + value;
    }
    
    public void paiement(Joueur j, int paye) throws NoMoreMoney{
        if (this.fortune >= paye){
            j.gagneArgent(paye);
            this.perdArgent(paye);
        }
        else {
            throw new NoMoreMoney("Plus d'argent");
        }
    }
    
    public void acheter(Achetable c) throws NoMoreMoney{
        if (this.fortune >= c.getPrix()){
           this.perdArgent(c.getPrix());
	c.setProprietaire(nom);
        possession.add((Case)c);
        }
        else {
            throw new NoMoreMoney("Plus d'argent pour ça");
        }
    }
    
    public void vendre(Achetable c){
        this.gagneArgent(c.getPrix());
        possession.remove(c);
    }
}
