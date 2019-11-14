package org.centrale.projet.monopoly;

/**
 *
 * @author louis-alexandre
 */
public class Gare extends Achetable {

    public Gare(String nom) {
        super(nom, 200);
    }

    public Gare(Gare g) {
        super(g);
    }

    public Gare() {
        super();
    }

    @Override
    public int calculLoyer(PlateauDeJeu p) {
        if (this.getProprietaire() == null) {
            return 0;
        } else {
            return 2500 * p.nbGares(this.getProprietaire());
        }
    }

    @Override
    public String toString() {
        if (this.getProprietaire() == null) {
            return this.getNom() + " (coût : " + this.getPrix() + "€) - sans proprietaire";
        } else {
            return this.getNom() + " (coût : " + this.getPrix() + "€) - propriétaire : " + this.getProprietaire().getNom();
        }
    }

}
