package Jeu;

import CasesClasses.*;
import Joueur.Joueur;

public class Jeu {

    int tailleGrille = 4;
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

   /*public boolean canGo(Case départ, Case arrivé, int[][] Grille) {
    int x, y;
    if(arrivé.getPosX() == )
    return false;

   }*/

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
