package Case;

public class Obstacle extends Categorie {

    int obstacleType;

    public Obstacle(int obstacleType, int modifEndurance, String image) {
        super('X',modifEndurance,image);
        this.obstacleType = obstacleType;

         //En fonction du type d'obstacle choisi
         switch(obstacleType) 
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
