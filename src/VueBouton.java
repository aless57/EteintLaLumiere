import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueBouton extends JPanel implements Observer {
	/**
	 * Boutons présents à gauche de la JFrame (Configurer, Aleatoire, Jouer, Quitter) 
	 */
	private JButton configurer, aleatoire, jouer, quitter;
	
	/**
	 * Labels présents à gauche de la JFrame
	 */
	private JLabel nbdeplacement, score, statut;
	
	/**
	 * Contructeur de VueBouton
	 */
	public VueBouton() {
		configurer = new JButton("Configurer");
		aleatoire = new JButton("Aleatoire");
		jouer = new JButton("Jouer");
		quitter = new JButton("Quitter / Relancer");
		nbdeplacement = new JLabel("Nb Deplacements");
		nbdeplacement.setHorizontalAlignment(JLabel.CENTER);
		nbdeplacement.setVerticalAlignment(JLabel.CENTER);
		score = new JLabel("0");
		score.setFont(new Font("COMICSANSMS",Font.BOLD,20));
		score.setHorizontalAlignment(JLabel.CENTER);
		score.setVerticalAlignment(JLabel.CENTER);
		statut = new JLabel("Statut : en attente");
		statut.setFont(new Font("COMICSANSMS",Font.BOLD,15));
		statut.setHorizontalAlignment(JLabel.CENTER);
		statut.setVerticalAlignment(JLabel.CENTER);
		GridLayout g = new GridLayout(8,1);
		g.setVgap(5);
		setLayout(g);
		add(configurer);
		add(aleatoire);
		add(jouer);
		add(nbdeplacement);
		add(score);
		add(quitter);
		add(statut);
	}
	
	/**
	 * Méthode update
	 */
	public void update(Observable arg0, Object arg1) {
		
	}
	
	/**
	 * Méthode qui permet d'ajouter un actionListener à tous les boutons
	 * @param b
	 */
	public void addActionListener(ControleurBouton b) {
		configurer.addActionListener(b);
		aleatoire.addActionListener(b);
		jouer.addActionListener(b);
		quitter.addActionListener(b);
	}
	
	/**
	 * Setteur du JLabel de score
	 * @param s
	 */
	public void setScore(String s) {
		score.setText(s);
	}
	
	/**
	 * Getteur du JBouton Configurer
	 * @return
	 */
	public JButton getConfigurer() {
		return configurer;
	}
	
	/**
	 * Getteur du JBouton Aleatoire
	 * @return
	 */
	public JButton getAleatoire() {
		return aleatoire;
	}
	
	/**
	 * Getteur du JBouton Jouer
	 * @return
	 */
	public JButton getJouer() {
		return jouer;
	}
	
	/**
	 * Setteur du JLabel de score
	 * @param s
	 */
	public void setStatut(String s) {
		statut.setText(s);
	}
	
}
