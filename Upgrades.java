
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
 
public class Upgrades implements ActionListener{
	
    public Upgrades(JButton a, JButton b, JButton c, 
    		JButton d, JButton e, JButton f, JButton g, JButton h, JButton i) {
    	//super(new GridLayout(100,100));

    	// ================ SETTING ACTION LISTENERS ===============
    	a.setText("Air");
    	b.setText("Water");
    	c.setText("Livestock");
    	d.setText("Insomnia");
    	e.setText("Paranoia");
    	f.setText("Paralysis");
    	g.setText("Coma");
    	h.setText("Genetic Reshuffle");
    	i.setText("Drug Resistance");
        //===========================================================       
    	//JPanel mainPanel = new JPanel();
    	//mainPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 300, 100)); 
    	JTabbedPane tabbedPane = new JTabbedPane();
    	

    	JComponent panel1 = makeTextPanel("Transmission Upgrades");
    	tabbedPane.addTab("Transmission", null, panel1,
    	                  "To primarily increase Infectivity");
    	//tabbedPane.setTabPlacement(JTabbedPane.CENTER);
    	tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
    	panel1.setPreferredSize(new Dimension(400, 200));
    	panel1.add(a);
    	panel1.add(b);
    	panel1.add(c);
    	
    	JComponent panel2 = makeTextPanel("Symptoms");
    	tabbedPane.addTab("Symptoms", null, panel2,
    	                  "To primarily increase severity");
    	tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
    	panel2.setPreferredSize(new Dimension(400, 200));
    	panel2.add(d);
    	panel2.add(e);
    	panel2.add(f);
    	panel2.add(g);

    	JComponent panel3 = makeTextPanel("Abilities");
    	tabbedPane.addTab("Fight the Cure", null, panel3,
    	                  "To primarily decrease the cure");
    	tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
    	panel3.setPreferredSize(new Dimension(400, 200));
    	panel3.add(h);
    	panel3.add(i);

    	//add(tabbedPane);
    	
        JFrame f1 = new JFrame("Upgrades");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        f1.setContentPane(tabbedPane);
        f1.pack();
        f1.setVisible(true);
        
        buttoner(a);
        buttoner(b);
        buttoner(c);
        buttoner(d);
        buttoner(e);
        buttoner(f);
        buttoner(g);
        buttoner(h);
        buttoner(i);
    }
    
	 public void buttoner(JButton b){
		 	
	    	ImageIcon red = new ImageIcon("red.png");
	    	ImageIcon gray = new ImageIcon("gray.png");  
	        b.setIcon(red);
	        b.setRolloverIcon(gray); 
	        b.setHorizontalTextPosition(JButton.CENTER);
	        b.setRolloverEnabled(true);
	        b.setFocusPainted(false);
	        b.setBorderPainted(false);
	        b.setContentAreaFilled(false);
	    }
	 protected JComponent makeTextPanel(String text) {
	        JPanel panel = new JPanel(false);
	        JLabel filler = new JLabel(text);
	        filler.setHorizontalAlignment(JLabel.CENTER);
	        panel.setLayout(new GridLayout(1, 1));
	        panel.add(filler);
	        return panel;
	    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
