package CasesClasses;


public class Case {

    private int posX;
    private int posY;
    private Categorie categorie;

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

    public Categorie getCategorie()
    {
        return categorie;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    
}
