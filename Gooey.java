
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;

public class GooeyDemo01 extends JFrame {
	JButton b1;
	JLabel l1;
    public GooeyDemo01() {

        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
          usage: Uncomment 1 line at a time, compile, run.
          Observe, make notes.
          Modify inputs, recompile, run.
          Observe, make notes.
          Q: What does each statement do? What do the inputs do?
          ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

        setTitle( "Contagion" );
        setSize( 1700, 900 );
        setLocation( 100, 100 );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setLayout(new BorderLayout());
    	JLabel background=new JLabel(new ImageIcon("C:\\Users\\Ruzeb\\workspace\\GOOEY\\mapfinale.jpg"));
    	add(background);
    	background.setLayout(new FlowLayout());
    	//l1=new JLabel("Here is a button");
    	//b1=new JButton("I am a button");
    	//background.add(l1);
    	//background.add(b1);
    }


    public static void main( String[] args ) {

        GooeyDemo01 g = new GooeyDemo01();
        g.setVisible( true );
        
        
    }
}
