package Joueur;

import CasesClasses.Case;

public class Joueur {
    int endurance;
    Case caseOccupe;
	
	public Joueur(int endurance, Case caseOccupe) {
		this.endurance = endurance;
        this.caseOccupe = caseOccupe;
	}

    /**
     * 
     * @param dir prent l'une des possibilité
     * @return vrai si déplacement éffectué
     */
    public void Deplacer(int destX, int destY) {
        caseOccupe.setPosX(destX);
        caseOccupe.setPosY(destY);
    }

    public int MarcheX(int pats) {
        if(endurance > 0){
            caseOccupe.setPosX(caseOccupe.getPosX()+pats);
        }
        endurance -= 1;
        return this.endurance;
    }
    public int MarcheY(int pats) {
        if(endurance > 0){
            caseOccupe.setPosY(caseOccupe.getPosY()+pats);
        }
        endurance -= 1;
        return this.endurance;
    }

    
    public Case getCaseOccupe() {
        return caseOccupe;
    }

    public int getEndurance (){
        return this.endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public void setCaseOccupe(Case caseOccupe) {
        this.caseOccupe = caseOccupe;
    }
    
}
