package KeyEvent;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import Joueur.Joueur;
import Grille.Grille;

public class KeyEvent {

    Scene sceneKeyEvent;
    Joueur joueurKeyEvent;
    Grille grilleKeyEvent;

    public KeyEvent(Scene scene, Joueur joueur, Grille grille){
        this.joueurKeyEvent = joueur;
        this.sceneKeyEvent = scene;
        this.grilleKeyEvent = grille;
        SceneAddKeyEvent(sceneKeyEvent);
    }

    public void SceneAddKeyEvent(Scene sceneKeyEvent){

        sceneKeyEvent.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
			int joueurCoordX = joueurKeyEvent.getJoueurCaseOccupee().getCaseCoordX();
            int joueurCoordY = joueurKeyEvent.getJoueurCaseOccupee().getCaseCoordY();

			if(event.getCode() == KeyCode.LEFT)
			{
				System.out.println("Fleche Gauche");
                if(true )
                {
                    joueurKeyEvent.Déplacer(joueurCoordX-1,joueurCoordY);
                }

			}
			else if(event.getCode() == KeyCode.RIGHT)
			{
				System.out.println("Fleche Droite");
                joueurKeyEvent.Déplacer(joueurCoordX-1,joueurCoordY);
			}
			else if(event.getCode() == KeyCode.UP)
			{
				System.out.println("Fleche Haut");
                joueurKeyEvent.Déplacer(joueurCoordX-1,joueurCoordY);
			}
			else if(event.getCode() == KeyCode.DOWN)
			{
                joueurKeyEvent.Déplacer(joueurCoordX-1,joueurCoordY);
				System.out.println("Fleche Bas");
			}
		});
    }
    
    
}