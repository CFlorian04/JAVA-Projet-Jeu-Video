package Jeu;

import CasesClasses.*;
import Joueur.Joueur;

public class Jeu {

    final int DROITE = 0;
    final int BAS = 1;
    final int GAUCHE = 2;
    final int HAUT = 3;

    int tailleGrille = 0;
    
    Joueur player;
    int[][] consoleGrille;
    Case[][] Casegrille = new Case[tailleGrille][tailleGrille]; 

    Obstacle obstacle = new Obstacle(0);
	Bonus bonus = new Bonus(0);

    public Jeu() {
        initialiseCasegrille();
        player = new Joueur(15, Casegrille[0][0]);
    }

    public Jeu(int[][] consoleGrille) {

        this.consoleGrille = consoleGrille;
        initialiseCasegrille();
        player = new Joueur(15, Casegrille[0][0]);


    }

    public int getTailleGrille()
    {
        return tailleGrille;
    }

    public Case getCase(int x, int y)
    {	
         if(x < Casegrille.length && y < Casegrille[x].length) 	{return Casegrille[x][y];}
 
         return null;
    }
    
   public void initialiseCasegrille()
   {
		for(int i = 0; i< tailleGrille; i++)
		{
			for(int y = 0; y< tailleGrille; y++)
			{
				Casegrille[i][y] = new Case(i,y);


                //'0' -> Vide / '1' -> Obstacle / '2' -> Bonus / '3' -> Joueur / '4' -> Maison
                switch(consoleGrille[i][y])
                {
                    case 0 :    break;
                    case 1 :    Casegrille[i][y].setCategorie(obstacle);
                                break;
                    case 2 :    Casegrille[i][y].setCategorie(bonus);
                                break;
                    case 3 :    break;
                    case 4 :    break;
                    default :   break;
                }
			}
		}
   }

   public void setUpdateGrille(int[][] consoleGrille)
   {
        this.consoleGrille = consoleGrille;
   }


   /**
    * Test si un chemin est possible vers l'arrivée
    * @param current case courante
    * @param arrivé case objectif
    * @param Grille grille du jeu
    * @return vrai si chemin possible
    */
   public boolean canGo(Case current, Case arrivé, int[][] Grille) {
        Case[] voisins;

        if(current.getCategorie() instanceof Obstacle){//si la case est un obstacle, retourner faux
            return false;
        }else if(current.voisin(arrivé)){//sinon si la case est à côté de l'arrivé retourner vrai
            return true;
        }else {
            voisins = getVoisins(current);//obtention des voisins de la case

            if((current = voisins[DROITE]) != null){//si case à droite éxiste

                if (canGo(current, arrivé, Grille)) return true; // retourner vrai si chemin trouvé
                
            }if((current = voisins[GAUCHE]) != null){

                if (canGo(current, arrivé, Grille)) return true;

            }if((current = voisins[HAUT]) != null){
                
                if (canGo(current, arrivé, Grille)) return true;
                
            }if((current = voisins[BAS]) != null){

                if (canGo(current, arrivé, Grille)) return true;
                
            }
        }
        return false;
   }

   public Case[] getVoisins (Case c) {
        Case[] voisins = new Case[4];
        int x = c.getPosX();
        int y = c.getPosY();

        voisins [DROITE] = this.getCase(x +1, y);
        voisins [GAUCHE] = this.getCase(x -1, y);
        voisins [HAUT] = this.getCase(x, y +1);
        voisins [BAS] = this.getCase(x, y -1);

        return voisins;
    }

   public int changerPosJoueur(int x, int y)
   {
        int endurance = 0;

        if(x != 0)
        {
            endurance = player.Marche(x,y);
        }
            
        return endurance;
   }

   public void testChange(int x, int y)
   {
        if(x != 0)
        {
            player.Deplacer(x,y);
        }   
   }
}
