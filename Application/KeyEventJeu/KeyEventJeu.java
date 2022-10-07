package KeyEventJeu;

import Jeu.Jeu;
import Joueur.Joueur;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyEventJeu implements EventHandler<KeyEvent> {
    Jeu jeu;

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
        Joueur joueurKeyEvent = new Joueur(10, null);

        if (key == KeyCode.LEFT) {
            jeu.moveJoueurJeu('g');
        } else if (key == KeyCode.RIGHT) {
            jeu.moveJoueurJeu('d');
        } else if (key == KeyCode.UP) {
            jeu.moveJoueurJeu('h');
        } else if (key == KeyCode.DOWN) {
            jeu.moveJoueurJeu('b');
        }

    }

}