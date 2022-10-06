package Jeu;

import java.util.ArrayList;

import CasesClasses.Bonus;
import CasesClasses.Case;
import CasesClasses.Obstacle;

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
    ArrayList<Case> historique = new ArrayList<Case>();

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

        int randX = (int) (Math.random()*largeur-1);
        int randY = (int) (Math.random()*hauteur-1);
        Casegrille[randX][randY].setCategorie(new Obstacle(0));
        if(!canGo(Casegrille[0][0], Casegrille[largeur-1][hauteur-1])){
            Casegrille[randX][randY].setCategorie(null);
        }

/*
        do{
            for(int x = 0; x< largeur; x++)
            {
                for(int y = 0; y< hauteur; y++)
                {
                    Casegrille[x][y] = new Case(x,y);
                    
                }
            }

            int randX = (int) (Math.random()*largeur-1);
            int randY = (int) (Math.random()*hauteur-1);
            Casegrille[randX][randY].setCategorie(new Obstacle(0));

            // for(int x = 0; x< largeur; x++)
            // {
            //     for(int y = 0; y< hauteur; y++)
            //     {
                    
            //         if(!(x == 0 && y == 0 || x == largeur-1 && y == hauteur)){
            //             int rand = (int) (Math.random()*100);

            //             System.out.println("x = " + x + " | y = " + y);
            //             if(rand > 70) //30% -> Obstacle
            //             {
            //                 Casegrille[x][y].setCategorie(new Obstacle(0));
            //                 historique.removeAll(historique);
            //             }
            //             else if(rand < 2) //2% -> Bonus
            //             {
            //                 Casegrille[x][y].setCategorie(new Bonus(0));
            //             }
            //         }
            //     }
            // }
        }while (!canGo(Casegrille[0][0], Casegrille[largeur-1][hauteur-1]));
        */
   }

   /**
    * Test si un chemin est possible vers l'arrivée
    * @param current case courante
    * @param arrivé case objectif
    * @param Grille grille du jeu
    * @return vrai si chemin possible
    */
    public boolean canGo(Case current, Case arrivé) {
        Case[] voisins;
        historique.removeAll(historique);

        if(current.getCategorie() instanceof Obstacle){//si la case courente est un obstacle, retourner faux
            return false;
        }else if(current.getPosX() == largeur-1 && current.getPosY() == hauteur-1){//sinon si la case est à côté de l'arrivé retourner vrai
            return true;
        }else {
            voisins = getVoisins(current);//obtention des voisins de la case

            if((current = voisins[DROITE]) != null && (this.checkHistorique(voisins[DROITE])) || (current = voisins[GAUCHE]) != null && (this.checkHistorique(voisins[GAUCHE]))
            || (current = voisins[HAUT]) != null && (this.checkHistorique(voisins[HAUT])) || (current = voisins[BAS]) != null && (this.checkHistorique(voisins[BAS])))
            {
                this.addHistorique(current);
                if (canGo(current, arrivé)) return true; // tenter un chemin, retourner vrai si chemin trouvé
                
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

    public char[][] toChar() {
        char [][] charTab =  new char[this.largeur][this.hauteur];
        for(int x = 0; x < this.largeur; x++){
            for(int y = 0; y < this.hauteur; y++){
                charTab[x][y] = this.Casegrille[x][y].toChar();
            }
        }
        return charTab;
    }

    private boolean checkHistorique(Case current) {
        for(Case h : historique){
            if (h.compareTo(current) == 0)return false;
        }
        return true;
    }
    public void addHistorique(Case current) {
        historique.add(current);
    }
    public void resetHistorique(){
        historique.removeAll(historique);
    }

}
