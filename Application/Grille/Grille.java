package Grille;

import java.util.ArrayList;

import Case.Bonus;
import Case.Case;
import Case.Obstacle;

public class Grille {
    final int DROITE = 0;
    final int BAS = 1;
    final int GAUCHE = 2;
    final int HAUT = 3;
    int hauteur;
    int largeur;

    int depCaseX = 0;//case de départ toujours 0 0, case d'arrivée toujours en bas à droite
    int depCaseY = 0;

    Case[][] Casegrille;

    public Grille(int tailleGrille){
        hauteur = tailleGrille;
        largeur = tailleGrille;
        Casegrille = new Case[tailleGrille][tailleGrille];
        initialiseCasegrille();
    }

    public Grille(int largeur, int hauteur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        Casegrille = new Case[largeur][hauteur];// peut être inversé, à tester
        initialiseCasegrille();
    }

    private void initialiseCasegrille() {
        for(int x = 0; x< largeur; x++)
        {
            for(int y = 0; y< hauteur; y++)
            {
                Casegrille[x][y] = new Case(x,y);
                
            }
        }

        int randX;
        int randY;
        boolean change;
        do{
            randX = (int) Math.floor(Math.random()*(largeur));
            randY = (int) Math.floor(Math.random()*(hauteur));

            change = false;
            
            if(!(randX == 0 && randY == 0 || randX == largeur-1 && randY == hauteur-1)){
                change = true;
                int randCase = (int) Math.floor(Math.random()*100);
                if(randCase>10)Casegrille[randX][randY].setCategorie(new Obstacle(0,-10,""));
                else Casegrille[randX][randY].setCategorie(new Bonus(0,10,""));
            }

            // Casegrille[0][0].setCategorie(null);
            // Casegrille[largeur-1][hauteur-1].setCategorie(null);

            //System.out.println("x = " + randX + "; y = " + randY);
        }while(!change || canGo(Casegrille[0][0], Casegrille[largeur-1][hauteur-1], new ArrayList<Case>()));
        Casegrille[randX][randY].setCategorie(null);
   }

   /**
    * Test si un chemin est possible vers l'arrivée
    * @param current case courante
    * @param arrivé case objectif
    * @param Grille grille du jeu
    * @return vrai si chemin possible
    */
    public boolean canGo(Case current, Case arrivé, ArrayList<Case> historique) {
        Case[] voisins;

        historique.add(current);

        if(current.getCategorie() instanceof Obstacle){//si la case courente est un obstacle, retourner faux
            return false;
        }else if(current.compareTo(arrivé) == 0){//sinon si la case est l'arrivée retourner vrai
            return true;
        }else {
            voisins = getVoisins(current);//obtention des voisins de la case
            
            for (Case nextCase : voisins){
                if(nextCase != null && !historique.contains(nextCase)){
                    if(canGo(nextCase, arrivé, historique))return true;
                    
                }
            }
        }
        return false;
   }

   /**
    * Obtient la liste des 4 cases adjacentes
    * @param c Case centrale
    * @return Tableau de Cases
    */
   public Case[] getVoisins (Case c) {
    Case[] voisins = new Case[4];
    int x = c.getPosX();
    int y = c.getPosY();

    voisins [DROITE] = this.getCase(x +1, y);
    voisins [GAUCHE] = this.getCase(x -1, y);
    voisins [HAUT] = this.getCase(x, y -1);
    voisins [BAS] = this.getCase(x, y +1);

    return voisins;
    }

    /**
     * Donne la taille de la map
     * @return taille de la map (longueur * largeur)
     */
    public int getTailleGrille()
    {
        return this.hauteur*this.largeur;
    }

    /**
     * Retourne la case demandé
     * @param x coordonné x de la case
     * @param y coordonné y de la case
     * @return objet de type Case()
     */
    public Case getCase(int x, int y)
    {	
         if(x >= 0 && y >= 0 && x < Casegrille.length && y < Casegrille[x].length) 	{return Casegrille[x][y];}
 
         return null;
    }

    public void setCase(Case newCase)
    {	
         Casegrille[newCase.getPosX()][newCase.getPosY()] = newCase;
    }


    public char[][] toChar() {
        char [][] charTab =  new char[this.largeur][this.hauteur];
        for(int x = 0; x < this.largeur; x++){
            for(int y = 0; y < this.hauteur; y++){
                charTab[x][y] = this.Casegrille[x][y].toChar();
            }
        }
        return charTab;
    }

    // /**
    //  * Retourne faux si déjà enregistré
    //  * @param current case à tester
    //  * @return vrai si absente d'historique
    //  */
    // private boolean checkHistorique(Case current) {
    //     for(Case h : historique){
    //         if (h.compareTo(current) == 0)return false;
    //     }
    //     return true;
    // }
    // public void addHistorique(Case current) {
    //     historique.add(current);
    // }
    // public void resetHistorique(){
    //     historique.removeAll(historique);
    // }

}