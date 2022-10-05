package KeyEventJeu;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyEventTest implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent event) {
        String key = event.getText();

        System.out.println(key);

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