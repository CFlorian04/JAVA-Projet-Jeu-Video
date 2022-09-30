package CasesClasses;


public class Categorie
{
    int modifEndurance;
    String imageSrc;
    char charType;

    public Categorie(char charType) {
        this.modifEndurance = 0;
        this.charType = charType;
    }

    public int getModifEndurance() {
        return modifEndurance;
    }

    public void setModifEndurance(int modifEndurance) {
        this.modifEndurance = modifEndurance;
    }

    public String getImageSrc()
    {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc)
    {
        this.imageSrc = imageSrc;
    }

    public char getCharType() {
        return charType;
    }
    
}