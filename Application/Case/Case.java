package Case;

public class Case {

    private int caseCoordX;
    private int caseCoordY;
    private Categorie caseCategorie;

    
    public Case(int caseCoordX, int caseCoordY) {
        this.caseCoordX = caseCoordX;
        this.caseCoordY = caseCoordY;
    }


    public Case(int caseCoordX, int caseCoordY, Categorie caseCategorie) {
        this.caseCoordX = caseCoordX;
        this.caseCoordY = caseCoordY;
        this.caseCategorie = caseCategorie;
    }


    public int getCaseCoordX() {
        return caseCoordX;
    }


    public void setCaseCoordX(int caseCoordX) {
        this.caseCoordX = caseCoordX;
    }


    public int getCaseCoordY() {
        return caseCoordY;
    }


    public void setCaseCoordY(int caseCoordY) {
        this.caseCoordY = caseCoordY;
    }


    public Categorie getCaseCategorie() {
        return caseCategorie;
    }


    public void setCaseCategorie(Categorie caseCategorie) {
        this.caseCategorie = caseCategorie;
    }

    public boolean voisin(Case c){
        if(((c.getCaseCoordX() + 1 == this.caseCoordX || c.getCaseCoordX() -1 == this.caseCoordX + 1) && c.getCaseCoordY() == this.caseCoordY) || 
            ((c.getCaseCoordY() + 1 == this.caseCoordY || c.getCaseCoordY() -1 == this.caseCoordY + 1) && c.getCaseCoordX() == this.caseCoordX)){
                return true; // c est un voisin
        }
        else return false;// c n'est pas voisin
    }
    
    
}
