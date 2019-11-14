/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.projetmedevei2;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author louis-alexandre
 */
public class Carte extends NonAchetable{
    private String type;

    public Carte(String nom, String type) {
        super(nom);
        this.type = type;
    }
    
    public Carte(Carte c){
        super(c.getNom());
        this.type = c.type;
    }
    
    public Carte(){
        super("Chance");
        Random generateurAleatoire = new Random();
        int n = generateurAleatoire.nextInt(3);
        switch(n){
            case 0:{
                this.type = "Départ";
                break;
            }
            case 1:{
                this.type = "Prison";
                break;
            }
            case 2:{
                this.type = "Gain";
                break;
            }
            case 3:{
                this.type = "Perte";
                break;
            }
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public void action(Joueur j){
        switch(type){
            case "Départ":{
                j.setCase(new Case("Départ"));
                break;
            }
            case "Prison":{
                j.setCase(new Case("Prison"));
                break;
            }
            case "Gain":{
                Random generateurAleatoire = new Random();
                int x = generateurAleatoire.nextInt(15000);
                j.setArgent(Joueur.getArgent()+5000+x);
                break;
            }
            case "Perte":{
                Random generateurAleatoire = new Random();
                int x = generateurAleatoire.nextInt(14000);
                j.setArgent(Joueur.getArgent()-(1000+x));
                break;
            }
        }
    }
    
    
    
}
