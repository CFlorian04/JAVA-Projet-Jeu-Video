package Jeu;

import javafx.scene.Scene;
import Grille.Grille;
import Joueur.Joueur;
import KeyEventJeu.KeyEventJeu;
import Case.Case;
import Case.Obstacle;

public class Jeu {

    int tailleGrille = 10;
    int enduranceJoueur = 25;
    Scene sceneJeu;
    Grille grilleJeu;
    Case caseJoueurJeu;
    Joueur joueurJeu;

    public Jeu(Scene scene) {
        this.sceneJeu = scene;
        this.caseJoueurJeu = new Case(0, 0);
        this.joueurJeu = new Joueur(enduranceJoueur, caseJoueurJeu);
        this.grilleJeu = new Grille(tailleGrille);

    }

    public int getTailleGrille() {
        return tailleGrille;
    }

    public char[][] getJeuChar() {
        char[][] grilleFinal = grilleJeu.toChar();
        grilleFinal[joueurJeu.getJoueurCaseOccupee().getPosX()][joueurJeu.getJoueurCaseOccupee().getPosY()] = 'A';
        grilleFinal[tailleGrille - 1][tailleGrille - 1] = 'M';

        return grilleFinal;
    }

    public void ShowGrille() {

        char[][] jeuCharGrille = this.getJeuChar();

        for (int x = 0; x < this.getTailleGrille(); x++) {

            for (int y = 0; y < this.getTailleGrille(); y++) {
      
              System.out.print(jeuCharGrille[y][x]);
            }
            System.out.println(" ");
        }
    }

    public void moveJoueurJeu(char key) {
        int joueurCoordX = joueurJeu.getJoueurCaseOccupee().getPosX();
        int joueurCoordY = joueurJeu.getJoueurCaseOccupee().getPosY();
        if (joueurJeu.getJoueurEndurance() > 0) {
            if (key == 'g') {
                if (!(grilleJeu.getCase(joueurCoordX - 1, joueurCoordY).getCategorie() instanceof Obstacle)) {
                   // System.out.println("Fleche Gauche");
                    joueurJeu.Déplacer(joueurCoordX - 1, joueurCoordY);
                } else {
                    System.out.println("Obstacle");
                }
            } else if (key == 'd') {
                if (!(grilleJeu.getCase(joueurCoordX + 1, joueurCoordY).getCategorie() instanceof Obstacle)) {
                    //System.out.println("Fleche Droite");
                    joueurJeu.Déplacer(joueurCoordX + 1, joueurCoordY);
                } else {
                    System.out.println("Obstacle");
                }
            } else if (key == 'h') {
                if (!(grilleJeu.getCase(joueurCoordX, joueurCoordY - 1).getCategorie() instanceof Obstacle)) {
                    //System.out.println("Fleche Haut");
                    joueurJeu.Déplacer(joueurCoordX, joueurCoordY - 1);
                } else {
                    System.out.println("Obstacle");
                }
            } else if (key == 'b') {
                if (!(grilleJeu.getCase(joueurCoordX, joueurCoordY + 1).getCategorie() instanceof Obstacle)) {
                    joueurJeu.Déplacer(joueurCoordX, joueurCoordY + 1);
                    //System.out.println("Fleche Bas");
                } else {
                    System.out.println("Obstacle");
                }
            }
            System.out.println( joueurJeu.getJoueurCaseOccupee().getPosX() + " / " + joueurJeu.getJoueurCaseOccupee().getPosY());
        }
        else {
            System.out.println("Plus endurance");
        }

        this.ShowGrille();

    }
}
