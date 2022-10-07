import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import Jeu.Jeu;
import KeyEventJeu.KeyEventJeu;

/*
 * https://jenkov.com/tutorials/javafx/index.html
 * https://www.youtube.com/watch?v=gJYXctDSIl8
 * https://riptutorial.com/javafx/example/19375/basic-javafx-project-using-fxml
 * https://github.com/callicoder/javafx-examples
 * https://www.swtestacademy.com/javafx-tutorial/
 */

public class main extends Application {

  Scene scene;
  Jeu jeu;
  char[][] grilleMain;
  KeyEventJeu keyEventJeu;
  GridPane layoutGrille;

  public static void main(String[] args) {
    launch(args);

  }

  public void start(Stage primaryStage) throws Exception {

    /*
     * FXMLLoader loader = new FXMLLoader(getClass().getResource("/test.fxml"));
     * Parent root = loader.load();
     * Scene scene = new Scene(root);
     */

    jeu = new Jeu(scene);
    grilleMain = jeu.getJeuChar();

    layoutGrille = setGrille();
    layoutGrille.setPadding(new Insets(20));
    layoutGrille.setHgap(2);
    layoutGrille.setVgap(2);
    scene = new Scene(layoutGrille);
    keyEventJeu = new KeyEventJeu(jeu);

    setScene(primaryStage, scene, "Don't Forget the Road", jeu.getTailleGrille() * 30 + 200, jeu.getTailleGrille() * 30 + 200);


    scene.setOnKeyPressed(e -> {
      if(!jeu.isFinish())
      {
        scene.setOnKeyPressed(keyEventJeu);
      }
    });

    scene.setOnKeyReleased(e -> {
      if (keyEventJeu.haschange()) {
        grilleMain = jeu.getJeuChar();
        layoutGrille = setGrille();
        layoutGrille.setPadding(new Insets(20));
        layoutGrille.setHgap(2);
        layoutGrille.setVgap(2);
        scene.setRoot(layoutGrille);
        primaryStage.setScene(scene);
      }
    });

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
  }

  public GridPane setGrille() {

    GridPane root = new GridPane();
    Rectangle[][] Rectgrille = new Rectangle[jeu.getTailleGrille()][jeu.getTailleGrille()];

    // Créer un rectangle et y associe un type de case pour chaque cases
    for (int x = 0; x < jeu.getTailleGrille(); x++) {

      for (int y = 0; y < jeu.getTailleGrille(); y++) {

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
