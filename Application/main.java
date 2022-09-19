import javax.swing.JFrame;
import javax.swing.JTextField;
import MKeyListener.MKeyListener;




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





