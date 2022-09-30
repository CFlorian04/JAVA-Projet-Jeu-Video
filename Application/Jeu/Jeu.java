package Jeu;

import javafx.scene.Scene;
import Grille.Grille;
import Joueur.Joueur;
import Case.Case;
//import KeyEvent.KeyEvent;

public class Jeu {

    int tailleGrille = 10;
    int enduranceJoueur = 10;
    Scene sceneJeu;
    Grille grilleJeu;
    Case caseJoueurJeu;
    Joueur joueurJeu;
    //KeyEvent keyEventJeu;


    public Jeu(Scene scene) {
        this.sceneJeu = scene;
        this.caseJoueurJeu = new Case(0,0);
        this.joueurJeu = new Joueur(enduranceJoueur,caseJoueurJeu);
        this.grilleJeu = new Grille(tailleGrille);
        //this.keyEventJeu = new KeyEvent(scene,joueurJeu,grilleJeu);

    }

    public int getTailleGrille()
    {
        return tailleGrille;
    }
    

    public char[][] getJeuChar()
    {
        char[][] grilleFinal = grilleJeu.toChar();
        grilleFinal[joueurJeu.getJoueurCaseOccupee().getCaseCoordX()][joueurJeu.getJoueurCaseOccupee().getCaseCoordY()] = 'A';
        grilleFinal[tailleGrille-1][tailleGrille-1] = 'M';

        return grilleFinal;
    }
}
