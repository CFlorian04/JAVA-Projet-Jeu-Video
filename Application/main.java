import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import Jeu.Jeu;


public class main extends Application {

  String[][] grilleMain = new String[][]

	public static void main(String[] args) {
		launch(args);
    }

   public void start(Stage primaryStage) throws Exception {

    Jeu jeu = new Jeu()
    grilleMain = jeu.getGrilletoString();

    GridPane layoutGrille = setGrille();
		layoutGrille.setPadding(new Insets(20));
		layoutGrille.setHgap(2);
		layoutGrille.setVgap(2);
    Scene scene = new Scene(layoutGrille);


    
    setScene(primaryStage, scene, "", jeu.getTailleGrille()*30 + 200,  jeu.getTailleGrille()*30 + 200);


   }


   public GridPane setGrille()
   {

      GridPane root = new GridPane();
      Rectangle[][] Rectgrille = new Rectangle[jeu.getTailleGrille()][jeu.getTailleGrille()];

      
      //Créer un rectangle et y associe un type de case pour chaque cases
      for(int i = 0; i< jeu.getTailleGrille(); i++)
      {
        Rectgrille[i][y] = createRectangle(50*i, 50*y, 25,25);
        for(int y = 0; y< jeu.getTailleGrille(); y++)
        {

        switch (grilleMain[i][y])
        {
          case ' ' : //Case Vide  
                      Rectgrille[i][y].setFill(Color.rgb(100, 255,100));
                      break;

          case 'X' : //Case Obstacle  
                      Rectgrille[i][y].setFill(Color.rgb(100, 255,100));
                      break;

          case 'O' : //Case Bonus
                      Rectgrille[i][y].setFill(Color.rgb(100, 255,100));
                      break;

          case 'A' : //Case Joueur 
                      Rectgrille[i][y].setFill(Color.rgb(100, 255,100));
                      break;

          case 'M' : //Case Maison
                      Rectgrille[i][y].setFill(Color.rgb(100, 255,100));
                      break;
        }          
          
        root.add(Rectgrille[i][y],i,y);
         
        }
      }

      //Renvoi le layout de la grille
      return root;
    }

}
