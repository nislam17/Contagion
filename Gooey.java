import javax.swing.*;

import java.awt.*;
  
public class GOOEY extends JFrame{  

	public GOOEY()  
{ 
	setTitle( "Contagion" );
    setSize( 1500, 750 );
    setLocation( 100, 100 );
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    
    JLabel background=new JLabel(new ImageIcon("C:\\Users\\Ruzeb\\workspace\\GOOEY\\mapfinale.jpg"));
    add(background);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    setVisible(true);  
}  
  
public void paint(Graphics g){  
	 super.paint(g);  
	  
	 //draw circle outline  
	 //(posx, negy)
	 g.drawOval(290,155,100,100);  //N.AM
	 g.drawOval(470,390,100,100); //S.AM
	 g.drawOval(900,100,90,90); //EU
	 g.drawOval(800,305,100,100);//AF
	 g.drawOval(1100,180,100,100);//ASIA
	 g.drawOval(1275,435,90,90); //AUS
	  
	 //set color to CYAN
	 //So after this, if you draw anything, all of it's result will be RED  
	 g.setColor(Color.decode("#99FFFFFF"));  
	  
	 //fill circle with RED  
	 
	 g.fillOval(290,155,100,100);  //N.AM
	 g.fillOval(470,390,100,100); //S.AM
	 g.fillOval(900,100,90,90); //EU
	 g.fillOval(800,305,100,100);//AF
	 g.fillOval(1100,180,100,100);//ASIA
	 g.fillOval(1275,435,90,90); //AUS
}  
  
	public static void main(String[]args){  
		GOOEY map=new GOOEY();  
	}  
} 
