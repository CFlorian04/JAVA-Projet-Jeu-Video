import CasesClasses.Case;
import Jeu.Grille;
import Jeu.Jeu;
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

	int tailleGrille = new Jeu().getTailleGrille();

	int[][] consoleGrille = new int[tailleGrille][tailleGrille];
	Jeu Jeu;
	public static void main(String[] args) {
        
		// TEST CanGO
		Grille testGrille = new Grille(6, 6);
		char [][] charTestGrille = testGrille.toChar();
		StringBuilder str = new StringBuilder();
		for(char [] l : charTestGrille){
			for(char c : l){
				str.append(c);
				
			}
			str.append('\n');
		}
		System.out.println(str);
		System.out.print(testGrille.canGo(new Case(0, 0), new Case(5, 5)));

		//launch(args);
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
		GridPane layoutGrille = setGrille();
		layoutGrille.setPadding(new Insets(20));
		layoutGrille.setHgap(2);
		layoutGrille.setVgap(2);
		//Affecte la grille dans le jeu
		Jeu = new Jeu(consoleGrille);


		//Ajoute le layout sur la scene
		Scene scene = new Scene(layoutGrille);

		//Applique la scene sur l'interface graphique
		setScene(primaryStage, scene, "Nom du Jeu", tailleGrille*30 + 200,  tailleGrille*30 + 200);


		
		scene.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {

			int playerX = 0;
			int playerY = 0;
			//int endurance = 0 ;
			boolean move = false;
			
			if(event.getCode() == KeyCode.LEFT)
			{	
				if(playerX-1 > 0)
				{
					if(consoleGrille[playerX-1][playerY] != 1)
					{
						consoleGrille[playerX][playerY] = 0;
						consoleGrille[playerX-1][playerY] = 3;
						//endurance = Jeu.changerPosJoueur(playerX-1,playerY);
						Jeu.testChange(playerX-1, playerY);
						move = true;
						System.out.print("Done ->");
					}
				}

				System.out.println("Fleche Gauche");
			}
			else if(event.getCode() == KeyCode.RIGHT)
			{
				if(playerX+1 < tailleGrille)
				{
					if(consoleGrille[playerX+1][playerY] != 1)
					{
						consoleGrille[playerX][playerY] = 0;
						consoleGrille[playerX+1][playerY] = 3;
						//endurance = Jeu.changerPosJoueur(playerX+1,playerY);
						Jeu.testChange(playerX+1,playerY);
						move = true;
						System.out.print("Done ->");
					}
				}
				System.out.println("Fleche Droite");
			}
			else if(event.getCode() == KeyCode.UP)
			{
				if(playerY-1 > 0)
				{
					if(consoleGrille[playerX][playerY-1] != 1)
					{
						consoleGrille[playerX][playerY] = 0;
						consoleGrille[playerX][playerY-1] = 3;
						//endurance = Jeu.changerPosJoueur(playerX,playerY-1);
						Jeu.testChange(playerX+1,playerY);
						move = true;
						System.out.print("Done ->");
					}
				}
				System.out.println("Fleche Haut");
			}
			else if(event.getCode() == KeyCode.DOWN)
			{
				if(playerY+1 < tailleGrille)
				{
					if(consoleGrille[playerX][playerY+1] != 1)
					{
						consoleGrille[playerX][playerY] = 0;
						consoleGrille[playerX][playerY+1] = 3;
						//endurance = Jeu.changerPosJoueur(playerX,playerY+1);
						Jeu.testChange(playerX+1,playerY);
						move = true;
						System.out.print("Done ->");
					}
				}
				System.out.println("Fleche Bas");
			}

			if(move)
			{
				//Mettre à jour la grille
				//Applique la scene sur l'interface graphique
				setScene(primaryStage, updateScene(), "Nom du Jeu", tailleGrille*30 + 200,  tailleGrille*30 + 200);
			}

			/*  Print du tableau en console */
			//System.out.println("Endurance : " + endurance);
			for(int i = 0; i< tailleGrille; i++)
			{
				for(int y = 0; y< tailleGrille; y++)
				{
					if(consoleGrille[i][y] == 3)
					{
						//Applique les coordonnées
						playerX = i;
						playerY = y;
					}
					System.out.print(consoleGrille[y][i]);
				}
				System.out.println();
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
   public GridPane setGrille()
   {

		GridPane root = new GridPane();
		Rectangle[][] Rectgrille = new Rectangle[tailleGrille][tailleGrille];

		
		//Créer un rectangle et y associe un type de case pour chaque cases
		for(int i = 0; i< tailleGrille; i++)
		{
			for(int y = 0; y< tailleGrille; y++)
			{

				Rectgrille[i][y] = createRectangle(50*i, 50*y, 25,25);
				Rectgrille[i][y].setFill(Color.rgb(100, 255,100));
				root.add(Rectgrille[i][y],i,y);
				
				//Probabilité de changer une case vide par un obstacle/bonus
				int rand = (int) (Math.random()*100);
				if(rand > 70) //30% -> Obstacle
				{
					Rectgrille[i][y].setFill(Color.rgb(194, 194,194));
					consoleGrille[i][y] = 1;
				}
				else if(rand < 2) //2% -> Bonus
				{
					Rectgrille[i][y].setFill(Color.rgb(243, 243,43));
					consoleGrille[i][y] = 2;
				}
			}
		}

		//Applique le personnage ('0') et la maison ('M') pour la console
		Rectgrille[0][0].setFill(Color.rgb(25, 55,220));
		consoleGrille[0][0] = 3;
		Rectgrille[tailleGrille-1][tailleGrille-1].setFill(Color.rgb(220, 55,25));
		consoleGrille[tailleGrille-1][tailleGrille-1] = 4;

		//Renvoi le layout de la grille
		return root;
   }


   /*public GridPane setUpdateGrille() {

		GridPane root = new GridPane();
		Rectangle[][] Rectgrille = new Rectangle[tailleGrille][tailleGrille];

		for(int i = 0; i< tailleGrille; i++)
		{
			for(int y = 0; y< tailleGrille; y++)
			{
				if(consoleGrille[i][y] == 0)
				{
					Rectgrille[i][y] = createRectangle(50*i, 50*y, 25,25);
					Rectgrille[i][y].setFill(Color.rgb(100, 255,100));
					root.add(Rectgrille[i][y],i,y);
				}
				else if(consoleGrille[i][y] == 1)
				{
					Rectgrille[i][y].setFill(Color.rgb(194, 194,194));
					consoleGrille[i][y] = 1;
				}
				else if(consoleGrille[i][y] == 2)
				{
					Rectgrille[i][y].setFill(Color.rgb(243, 243,43));
					consoleGrille[i][y] = 2;
				}
				else if(consoleGrille[i][y] == 3)
				{
					Rectgrille[i][y].setFill(Color.rgb(25, 55,220));
					consoleGrille[i][y] = 3;
				}
				else if(consoleGrille[i][y] == 4)
				{
					Rectgrille[tailleGrille-1][tailleGrille-1].setFill(Color.rgb(220, 55,25));
					consoleGrille[tailleGrille-1][tailleGrille-1] = 4;
				}
			}
		}
		return root;
   }
*/

   public Scene updateScene()
   {
		//Ajoute la grille graphique sur le layout
		GridPane layoutGrille = setGrille();
		layoutGrille.setPadding(new Insets(20));
		layoutGrille.setHgap(2);
		layoutGrille.setVgap(2);

		//Ajoute le layout sur la scene
		Scene scene = new Scene(layoutGrille);

		return scene;
		
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
