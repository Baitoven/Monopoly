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
public class Depart extends NonAchetable{
    
    public void action(Joueur){
        Joueur.setArgent(Joueur.getArgent()+20000);
    }
    
}
