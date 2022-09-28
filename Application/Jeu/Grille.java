package Jeu;

import CasesClasses.Case;

public class Grille {
    int hauteur;
    int largeur;
    Case[][] Casegrille;
    public Grille(int tailleGrille){
        hauteur = tailleGrille;
        largeur = tailleGrille;
        Casegrille = new Case[tailleGrille][tailleGrille];
    }

    public Grille(int hauteur, int largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        Casegrille = new Case[largeur][hauteur];// peut être inversé, à tester
    }
}
