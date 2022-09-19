import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JTextField;


public class main {

    public static void main(String[] argv) throws Exception {
    	 
	  JTextField textField = new JTextField();
	 
	  textField.addKeyListener(new MKeyListener());
	 
	  JFrame jframe = new JFrame();
	 
	  jframe.add(textField);
	 
	  jframe.setSize(100, 100);
	 
	  jframe.setVisible(true);
 
    }
}

class MKeyListener extends KeyAdapter {
	
	int[][] tableau = new int[5][5];
	 
	public void keyPressed(KeyEvent e) {
	    if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
	            //Right arrow key code
	    	System.out.println("Flèche Droite");
	    } else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
	            //Left arrow key code
	    	System.out.println("Flèche Gauche");
	    } else if (e.getKeyCode() == KeyEvent.VK_UP ) {
	            //Up arrow key code
	    	System.out.println("Flèche Haut");
	    } else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
	            //Down arrow key code
	    	System.out.println("Flèche Bas");
	    }
	    else 
	    	System.out.println(e.getKeyCode());

	    
	    System.out.println(Arrays.deepToString(tableau));
	}
}



