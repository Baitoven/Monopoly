/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.centralenantes.projetmedevei2;


/**
 *
 * @author louis-alexandre
 */
public abstract class Case {
    private String nom;

    public Case(String nom) {
        this.nom = nom;
    }
    
    public Case(Case c){
        this.nom = c.nom;
    }
    
    public Case(){
        this.nom = "Départ";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public abstract String toString();
    
    public boolean equals(Case c){
        return this.getNom()==c.getNom();
    }
    
}
