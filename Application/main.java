import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import Jeu.Jeu;
import KeyEventJeu.KeyEventTest;

public class main extends Application {

  Scene scene;
  Jeu jeu;
  char[][] grilleMain;

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage primaryStage) throws Exception {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("/test.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);

    setScene(primaryStage, scene, "Don't Forget the Road", 800,600);

    /*
     * jeu = new Jeu(scene);
     * grilleMain = jeu.getJeuChar();
     * 
     * GridPane layoutGrille = setGrille();
     * layoutGrille.setPadding(new Insets(20));
     * layoutGrille.setHgap(2);
     * layoutGrille.setVgap(2);
     * scene = new Scene(layoutGrille);
     * 
     * setScene(primaryStage, scene, "Don't Forget the Road",
     * jeu.getTailleGrille()*30 + 200, jeu.getTailleGrille()*30 + 200);
     */

  }

  public void setScene(Stage Stage, Scene scene, String title, int hauteur, int largeur) {
    Stage.setTitle(title);
    Stage.setScene(scene);
    Stage.setHeight(hauteur);
    Stage.setWidth(largeur);
    Stage.setMaxHeight(hauteur);
    Stage.setMaxWidth(largeur);
    Stage.setMinHeight(hauteur);
    Stage.setMinWidth(largeur);
    Stage.show();

    //scene.setOnKeyPressed(new KeyEventTest());
  }

  public GridPane setGrille() {

    GridPane root = new GridPane();
    Rectangle[][] Rectgrille = new Rectangle[jeu.getTailleGrille()][jeu.getTailleGrille()];

    // Créer un rectangle et y associe un type de case pour chaque cases
    for (int x = 0; x < jeu.getTailleGrille(); x++) {

      for (int y = 0; y < jeu.getTailleGrille(); y++) {

        System.out.print(grilleMain[y][x]);
        Rectgrille[x][y] = createRectangle(50 * x, 50 * y, 25, 25);

        switch (grilleMain[x][y]) {

          case 'X': // Case Obstacle
            Rectgrille[x][y].setFill(Color.rgb(255, 100, 100));
            break;

          case 'O': // Case Bonus
            Rectgrille[x][y].setFill(Color.rgb(255, 255, 100));
            break;

          case 'A': // Case Joueur
            Rectgrille[x][y].setFill(Color.rgb(100, 100, 255));
            break;

          case 'M': // Case Maison
            Rectgrille[x][y].setFill(Color.rgb(100, 255, 255));
            break;

          case '_': // Case Vide
            Rectgrille[x][y].setFill(Color.rgb(100, 255, 100));
            break;
        }

        root.add(Rectgrille[x][y], x, y);

      }
      System.out.println(" ");
    }

    // Renvoi le layout de la grille
    return root;
  }

  // Fonction qui créer un rectangle et qui le renvoi
  public Rectangle createRectangle(int posX, int posY, int hauteur, int largeur) {
    Rectangle rect = new Rectangle(posX, posY, largeur, hauteur);
    return rect;
  }

}
