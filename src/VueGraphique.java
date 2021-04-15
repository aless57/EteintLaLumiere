import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class VueGraphique extends JPanel implements Observer{

	private Lumiere grilleLumiere = new Lumiere();
	
	/**
	 * Méthode paintComponent pour mettre a jour le tableau de lumiere
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x=0,y=0;
		for (int i=0; i<grilleLumiere.getLengthTableauLumiere(); i++) {
			for (int w=0; w<grilleLumiere.getLengthTableauLumiere(); w++) {
				if (grilleLumiere.getTableauLumiere(i,w)) {
					g.setColor(new Color(0,100,0));
					g.fillRect(x, y, 100, 100);
					g.setColor(Color.BLACK);
					g.drawRect(x, y, 100, 100);
					x+=100;
				}else {
					g.setColor(new Color(0,255,0));
					g.fillRect(x, y, 100, 100);
					g.setColor(Color.BLACK);
					g.drawRect(x, y, 100, 100);
					x+=100;
				}
			}
			x=0;
			y+=100;
		}
	}
	
	/**
	 * Méthode update
	 */
	public void update(Observable arg0, Object arg1) {
		grilleLumiere = (Lumiere) arg0;
		repaint();
		
	}

}
