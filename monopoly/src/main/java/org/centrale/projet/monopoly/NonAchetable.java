package org.centrale.projet.monopoly;

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
