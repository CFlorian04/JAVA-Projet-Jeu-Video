package Jeu;

import CasesClasses.*;
import Joueur.Joueur;

public class Jeu {

    int tailleGrille = 0;
    Case[][] Casegrille;
    Joueur player;
    int[][] consoleGrille;

    Obstacle obstacle = new Obstacle(0);
	Bonus bonus = new Bonus(0);

    public Jeu(int tailleGrille, int[][] consoleGrille) {

        this.tailleGrille = tailleGrille;
        this.consoleGrille = consoleGrille;

        Case[][] Casegrille = new Case[tailleGrille][tailleGrille]; 
        Joueur player = new Joueur(15, Casegrille[0][0]);



        //initialiseCasegrille();
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
				Casegrille[i][y] = new Case();
                Casegrille[i][y].setPosX(i);
                Casegrille[i][y].setPosY(y);

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
        System.out.println(player.getEndurance());
        int endurance = 0;

        /*if(x != 0)
        {
            endurance = player.MarcheX(x);
        }
            
        if(y != 0)
        {
            endurance = player.MarcheY(y);
        }*/
        return endurance;
   }
}
