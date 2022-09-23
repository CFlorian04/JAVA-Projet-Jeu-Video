package Joueur;

import CasesClasses.Case;
import javafx.scene.input.KeyCode;

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
        endurance -= 1;
    }

    public Case getCaseOccupe() {
        return caseOccupe;
    }
    
}
