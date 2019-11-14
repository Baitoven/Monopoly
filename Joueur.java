/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.centrale.projet.monopoly;

import java.util.LinkedList;
import java.util.Scanner;
import org.centrale.projet.monopoly.monopoly.master.NoMoreMoney;

/**
 *
 * @author Julien
 */
public class Joueur {
    private Case position;
    private Plateau refPlateau;
    private int fortune;
    private String nom;
    private LinkedList<Case> possession = new LinkedList<>();
    private boolean estEnPrison;
    private int tourEnPrison;
    
    public Joueur(String nom, Plateau refPlateau){
        this.nom = new String(nom);
        fortune = 1000000;
        this.refPlateau = refPlateau;
        estEnPrison = false;
        tourEnPrison = 0;
    }
    
    public Case getPosition(){
        return position;
    }
    
    public void setPosition(Case position){
        this.position = position;
    }
    
     public Plateau getRefPlateau(){
        return refPlateau;
    }
    
    public void setRefPlateau(Plateau refPlateau){
        this.refPlateau = refPlateau;
    }
    
    public int getFortune(){
        return fortune;
    }
    
    public void setFortune(int value){
        fortune = value;
    }
    
    public String getNom(){
        return(nom);
    }
    
    public void setNom(String value){
        nom = new String(value);
    }
    
    public boolean getEstEnPrison(){
        return(estEnPrison);
    }
    
    public void setEstEnPrison(boolean value){
        estEnPrison = value;
    }
    
    public int getTourEnPrison(){
        return(tourEnPrison);
    }
    
    public void setTourEnPrison(int value){
        tourEnPrison = value;
    }
    
    public int nbGare(){
        int compteur = 0;
        for(int i =0; i<possession.size();i++){
            if ((possession.get(i)) instanceof Gare)
                compteur++;
        }
        return(compteur);
    }

    public boolean equals(Joueur j){
        return(j.getNom().equals(this.nom));
    }

    public void gagneArgent(int value){
        fortune = fortune + value;
    }
    
    public void perdArgent(int value){
        fortune = fortune + value;
    }
    
    public void paiement(Joueur j, int paye) throws NoMoreMoney{
        if (this.fortune >= paye){
            j.gagneArgent(paye);
            this.perdArgent(paye);
        }
        else {
            throw new NoMoreMoney("Plus d'argent");
        }
    }
    
    public void acheter(Achetable c) throws NoMoreMoney{
        if (this.fortune >= c.getPrix()){
           this.perdArgent(c.getPrix());
	c.setProprietaire(nom);
        possession.add((Case)c);
        }
        else {
            throw new NoMoreMoney("Plus d'argent pour ça");
        }
    }
    
    public void vendre(Achetable c){
        this.gagneArgent(c.getPrix());
        possession.remove(c);
    }
    
    public static int lanceLeDe() {
        return ((int) Math.floor(Math.random()*6))+1;
    }
    
    public int reponseEntiere(int max){
        Scanner rep = new Scanner(System.in);
        try{
            int repInt = Integer.parseInt(rep.nextLine());
            if (repInt>max && repInt<0){
                System.out.println("Ce que tu as écrit n'est pas correct !");
                System.out.println("Recommence.");
                return(reponseEntiere(max));
            }
            else{
                return(repInt);
            }
        }
        catch(Exception e){
            System.out.println("Ce que tu as écrit n'est pas correct !");
            System.out.println("Recommence.");
            return(reponseEntiere(max));
        }
    }
    public boolean reponseOuiNon(){
        Scanner repScan = new Scanner(System.in);
        String repString = new String(repScan.nextLine());
        if(repString.equals("Oui")){
            return(true);
        }
        if(repString.equals("Non")){
            return(false);
        }
        else{
            System.out.println("Ce que tu as écrit n'est pas correct !");
            System.out.println("Recommence en répondant par Oui ou par Non.");
            return(reponseOuiNon());
        }
    }
    
    public void tourDeJeu(int numeroDuTour){
        int de = lanceLeDe();
        if(!estEnPrison){
            this.position = refPlateau.avance(de,position);
            System.out.println("Le Joueur "+ nom+" est en "+position.getNom()+".");
            if(position instanceof Achetable){
                if((position.getProprietaire()==null)&& de%2==1){
                    achete(position);
                }
                if(position.getProprietaire()!=null && !position.getProprietaire().getNom().equals(nom)){
                    paiement(position.getProprietaire(),position.calculLoyer());           
                }
                else if(position.getProprietaire()!=null){
                    System.out.println("Souhaites-tu construire des maisons ou un hôtel sur ton bien ?");
                    System.out.println("Il y a actuellement "
                            +position.getNbMaison()+" maison(s) et "
                            +position.getNbHotel()+ "hôtel.");
                    Scanner scanJoueur = new Scanner(System.in);
                    if(position.getNbHotel()==0){
                        System.out.println("Souhaites-tu construire un hôtel ? (Oui/Non");
                        boolean repBool = reponseOuiNon();
                        if(repBool){
                            if(position.getPrixMaison()*position.getNbMaison() + fortune - position.getPrixHotel() <0){
                                System.out.println("Désolé, tu n'es pas assez riche pour ça.");
                            }
                            else{
                                gagneArgent(position.getPrixMaison()*position.getNbMaison());
                                position.setNbMaison(0);
                                perdArgent(position.getPrixHotel());
                                position.setNbHotel(1);
                            }
                        }
                    }
                    if(position.getNbHotel()==0 && position.getNbMaison()< 4){
                        System.out.println("Combien de maison souhaites-tu construire ?");
                        int constructible = 4-position.getNbMaison();
                        System.out.println("tu peux en construire : " + constructible+".");
                        int repInt = reponseEntiere(constructible);
                        if(fortune - position.getPrixMaison()*repInt <0){
                            System.out.println("Désolé, tu n'es pas assez riche pour ça.");
                        }
                        else{                        
                            perdArgent(position.getPrixMaison()*repInt);
                            position.setNbMaison(position.getNbMaison()+repInt);
                        }
                        
                    }
                }
            }
            else if(position instanceof Prison){
                tourEnPrison = numeroDuTour;
            }
            else if(position instanceof NonAchetable){
                position.action(this);
            }
            
            
        }
        else{
            if(numeroDuTour - tourEnPrison == 3){
                estEnPrison = false;
            }
        }
    }
}

