/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.projetmedevei2;

import java.util.Random;

/**
 *
 * @author louis-alexandre
 */
public class Carte extends NonAchetable{
    private String type;

    public Carte(String type) {
        this.type = type;
    }
    
    public Carte(Carte c){
        this.type = c.type;
    }
    
    public Carte(){
        this.type = "Départ";
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
                Joueur.setCase(new Case("Départ"));
                break;
            }
            case "Prison":{
                Joueur.setCase(new Case("Prison"));
                break;
            }
            case "Gain":{
                Random generateurAleatoire = new Random();
                int x = generateurAleatoire.nextInt(15000);
                Joueur.setArgent(Joueur.getArgent()+5000+x);
                break;
            }
            case "Perte":{
                Random generateurAleatoire = new Random();
                int x = generateurAleatoire.nextInt(14000);
                Joueur.setArgent(Joueur.getArgent()-(1000+x));
                break;
            }
        }
    }
    
}
