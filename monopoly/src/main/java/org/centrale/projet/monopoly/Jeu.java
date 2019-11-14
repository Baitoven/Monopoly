package org.centrale.projet.monopoly;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author antoine
 */
public class Jeu {

    public static void main(String[] args) {
        System.out.println("Bienvenue sur le plateau de jeu du Monopoly !\n Combien de joueurs seront parmis nous ?");
        ArrayList<Joueur> listeJoueur = new ArrayList<>();
        PlateauDeJeu plateau = new PlateauDeJeu(listeJoueur);

        Scanner choixJoueur = new Scanner(System.in);
        int nbJoueur = Integer.parseInt(choixJoueur.nextLine());
        for (int i = 0; i < nbJoueur; i++) {
            System.out.println("Quel est le nom du joueur " + Integer.toString(i + 1) + " ?");
            String nomJoueur = choixJoueur.nextLine();
            listeJoueur.add(new Joueur(nomJoueur, plateau));
        }

        plateau.tourDeJeuComplet();

        System.out.println("Fin de partie");
    }
}
