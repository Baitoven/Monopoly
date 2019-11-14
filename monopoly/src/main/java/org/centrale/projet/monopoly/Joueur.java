package org.centrale.projet.monopoly;

import java.util.ArrayList;
import org.centrale.projet.monopoly.NoMoreMoney;


public class Joueur {

    private Case position;
    private PlateauDeJeu refPlateau;
    private int argent;
    private String nom;
    private ArrayList<Case> possession = new ArrayList<>();

    public Joueur(String nom, PlateauDeJeu refPlateau) {
        this.nom = new String(nom);
        argent = 1000000;
        this.refPlateau = refPlateau;
    }

    public Case getPosition() {
        return position;
    }

    public void setPosition(Case position) {
        this.position = position;
    }

    public PlateauDeJeu getRefPlateau() {
        return refPlateau;
    }

    public void setRefPlateau(PlateauDeJeu refPlateau) {
        this.refPlateau = refPlateau;
    }

    public int getArgent() {
        return argent;
    }

    public void setArgent(int value) {
        argent = value;
    }

    public String getNom() {
        return (nom);
    }

    public void setNom(String value) {
        nom = new String(value);
    }
    
    public int nbGare() {
        int compteur = 0;
        for (int i = 0; i < possession.size(); i++) {
            if ((possession.get(i)) instanceof Gare) {
                compteur++;
            }
        }
        return (compteur);
    }

    public void gagneArgent(int value) {
        argent = argent + value;
    }

    public void perdArgent(int value) {
        argent = argent + value;
    }

    public void paiement(Joueur j, int paye) throws NoMoreMoney {
        if (this.argent >= paye) {
            j.gagneArgent(paye);
            this.perdArgent(paye);
        } else {
            throw new NoMoreMoney("Plus d'argent");
        }
    }

    public void acheter(Achetable c) throws NoMoreMoney {
        if (this.argent >= c.getPrix()) {
            this.perdArgent(c.getPrix());
            c.setProprietaire(this);
            possession.add((Case) c);
        } else {
            throw new NoMoreMoney("Plus d'argent pour ça");
        }
    }

    public void vendre(Achetable c) {
        this.gagneArgent(c.getPrix());
        possession.remove(c);
    }
}
