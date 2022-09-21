
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

	int tailleGrille = 10;
	//Case[][] Casegrille = new Case[tailleGrille][tailleGrille]; 
	int[][] chiffreGrille = new int[tailleGrille][tailleGrille]; //Test avec la console

	
	public static void main(String[] args) {
        launch(args);
    }

   @Override
   public void start(Stage primaryStage) throws Exception {

		System.out.print("\033[H\033[2J");

		/*Button btn = new Button();
		btn.setText("Test");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event)
			{
				System.out.println("Hello World");
			}
		});*/

		StackPane root = setGrille(tailleGrille);
		Scene scene = new Scene(root);

		setScene(primaryStage, scene, "Nom du Jeu", 700, 700);

   }

   public void setScene(Stage Stage ,Scene scene, String title, int hauteur, int largeur)
   {
		Stage.setTitle(title);
		Stage.setScene(scene);
		Stage.setHeight(hauteur);
		Stage.setWidth(largeur);
		Stage.show();
   }

   public StackPane setGrille(int taille)
   {
		StackPane root = new StackPane();
		Rectangle[][] Rectgrille = new Rectangle[taille][taille];

		//Obstacle rocher = new Obstacle(0);
		//Casegrille[0][0].setCategorie(rocher);

		//System.out.println(Casegrille[0][0]);

		for(int i = 0; i< taille; i++)
		{
			for(int y = 0; y< taille; y++)
			{

				Rectgrille[i][y] = createRectangle(50*i, 50*y, 50, 50);
				addShapeInLayout(Rectgrille[i][y],root);
				chiffreGrille[i][y] = 0;
				/*
				Casegrille[i][y].setPosX(i);
				Casegrille[i][y].setPosY(y);
				Casegrille[i][y].setCategorie(rocher);
				*/

				int rand = (int) (Math.random()*100);
			
				if(rand > 70) //30% -> Obstacle
				{
					chiffreGrille[i][y] = 1;
				}
				else if(rand < 2) //2% -> Bonus
				{
					chiffreGrille[i][y] = 2;
				}
			}
			chiffreGrille[0][0] = 5;
			chiffreGrille[tailleGrille-1][tailleGrille-1] = 9;
		}

		

		//Afficher la grille dans la console
		for(int i = 0; i< taille; i++)
		{
			for(int y = 0; y< taille; y++)
			{
				System.out.print(chiffreGrille[i][y]);
			}
			System.out.println();
		}

		return root;
   }

   public void addShapeInLayout(Shape shape, StackPane stackPane)
   {
		stackPane.getChildren().add(shape);
   }

   public Rectangle createRectangle(int posX, int posY, int hauteur, int largeur)
   {
		Rectangle rect = new Rectangle(posX,posY,largeur,hauteur);
		//rect.setFill(Color.GREEN);
		//rect.setStroke(Color.BLACK);
		return rect;
   }
   

}





