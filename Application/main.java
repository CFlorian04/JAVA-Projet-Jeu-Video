
import CasesClasses.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.*;
import javafx.stage.Stage;


public class main extends Application {

	int tailleGrille = 5;
	Case[][] Casegrille = new Case[10][10];

	public static void main(String[] args) {
        launch(args);
    }

   @Override
   public void start(Stage primaryStage) throws Exception {

		Button btn = new Button();
		btn.setText("Test");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event)
			{
				System.out.println("Hello World");
			}
		});

		StackPane root = setGrille(tailleGrille);
		Scene scene = new Scene(root);

		setScene(primaryStage, scene, "Nom du Jeu", 700, 700);

	   	/* 
	   	primaryStage.setTitle("Nom du Jeu");
		primaryStage.setScene(scene);
		primaryStage.setHeight(700);
		primaryStage.setWidth(700);
		primaryStage.show();
		*/
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

		Obstacle rocher = new Obstacle(0);

		Casegrille[0][0].setCategorie(rocher);
		System.out.println(Casegrille[0][0]);

		for(int i = 0; i< taille; i++)
		{
			for(int y = 0; y< taille; y++)
			{
				System.out.println("i : " + i + " / y : " + y);

				Rectgrille[i][y] = createRectangle(50*i, 50*y, 50, 50);
				addShapeInLayout(Rectgrille[i][y],root);

				Casegrille[i][y].setPosX(i);
				Casegrille[i][y].setPosY(y);
				Casegrille[i][y].setCategorie(rocher);
			}
		}

		return root;
   }

   public void addShapeInLayout(Shape shape, StackPane stackPane)
   {
		stackPane.getChildren().add(shape);
   }

   public Rectangle createRectangle(int posX, int posY, int hauteur, int largeur)
   {
		Rectangle rect = new Rectangle();
		rect.setX(posX);
		rect.setY(posY);
		rect.setWidth(largeur);
		rect.setHeight(hauteur);
		//rect.setFill(Color.GREEN);
		//rect.setStroke(Color.BLACK);
		return rect;
   }

}





