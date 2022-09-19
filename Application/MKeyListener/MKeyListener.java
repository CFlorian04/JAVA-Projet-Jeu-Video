package MKeyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MKeyListener extends KeyAdapter {
	
	int taille = 3;

	int[][] tableau = new int[taille][taille];
	int x = 0;
	int y = 0;



	public void keyPressed(KeyEvent e) {

		tableau[x][y] = 0;

	    if (e.getKeyCode() == KeyEvent.VK_RIGHT )
		{
	         //Right arrow key code
	    	System.out.println("Fleche Droite");
			if(y < taille-1)
			{
				y++;
			}
	    } else if (e.getKeyCode() == KeyEvent.VK_LEFT )
		{
	         //Left arrow key code
	    	System.out.println("Fleche Gauche");
			if(y > 0)
			{
				y--;
			}
	    } else if (e.getKeyCode() == KeyEvent.VK_DOWN )
		{
	         //Up arrow key code
	    	System.out.println("Fleche Bas");
			if(x < taille-1)
			{
				x++;
			}
	    } else if (e.getKeyCode() == KeyEvent.VK_UP)
		{
	        //Down arrow key code
	    	System.out.println("Fleche Haut");
			if(x > 0)
			{
				x--;
			}
	    }

		tableau[x][y] = 1;

		for(int i = 0; i < taille; i++)
		{
			for(int y = 0; y < taille; y++)
			{
				System.out.print(tableau[i][y]);
			}
			System.out.println();
		}
	}
}
