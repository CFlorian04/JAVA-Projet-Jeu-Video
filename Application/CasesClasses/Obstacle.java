package CasesClasses;

public class Obstacle extends Categorie {

    int type;

    public Obstacle(int type) {
        super('X');
        this.type = type;

        //En fonction du type d'obstacle choisi
        switch(type) 
        {
            case 0 : this.setModifEndurance(0);
                    break; 

            case 1 : this.setModifEndurance(0);
                    break;

            case 2 : this.setModifEndurance(0);
                    break;

            default : this.setModifEndurance(0);
                    break;
        }

        
    }
    public char getCharType() {
        return 'X';
    }
}
