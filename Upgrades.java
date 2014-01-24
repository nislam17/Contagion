import javax.swing.*;
import java.net.*;
 
public class Upgrades {
 
    public static void main(String[] args) throws MalformedURLException {
    URL yellow = new URL("http://www.iconsdb.com/icons/download/caribbean-blue/hexagon-512.jpg");
    URL orange = new URL("http://www.iconsdb.com/icons/download/gray/hexagon-512.jpg");
    
 
        
 
        JButton b = new JButton("Round");
        b.setIcon(new ImageIcon(yellow));
        b.setRolloverIcon(new ImageIcon(orange));
        
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setRolloverEnabled(false);
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.setContentAreaFilled(false);
 
    JFrame f = new JFrame("round button test");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel p = new JPanel();
        p.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        
        p.add(b);
        f.setContentPane(p);
        f.pack();
        f.setVisible(true);
    }
}
