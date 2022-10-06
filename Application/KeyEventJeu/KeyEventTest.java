package KeyEventJeu;

import Joueur.Joueur;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyEventTest implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent event) {
        KeyCode key = event.getCode();
        Joueur joueurKeyEvent = new Joueur(10, null);
        System.out.println(key);

        int joueurCoordX = joueurKeyEvent.getJoueurCaseOccupee().getCaseCoordX();
        int joueurCoordY = joueurKeyEvent.getJoueurCaseOccupee().getCaseCoordY();

        if (key == "q") {
            System.out.println("Fleche Gauche");
            joueurKeyEvent.Déplacer(joueurCoordX - 1, joueurCoordY);
        } else if (key == "d") {
            System.out.println("Fleche Droite");
            joueurKeyEvent.Déplacer(joueurCoordX - 1, joueurCoordY);
        } else if (key == "z") {
            System.out.println("Fleche Haut");
            joueurKeyEvent.Déplacer(joueurCoordX - 1, joueurCoordY);
        } else if (key == "s") {
            joueurKeyEvent.Déplacer(joueurCoordX - 1, joueurCoordY);
            System.out.println("Fleche Bas");
        }

    }

}