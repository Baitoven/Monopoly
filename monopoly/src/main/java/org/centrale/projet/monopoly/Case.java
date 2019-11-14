package org.centrale.projet.monopoly;

/**
 *
 * @author louis-alexandre
 */
public abstract class Case {

    private String nom;

    public Case(String nom) {
        this.nom = nom;
    }

    public Case(Case c) {
        this.nom = c.nom;
    }

    public Case() {
        this.nom = "Départ";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public abstract String toString();

    public boolean equals(Case c) {
        return this.getNom() == c.getNom();
    }

}
