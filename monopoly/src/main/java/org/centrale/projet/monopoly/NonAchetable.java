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
public abstract class NonAchetable extends Case{
    
   @Override
    public String toString(){
        return this.getNom();
    }
    
    public abstract void action(Joueur j);
    
}
