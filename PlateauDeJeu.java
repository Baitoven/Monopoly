/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fabra
 */
public class PlateauDeJeu {
	/** La liste des cases du plateau de jeu */
    private ArrayList<Case> plateau ;
    
    public PlateauDeJeu(ArrayList<Case>)
    
    /**
    * Permet de faire avancer un joueur d'un certain nombre de cases.
    * @param d Le nombre de cases dont le joueur va avancer
    * @param j Le joueur que l'on veut faire avancer
    * @return La case où va arriver le joueur
    */
    public Case avance(int d, Joueur j) {
        int index = (this.plateau.indexOf(j.getPosition()) + d) % 40;
        return this.plateau.get(index);
    }

    /**
    * Permet d'afficher le plateau
    */
    public void affichePlateau() {
        for (Case c : this.plateau) {
            System.out.println(c.toString());
        }
    }
	
	/**
	* Permet de dire si la partie est terminée ou non
	* @return Booléen, vrai si la partie est finie, non sinon
	*/
    public boolean finDePartie() {
        boolean r = true;
        if(this.jouers.size()>1){
            r = false;
        }
        return r;
    }
	
	/**
	* Permet d'afficher le Joueur
	*/
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
    
    /**
    * Permet de faire jouer tous les joueurs jusqu'à la fin de la partie
    */
    public void tourDeJeuComplet(){
        boolean fin = finDePartie();
        int nbTour = 0;
        while (!fin){
            nbTour = nbTour + 1;
            Iterator<Joueur> itJoueur = this.joueurs.iterator();
            while (itJoueur.hasNext()){
                Joueur j = itJoueur.next();
                try {
                    j.tourDeJeu();
                }
                catch (NoMoreMoney m){
                    itJoueur.remove();
                }
            }
            fin = finDePartie();
        }
    }
}
