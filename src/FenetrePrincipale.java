import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetrePrincipale {

	public static void main(String[] args) {
		//Initialisation Lumiere
		Lumiere l = new Lumiere();
		
		//Initialisation des vues
		VueGraphique vg = new VueGraphique();
		VueBouton vb = new VueBouton();

		//Ajout des observers à Lumiere
		l.addObserver(vg);
		l.addObserver(vb);
		
		//Initialisation du ControleurLumiere
		ControleurLumiere cl = new ControleurLumiere(l,vb);
		vg.addMouseListener(cl);
		
		//Initialisation du ControleurBouton
		ControleurBouton cb = new ControleurBouton(l,vb);
		vb.addActionListener(cb);
		
		//Initalisation de la JFrame
		JFrame frame = new JFrame("Eteint la lumiere! | by : DEMANGE Alessi");
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(vg, BorderLayout.CENTER);
		frame.add(vb, BorderLayout.WEST);
		
		frame.setPreferredSize(new Dimension(650,539));
		frame.pack();
		frame.setVisible(true);
		
	}
}
