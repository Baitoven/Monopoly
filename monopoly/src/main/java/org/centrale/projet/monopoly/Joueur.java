package org.centrale.projet.monopoly;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;
import org.centrale.projet.monopoly.NoMoreMoney;


public class Joueur {

    private Case position;
    private PlateauDeJeu refPlateau;
    private int argent;
    private String nom;
    private ArrayList<Case> possession = new ArrayList<>();
    private boolean estEnPrison;
    private int tourEnPrison;

    public Joueur(String nom, PlateauDeJeu refPlateau) {
        this.nom = new String(nom);
        argent = 1000000;
        this.refPlateau = refPlateau;
        estEnPrison = false;
        tourEnPrison = 0;
    }

    public Case getPosition() {
        return position;
    }

    public void setPosition(Case position) {
        this.position = position;
    }

    public PlateauDeJeu getRefPlateau() {
        return refPlateau;
    }

    public void setRefPlateau(PlateauDeJeu refPlateau) {
        this.refPlateau = refPlateau;
    }

    public int getArgent() {
        return argent;
    }

    public void setArgent(int value) {
        argent = value;
    }

    public String getNom() {
        return (nom);
    }

    public void setNom(String value) {
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

    public int nbGare() {
        int compteur = 0;
        for (int i = 0; i < possession.size(); i++) {
            if ((possession.get(i)) instanceof Gare) {
                compteur++;
            }
        }
        return (compteur);
    }

    public boolean equals(Joueur j){
        return(j.getNom().equals(this.nom));
    }
    
    public void gagneArgent(int value) {
        argent = argent + value;
    }

    public void perdArgent(int value) {
        argent = argent + value;
    }

    public void paiement(Joueur j, int paye) throws NoMoreMoney {
        if (this.argent >= paye) {
            j.gagneArgent(paye);
            this.perdArgent(paye);
        } else {
            throw new NoMoreMoney("Plus d'argent");
        }
    }

    public void acheter(Achetable c) throws NoMoreMoney {
        if (this.argent >= c.getPrix()) {
            this.perdArgent(c.getPrix());
            c.setProprietaire(this);
            possession.add((Case) c);
        } else {
            throw new NoMoreMoney("Plus d'argent pour ça");
        }
    }

    public void vendre(Achetable c) {
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
    
    public void tourDeJeu(int numeroDuTour) throws NoMoreMoney{
        int de = lanceLeDe();
        if(!estEnPrison){
            this.position = refPlateau.avance(de,this);
            System.out.println("Le Joueur "+ nom+" est en "+position.getNom()+".");
            if(position instanceof Achetable){
                if((((Achetable)position).getProprietaire()==null)&& de%2==1){
                    acheter((Achetable)position);
                }
                if(((Achetable)position).getProprietaire()!=null && !((Achetable)position).getProprietaire().getNom().equals(nom)){
                    paiement(((Achetable)position).getProprietaire(),((Achetable)position).calculLoyer(refPlateau));           
                }
                else if(((Achetable)position).getProprietaire()!=null && position instanceof Constructible){
                    System.out.println("Souhaites-tu construire des maisons ou un hôtel sur ton bien ?");
                    System.out.println("Il y a actuellement "
                            +((Constructible)position).getNbMaisons()+" maison(s) et "
                            +((Constructible)position).getNbHotels()+ "hôtel.");
                    
                    Scanner scanJoueur = new Scanner(System.in);
                    if(((Constructible)position).getNbHotels()==0){
                        System.out.println("Souhaites-tu construire un hôtel ? (Oui/Non");
                        boolean repBool = reponseOuiNon();
                        if(repBool){
                            if(((Constructible)position).getPrixMaison()*((Constructible)position).getNbMaisons() + argent - ((Constructible)position).getPrixHotel() <0){
                                System.out.println("Désolé, tu n'es pas assez riche pour ça.");
                            }
                            else{
                                gagneArgent(((Constructible)position).getPrixMaison()*((Constructible)position).getNbMaisons());
                                ((Constructible)position).setNbMaisons(0);
                                perdArgent(((Constructible)position).getPrixHotel());
                                ((Constructible)position).setNbHotels(1);
                            }
                        }
                    }
                    if(((Constructible)position).getNbHotels()==0 && ((Constructible)position).getNbMaisons()< 4){
                        System.out.println("Combien de maison souhaites-tu construire ?");
                        int constructible = 4-((Constructible)position).getNbMaisons();
                        System.out.println("tu peux en construire : " + constructible+".");
                        int repInt = reponseEntiere(constructible);
                        if(argent - ((Constructible)position).getPrixMaison()*repInt <0){
                            System.out.println("Désolé, tu n'es pas assez riche pour ça.");
                        }
                        else{                        
                            perdArgent(((Constructible)position).getPrixMaison()*repInt);
                            ((Constructible)position).setNbMaisons(((Constructible)position).getNbMaisons()+repInt);
                        }
                        
                    }
                }
            }
            else if(position instanceof Prison){
                tourEnPrison = 3;
            }
            else if(position instanceof NonAchetable){
                ((NonAchetable)position).action(this);
            }
            
            
        }
        else{
            tourEnPrison--;
            if(tourEnPrison == 0){
                estEnPrison = false;
            }
        }
    }
}
