package org.centrale.projet.monopoly;

/**
 *
 * @author louis-alexandre
 */
public abstract class NonAchetable extends Case {

    public NonAchetable(String nom) {
        super(nom);
    }

    public NonAchetable(NonAchetable a) {
        super(a.getNom());
    }

    public NonAchetable() {
        super();
    }

    @Override
    public String toString() {
        return this.getNom();
    }

    public abstract void action(Joueur j);

}
