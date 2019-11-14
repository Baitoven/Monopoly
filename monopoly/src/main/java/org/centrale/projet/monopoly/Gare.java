package org.centrale.projet.monopoly;

/**
 *
 * @author louis-alexandre
 */
public class Gare extends Achetable {

    public Gare(String nom, int prix) {
        super(nom, prix);
    }

    public Gare(Gare g) {
        super(g.getNom(), g.getPrix(), g.getProprietaire());
    }

    public Gare() {
        super();
    }

    @Override
    public int calculLoyer() {
        if (this.getProprietaire() == null) {
            return 0;
        } else {
            return 2500 * this.getProprietaire().nbGares();
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