package CasesClasses;


public class Case implements Comparable{

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

    /**
     * Test si c est un voisin
     * @param c case à tester
     * @return vrai si c est un voisin
     */
    public boolean voisin(Case c){
        if(((c.getPosX() + 1 == this.posX || c.getPosX() -1 == this.posX + 1) && c.getPosY() == this.posY) || 
            ((c.getPosY() + 1 == this.posY || c.getPosY() -1 == this.posY + 1) && c.getPosX() == this.posX)){
                return true; // c est un voisin
        }else return false;// c n'est pas voisin
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

    public char toChar() {
        if (this.categorie!= null){
            return this.getCategorie().getCharType();
        } else return '_';//si case vide retourner _
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        Case compare = (Case) o;
        int selfPoint = this.posX + this.posY;
        int comparePoint = compare.getPosX() + compare.getPosY();
        if(selfPoint > comparePoint) return 1;
        else if (selfPoint < comparePoint) return -1;
        else return 0;
    }
    
}
