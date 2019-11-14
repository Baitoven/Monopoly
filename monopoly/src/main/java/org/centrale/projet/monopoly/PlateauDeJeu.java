package org.centrale.projet.monopoly;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author fabra
 */
public class PlateauDeJeu {

    /**
     * La liste des cases du plateau de jeu
     */
    private ArrayList<Case> plateau;

    /**
     * La liste des joueurs de la partie
     */
    private LinkedList<Joueur> joueurs;

    /**
     * Constructeur d'un plateau de jeu
     */
    public PlateauDeJeu(LinkedList<Joueur> j) {
        plateau = new ArrayList<Case>();
        joueurs = new LinkedList<Joueur>(j);
    }

    /**
     * Méthode qui initialise le plateau de jeu
     */
    public void initPlateau() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                // Case 0
                Depart d = new Depart();
                plateau.add(d);

                // Case 1
                Constructible c = new Constructible("Boulevard de Belleville", 60, 6, 30, 180, 40);
                plateau.add(c);

                // Case 2
                Carte ca = new Carte("Caisse de communauté");
                plateau.add(ca);

                // Case 3
                c = new Constructible("Rue Lecourbe", 60, 6, 30, 180, 40);
                plateau.add(c);

                // Case 4
                ca = new Carte("Impôts sur le revenu");
                plateau.add(ca);

                // Case 5
                Gare g = new Gare("Montparnasse");
                plateau.add(g);

                // Case 6
                c = new Constructible("Rue de Vaugirard", 100, 10, 50, 300, 60);
                plateau.add(c);

                // Case 7
                c = new Carte();
                plateau.add(c);

                // Case 8
                c = new Constructible("Rue de Courcelles", 100, 10, 50, 300, 60);
                plateau.add(c);

                // Case 9
                c = new Constructible("Avenue de la République", 120, 12, 60, 360, 70);
                plateau.add(c);

                // Case 10
                Prison p = new Prison();
                plateau.add(p);

                // Case 11
                c = new Constructible("Boulevard de la Villette", 140, 14, 70, 420, 80);
                plateau.add(c);

                // Case 12
                Service s = new Service("Electricité");
                plateau.add(s);

                // Case 13
                c = new Constructible("Avenue de Neuilly", 140, 14, 70, 420, 80);
                plateau.add(c);

                // Case 14
                c = new Constructible("Rue de Paradis", 160, 16, 80, 480, 100);
                plateau.add(c);

                // Case 15
                g = new Gare("Lyon");
                plateau.add(g);

                // Case 16
                c = new Constructible("Avenue Mozart", 180, 18, 90, 540, 110);
                plateau.add(c);

                // Case 17
                ca = new Carte("Caisse de communauté");
                plateau.add(ca);

                // Case 18
                c = new Constructible("Boulevard Saint-Michel", 180, 18, 90, 540, 110);
                plateau.add(c);

                // Case 19
                c = new Constructible("Place Pigalle", 200, 20, 100, 600, 120);
                plateau.add(c);

                // Case 20
                ca = new Carte();
                plateau.add(ca);

                // Case 21
                c = new Constructible("Avenue de Matignon", 220, 22, 110, 660, 130);
                plateau.add(c);

                // Case 22
                c = new Carte();
                plateau.add(c);

                // Case 23
                c = new Constructible("Boulevard Malesherbes", 220, 22, 110, 660, 130);
                plateau.add(c);

                // Case 24
                c = new Constructible("Avenue Henri-Martin", 240, 24, 120, 720, 140);
                plateau.add(c);

                // Case 25
                g = new Gare("Nord");
                plateau.add(g);

                // Case 26
                c = new Constructible("Faubourg Saint-Honoré", 260, 26, 130, 780, 160);
                plateau.add(c);

                // Case 27
                c = new Constructible("Place de la bourse", 260, 26, 130, 780, 160);
                plateau.add(c);

                // Case 28
                s = new Service("Eau");
                plateau.add(s);

                // Case 29
                c = new Constructible("Rue La Fayette", 280, 28, 140, 840, 170);
                plateau.add(c);

                // Case 30
                p = new Prison();
                plateau.add(p);

                // Case 31
                c = new Constructible("Avenue de Breteuil", 300, 30, 150, 900, 180);
                plateau.add(c);

                // Case 32
                c = new Constructible("Avenue Foch", 300, 30, 150, 900, 180);
                plateau.add(c);

                // Case 33
                ca = new Carte("Caisse de communauté");
                plateau.add(ca);

                // Case 34
                c = new Constructible("Boulevard des Capucines", 320, 32, 160, 960, 190);
                plateau.add(c);

                // Case 35
                g = new Gare("Saint-Lazare");
                plateau.add(g);

                // Case 36
                ca = new Carte("Chance");
                plateau.add(ca);

                // Case 37
                c = new Constructible("Avenue des Champs-Elysées", 350, 35, 175, 1050, 220);
                plateau.add(c);

                // Case 38
                ca = new Carte("Taxe");
                plateau.add(ca);

                // Case 39
                c = new Constructible("Rue de la paix", 400, 40, 200, 1200, 240);
                plateau.add(c);
            }
        }
    }

    public int nbGares(Joueur j) {
        int compteur = 0;
        for (Case c : plateau) {
            if (c instanceof Gare) {
                Joueur proprio = ((Gare)c).getProprietaire();
                if (proprio.equals(j)) {
                    compteur++;
                }
            }
        }
        return compteur;
    }

    /**
     * Méthode qui renvoie une case mais qui ne déplace pas le joueur
     *
     * @param d Nombre de cases à se déplacer
     * @param j Objet de la classe Joueur
     * @return Objet de la classe Case
     */
    public Case avance(int d, Joueur j) {
        int index = (this.plateau.indexOf(j.getPosition()) + d) % 40;
        return this.plateau.get(index);
    }

    /**
     * Affiche toutes les cases (et ses informations) du plateau
     */
    public void affichePlateau() {
        for (Case c : this.plateau) {
            System.out.println(c.toString());
        }
    }

    /**
     * Vérifie si la partie est finie
     *
     * @return r true = fin de partie et false = partie en cours
     */
    public boolean finDePartie() {
        boolean r = true;
        if (this.joueurs.size() > 1) {
            r = false;
        }
        return r;
    }

    /**
     * Méthode pour afficher les informations de chaque joueur
     */
    public void afficheJoueur() {
        String joueurString;
        for (Joueur j : joueurs) {
            joueurString = j.getNom() + " " + Integer.toString(j.getArgent()) + " euros\n" + "Cases: \n";

            for (Case c : this.plateau) {
                if (c instanceof Achetable) { // On parcourt le plateau pour trouver les cases qui apartient au joueur j
                    if (((Achetable)c).getProprietaire().equals(j)) {
                        joueurString += c.toString() + "\n";
                    }
                }
            }
            System.out.println(joueurString);
        }
    }

    /**
     * Permet de faire jouer tous les joueurs jusqu'à la fin de la partie
     */
    public void tourDeJeuComplet() {
        boolean fin = finDePartie();
        int nbTour = 0;
        while (!fin) {
            nbTour = nbTour + 1;
            Iterator<Joueur> itJoueur = this.joueurs.iterator();
            while (itJoueur.hasNext()) {
                Joueur j = itJoueur.next();
                try {
                    j.tourDeJeu();
                } catch (NoMoreMoney m) {
                    itJoueur.remove();
                }
            }
            fin = finDePartie();
        }
    }
}
