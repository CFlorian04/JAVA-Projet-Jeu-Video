package Case;

public class Bonus extends Categorie {
    
    int bonusType;

    public Bonus(int bonusType, int modifEndurance, String image) {
        super('O',modifEndurance,image);
        this.bonusType = bonusType;

        //En fonction du type de bonus choisi
        switch(bonusType) 
        {
            case 0 : this.setCategorieModifEndurance(0);
                    break; 

            case 1 : this.setCategorieModifEndurance(0);
                    break;

            case 2 : this.setCategorieModifEndurance(0);
                    break;

            default : this.setCategorieModifEndurance(0);
                    break;
        }
    }
    
}
