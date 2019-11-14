package org.centrale.projet.monopoly;

/**
 *
 * @author PM
 */
public class Prison extends NonAchetable{    
    public Prison(){
        super();
    }
    
    public void action(Joueur j){
        j.setEstEnPrison(true);
    }
}
