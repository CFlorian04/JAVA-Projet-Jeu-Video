
import CasesClasses.*;
import MKeyListener.MKeyListener;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.*;
import javafx.stage.Stage;


public class main extends Application {

	int tailleGrille = 20;
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
		StackPane root = setGrille(tailleGrille);
		//Ajoute le layout sur la scene
		Scene scene = new Scene(root);

		//Applique la scene sur l'interface graphique
		setScene(primaryStage, scene, "Nom du Jeu", 700, 700);

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
   public StackPane setGrille(int taille)
   {
		StackPane root = new StackPane();
		Rectangle[][] Rectgrille = new Rectangle[taille][taille];

		//Obstacle rocher = new Obstacle(0);
		//Casegrille[0][0].setCategorie(rocher);


		//Créer un rectangle et y associe un type de case pour chaque cases
		for(int i = 0; i< taille; i++)
		{
			for(int y = 0; y< taille; y++)
			{

				Rectgrille[i][y] = createRectangle(50*i, 50*y, 50, 50);
				addShapeInLayout(Rectgrille[i][y],root);
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
					consoleGrille[i][y] = 'X';
				}
				else if(rand < 2) //2% -> Bonus
				{
					consoleGrille[i][y] = 'B';
				}
			}
		}
		//Applique le personnage ('0') et la maison ('M') pour la console
		consoleGrille[0][0] = 'O';
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

   //Fonction qui ajoute une figure dans un layout
   public void addShapeInLayout(Shape shape, StackPane stackPane)
   {
		stackPane.getChildren().add(shape);
   }

   //Fonction qui créer un rectangle et qui le renvoi
   public Rectangle createRectangle(int posX, int posY, int hauteur, int largeur)
   {
		Rectangle rect = new Rectangle(posX,posY,largeur,hauteur);
		//rect.setFill(Color.GREEN);
		//rect.setStroke(Color.BLACK);
		return rect;
   }
   

}





