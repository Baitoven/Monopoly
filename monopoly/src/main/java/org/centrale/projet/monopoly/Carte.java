package org.centrale.projet.monopoly;

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
