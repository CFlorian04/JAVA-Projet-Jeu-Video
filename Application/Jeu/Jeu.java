package Jeu;

import javafx.scene.Scene;
import Grille.Grille;
import Joueur.Joueur;
import Case.Bonus;
import Case.Case;
import Case.Obstacle;

public class Jeu {

    boolean jeuFini = false;
    int tailleGrille = 10;
    int enduranceJoueur = 25;
    Scene sceneJeu;
    Grille grilleJeu;
    Case caseJoueurJeu;
    Joueur joueurJeu;
    Case arrivéeCase = new Case(tailleGrille-1, tailleGrille-1);

    public Jeu(Scene scene) {
        this.sceneJeu = scene;
        this.caseJoueurJeu = new Case(0, 0);
        this.joueurJeu = new Joueur(enduranceJoueur, caseJoueurJeu);
        this.grilleJeu = new Grille(tailleGrille);

        this.ShowGrille();

    }

    public int getTailleGrille() {
        return tailleGrille;
    }

    public char[][] getJeuChar() {
        char[][] grilleFinal = grilleJeu.toChar();
        grilleFinal[joueurJeu.getJoueurCaseOccupee().getPosX()][joueurJeu.getJoueurCaseOccupee().getPosY()] = 'A';
        grilleFinal[arrivéeCase.getPosX()][arrivéeCase.getPosY()] = 'M';

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

    public boolean isFinish() {
        return jeuFini;
    }

    public void moveJoueurJeu(char key) {
        int joueurCoordX = joueurJeu.getJoueurCaseOccupee().getPosX();
        int joueurCoordY = joueurJeu.getJoueurCaseOccupee().getPosY();
        System.out.println("\033[H\033[2J");
        System.out.flush();
        System.out.println("#######################");
        if (joueurJeu.getJoueurEndurance() > 0) {
            int changeX = 0;
            int changeY = 0;
            switch (key) {
                case 'g':
                    changeX = -1;
                    break;
                case 'd':
                    changeX = 1;
                    break;
                case 'h':
                    changeY = -1;
                    break;
                case 'b':
                    changeY = 1;
                    break;
            }
            
            if ((joueurCoordX + changeX >= 0 && joueurCoordX + changeX < tailleGrille) && (joueurCoordY + changeY >= 0 && joueurCoordY + changeY < tailleGrille)) {

                Case futur = grilleJeu.getCase(joueurCoordX + changeX, joueurCoordY + changeY);
        
                if (!(futur.getCategorie() instanceof Obstacle)) {
                    joueurJeu.Déplacer(joueurCoordX + changeX, joueurCoordY + changeY);
                    if ((futur.getCategorie() instanceof Bonus)) {
                        joueurJeu.modifEndurance(10);
                        futur.setCategorie(null);
                    }
                } else {
                    joueurJeu.modifEndurance(-10);
                }
            }
        } else {
            jeuFini = true;
            System.out.println("Perdu");
        }

        if (joueurJeu.getJoueurCaseOccupee().compareTo(arrivéeCase) == 0) {
            jeuFini = true;
            System.out.println("Gagné");
        }
        System.out.println("Endurance : " + joueurJeu.getJoueurEndurance());
        this.ShowGrille();

    }
}
