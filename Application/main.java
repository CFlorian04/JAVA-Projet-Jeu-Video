
import CasesClasses.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class main extends Application implements KeyListener{

	int tailleGrille = 10;
	//Case[][] Casegrille = new Case[tailleGrille][tailleGrille]; 
	char[][] consoleGrille = new char[tailleGrille][tailleGrille]; //Test avec la console

	
	public static void main(String[] args) {
        launch(args);
    }

   @Override
   public void start(Stage primaryStage) throws Exception {

		//Clear la console
		System.out.print("\033[H\033[2J");

		/*Button btn = new Button();
		btn.setText("Test");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event)
			{
				System.out.println("Hello World");
			}
		});*/

		//Ajoute la grille graphique sur le layout
		GridPane layoutGrille = setGrille(tailleGrille);
		layoutGrille.setPadding(new Insets(20));
		layoutGrille.setHgap(5);
		layoutGrille.setVgap(5);

		//Ajoute le layout sur la scene
		Scene scene = new Scene(layoutGrille);

		//Applique la scene sur l'interface graphique
		setScene(primaryStage, scene, "Nom du Jeu", tailleGrille*30 + 100,  tailleGrille*30 + 100);

   }

   //Fonction qui applique la scene sur l'interface graphique
   public void setScene(Stage Stage ,Scene scene, String title, int hauteur, int largeur)
   {
		Stage.setTitle(title);
		Stage.setScene(scene);
		Stage.setHeight(hauteur);
		Stage.setWidth(largeur);
		Stage.show();
   }

   //Fonction qui créer la grille (console, case et graphique)
   public GridPane setGrille(int taille)
   {
		GridPane root = new GridPane();
		Rectangle[][] Rectgrille = new Rectangle[taille][taille];

		//Obstacle obstacle = new Obstacle(0);
		//Bonus bonus = new Bonus(0);
		


		//Créer un rectangle et y associe un type de case pour chaque cases
		for(int i = 0; i< taille; i++)
		{
			for(int y = 0; y< taille; y++)
			{

				Rectgrille[i][y] = createRectangle(50*i, 50*y, 25,25);
				Rectgrille[i][y].setFill(Color.rgb(100, 255,100));
				root.add(Rectgrille[i][y],i,y);
				consoleGrille[i][y] = ' ';
				/*
				Casegrille[i][y].setPosX(i);
				Casegrille[i][y].setPosY(y);
				Casegrille[i][y].setCategorie(rocher);
				*/

				//Probabilité de changer une case vide par un obstacle/bonus
				int rand = (int) (Math.random()*100);
				if(rand > 70) //30% -> Obstacle
				{
					Rectgrille[i][y].setFill(Color.rgb(194, 194,194));
					//Casegrille[i][y].setCategorie(obstacle);
					consoleGrille[i][y] = 'X';
				}
				else if(rand < 2) //2% -> Bonus
				{
					Rectgrille[i][y].setFill(Color.rgb(243, 243,43));
					//Casegrille[i][y].setCategorie(bonus);
					consoleGrille[i][y] = 'B';
				}
			}
		}
		//Applique le personnage ('0') et la maison ('M') pour la console
		Rectgrille[0][0].setFill(Color.rgb(25, 55,220));
		consoleGrille[0][0] = 'O';
		Rectgrille[tailleGrille-1][tailleGrille-1].setFill(Color.rgb(220, 55,25));
		consoleGrille[tailleGrille-1][tailleGrille-1] = 'M';

		

		//Afficher la grille dans la console
		for(int i = 0; i< taille; i++)
		{
			for(int y = 0; y< taille; y++)
			{
				System.out.print(consoleGrille[i][y]);
			}
			System.out.println();
		}

		//Renvoi le layout de la grille
		return root;
   }

   //Fonction qui créer un rectangle et qui le renvoi
   public Rectangle createRectangle(int posX, int posY, int hauteur, int largeur)
   {
		Rectangle rect = new Rectangle(posX,posY,largeur,hauteur);
		//rect.setFill(Color.GREEN);
		//rect.setStroke(Color.BLACK);
		return rect;
   }
   

   /**
	* Utilisation des touches
	* @param e
    */
   public void keyPressed(KeyEvent e) {

		tableau[x][y] = 0;

		if (e.getKeyCode() == KeyEvent.VK_RIGHT )
		{
			//Right arrow key code
			System.out.println("Fleche Droite");
			if(y < taille-1)
			{
				y++;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT )
		{
			//Left arrow key code
			System.out.println("Fleche Gauche");
			if(y > 0)
			{
				y--;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN )
		{
			//Up arrow key code
			System.out.println("Fleche Bas");
			if(x < taille-1)
			{
				x++;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			//Down arrow key code
			System.out.println("Fleche Haut");
			if(x > 0)
			{
				x--;
			}
		}

		tableau[x][y] = 1;

		for(int i = 0; i < taille; i++)
		{
			for(int y = 0; y < taille; y++)
			{
				System.out.print(tableau[i][y]);
			}
			System.out.println();
		}
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}





