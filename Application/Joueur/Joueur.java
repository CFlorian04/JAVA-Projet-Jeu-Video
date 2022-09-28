package Joueur;

import Case.Case;


public class Joueur {
    int joueurEndurance;
    Case joueurCaseOccupee;


    public Joueur(int joueurEndurance, Case joueurCaseOccupee) {
        this.joueurEndurance = joueurEndurance;
        this.joueurCaseOccupee = joueurCaseOccupee;
    }

    public int getJoueurEndurance() {
        return joueurEndurance;
    }

    public void setJoueurEndurance(int joueurEndurance) {
        this.joueurEndurance = joueurEndurance;
    }

    public Case getJoueurCaseOccupee() {
        return joueurCaseOccupee;
    }

    public void setJoueurCaseOccupee(Case joueurCaseOccupee) {
        this.joueurCaseOccupee = joueurCaseOccupee;
    }
    
    public boolean Déplacer(int caseCoordX, int caseCoordY)
    {
        if(joueurEndurance > 0)
        {
            joueurCaseOccupee.setCaseCoordX(caseCoordX);
            joueurCaseOccupee.setCaseCoordY(caseCoordY);
            this.joueurEndurance -= 1;
            return true;
        }
        return false;
    }

}
