package org.centrale.projet.monopoly;

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
                j.setPosition(new Depart());
                break;
            }
            case "Prison":{
                j.setPosition(new Prison());
                break;
            }
            case "Gain":{
                Random generateurAleatoire = new Random();
                int x = generateurAleatoire.nextInt(15000);
                j.setArgent(j.getArgent()+5000+x);
                break;
            }
            case "Perte":{
                Random generateurAleatoire = new Random();
                int x = generateurAleatoire.nextInt(14000);
                j.setArgent(j.getArgent()-(1000+x));
                break;
            }
        }
    }
    
    
    
}
