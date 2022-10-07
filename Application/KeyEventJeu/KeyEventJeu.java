package KeyEventJeu;

import Jeu.Jeu;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyEventJeu implements EventHandler<KeyEvent> {
    Jeu jeu;
    boolean change = false;

    public KeyEventJeu(Jeu jeu) {
        super();
        this.jeu = jeu;
        System.out.println(jeu.getTailleGrille());
    }

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    @Override
    public void handle(KeyEvent event) {
        KeyCode key = event.getCode();

        if (key == KeyCode.LEFT) {
            jeu.moveJoueurJeu('g');
            change = true;
        } else if (key == KeyCode.RIGHT) {
            jeu.moveJoueurJeu('d');
            change = true;
        } else if (key == KeyCode.UP) {
            jeu.moveJoueurJeu('h');
            change = true;
        } else if (key == KeyCode.DOWN) {
            jeu.moveJoueurJeu('b');
            change = true;
        }
        else {
            change = false;
        }

    }

    public boolean haschange()
    {
        if(change)
        {
            change = false;
            return true;
        }
        return false;
    }

}