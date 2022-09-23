import CasesClasses.*;
import Joueur.Joueur;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;



public class main extends Application {

	int tailleGrille = 10;
	Case[][] Casegrille = new Case[tailleGrille][tailleGrille]; 

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

		Joueur player = new Joueur(15, Casegrille[0][0]);

		

		//Ajoute la grille graphique sur le layout
		GridPane layoutGrille = setGrille(tailleGrille);
		layoutGrille.setPadding(new Insets(20));
		layoutGrille.setHgap(2);
		layoutGrille.setVgap(2);

		//Ajoute le layout sur la scene
		Scene scene = new Scene(layoutGrille);

		//Applique la scene sur l'interface graphique
		setScene(primaryStage, scene, "Nom du Jeu", tailleGrille*30 + 200,  tailleGrille*30 + 200);

		scene.addEventFilter(javafx.scene.input.KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
			int posX = 0/*player.getCaseOccupe().getPosX()*/;
			int posY = 0/*player.getCaseOccupe().getPosY()*/;
			if(event.getCode() == KeyCode.LEFT)
			{
				System.out.println("Fleche Gauche");
				System.out.println(Casegrille[posX-1][posY].getCategorie());
				player.Deplacer(posX-1,posY);
			}
			else if(event.getCode() == KeyCode.RIGHT)
			{
				System.out.println("Fleche Droite");
				player.Deplacer(posX+1,posY);
			}
			else if(event.getCode() == KeyCode.UP)
			{
				System.out.println("Fleche Haut");
				player.Deplacer(posX,posY-1);
			}
			else if(event.getCode() == KeyCode.DOWN)
			{
				System.out.println("Fleche Bas");
				player.Deplacer(posX,posY+1);
			}
		});

   }

   //Fonction qui applique la scene sur l'interface graphique
   public void setScene(Stage Stage ,Scene scene, String title, int hauteur, int largeur)
   {
		Stage.setTitle(title);
		Stage.setScene(scene);
		Stage.setHeight(hauteur);
		Stage.setWidth(largeur);
		Stage.setMaxHeight(hauteur);
		Stage.setMaxWidth(largeur);
		Stage.setMinHeight(hauteur);
		Stage.setMinWidth(largeur);
		Stage.show();
   }

   //Fonction qui créer la grille (console, case et graphique)
   public GridPane setGrille(int taille)
   {
		initialiseCasegrille();

		GridPane root = new GridPane();
		Rectangle[][] Rectgrille = new Rectangle[taille][taille];

		Obstacle obstacle = new Obstacle(0);
		Bonus bonus = new Bonus(0);
		
		//Créer un rectangle et y associe un type de case pour chaque cases
		for(int i = 0; i< taille; i++)
		{
			for(int y = 0; y< taille; y++)
			{

				Rectgrille[i][y] = createRectangle(50*i, 50*y, 25,25);
				Rectgrille[i][y].setFill(Color.rgb(100, 255,100));
				root.add(Rectgrille[i][y],i,y);


				//Probabilité de changer une case vide par un obstacle/bonus
				int rand = (int) (Math.random()*100);
				if(rand > 70) //30% -> Obstacle
				{
					Rectgrille[i][y].setFill(Color.rgb(194, 194,194));
					Casegrille[i][y].setCategorie(obstacle);
				}
				else if(rand < 2) //2% -> Bonus
				{
					Rectgrille[i][y].setFill(Color.rgb(243, 243,43));
					Casegrille[i][y].setCategorie(bonus);
				}
			}
		}

		//Applique le personnage ('0') et la maison ('M') pour la console
		Rectgrille[0][0].setFill(Color.rgb(25, 55,220));
		Rectgrille[tailleGrille-1][tailleGrille-1].setFill(Color.rgb(220, 55,25));

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
			}
		}
   }
}
