package CasesClasses;



public class Bonus extends Categorie {
    
    int type;

    public Bonus(int type) {
        super('O');
        this.type = type;

        //En fonction du type de bonus choisi
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
        return 'O';
    }
}
