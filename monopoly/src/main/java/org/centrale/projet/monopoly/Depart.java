package org.centrale.projet.monopoly;

/**
 *
 * @author louis-alexandre
 */
public class Depart extends NonAchetable {

    public void action(Joueur j) {
        j.setArgent(j.getArgent() + 20000);
    }

}
