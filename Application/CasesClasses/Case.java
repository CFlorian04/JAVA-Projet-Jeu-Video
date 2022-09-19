package CasesClasses;


public class Case {

    int posX;
    int posY;
    Categorie categorie;

    public Case(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public Case(int posX, int posY, Categorie categorie) {
        this.posX = posX;
        this.posY = posY;
        this.categorie = categorie;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
    
}
