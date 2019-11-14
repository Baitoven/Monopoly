/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.monopoly;

/**
 *
 * @author PM
 */
public class Prison extends NonAchetable{
    
    public Prison(){
        
    }
    
    public void action(Joueur j){
        j.setEstEnPrison(true);
        j.setNumEntreePrison(j.getTourDeJeu);
        
    }
}
