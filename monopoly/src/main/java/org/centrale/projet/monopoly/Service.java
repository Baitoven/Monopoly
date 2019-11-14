package org.centrale.projet.monopoly;

import java.util.Random;

/**
 *
 * @author louis-alexandre
 */
public class Service extends Achetable {

    private int loyer;

    public Service(String nom, int prix) {
        super(nom, prix);
    }

    public Service(Service s) {
        super(s.getNom(), s.getPrix());
        this.loyer = s.loyer;
    }

    public Service() {
        super();
        this.setNom("Électricité");
        this.loyer = 1000;
    }

    public int getLoyer() {
        return loyer;
    }

    public void setLoyer(int loyer) {
        this.loyer = loyer;
    }

    @Override
    public int calculLoyer(PlateauDeJeu p) {
        if (this.getProprietaire() == null) {
            return 0;
        } else {
            Random generateurAleatoire = new Random();
            int x = generateurAleatoire.nextInt(11);
            return this.loyer * (1 + x);
        }
    }

    @Override
    public String toString() {
        if (this.getProprietaire() == null) {
            return this.getNom() + " (coût : " + this.getPrix() + "€) - sans proprietaire";
        } else {
            return this.getNom() + " (coût : " + this.getPrix() + "€) - propriétaire : " + this.getProprietaire().getNom()
                    + ", loyer = " + this.getLoyer();
        }
    }
}
