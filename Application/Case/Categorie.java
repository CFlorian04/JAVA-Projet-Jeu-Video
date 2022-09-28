package Case;

public class Categorie {
    
    int categorieModifEndurance;
    String categorieImage;

    public Categorie(int categorieModifEndurance, String categorieImage) {
        this.categorieModifEndurance = categorieModifEndurance;
        this.categorieImage = categorieImage;
    }

    public int getCategorieModifEndurance() {
        return categorieModifEndurance;
    }

    public void setCategorieModifEndurance(int categorieModifEndurance) {
        this.categorieModifEndurance = categorieModifEndurance;
    }

    public String getCategorieImage() {
        return categorieImage;
    }

    public void setCategorieImage(String categorieImage) {
        this.categorieImage = categorieImage;
    }

    
}
