/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.monopoly;

/**
 *
 * @author Céline Balmes
 */
public class PlateauDeJeu {

    public Case avance(int d, Joueur j) {
        int index = (this.plateau.indexOf(j.getPosition()) + d) % 40;
        return this.plateau.get(index);
    }

    public void affichePlateau() {
        for (Case c : this.plateau) {
            System.out.println(c.toString());
        }
    }

    public boolean finDePartie() {
        boolean r = true;
        if(this.jouers.size()>1){
            r = false;
        }
        return r;
    }

    public void afficheJoueur() {
        String joueurString;
        for (joueur j : joueurs) {
            joueurString = j.nom + " " + Integer.toString(j.argent) + " euros\n" + "Cases: \n";

            for (Case c : this.plateau) {
                if (c instanceof Achetable) { // On parcourt le plateau pour trouver les cases qui apartient au joueur j
                    if ((Achetable) c.proprietaire.equals(j)) {
                        joueurString += c.toString + "\n";
                    }
                }
            }
            System.out.println(joueurString);
        }
    }
    
}
