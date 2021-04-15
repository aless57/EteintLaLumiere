import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurBouton implements ActionListener {

	private Lumiere l;
	private VueBouton vb;
	
	/**
	 * Constructeur de ControleurBouton
	 * @param ll
	 * @param vbb
	 */
	public ControleurBouton(Lumiere ll, VueBouton vbb) {
		l=ll;
		vb=vbb;
	}
	
	/**
	 * Méthode qui permet d'ajouter l'actionPerformed des JBoutons
	 */
	public void actionPerformed(ActionEvent arg0) {
		String res = arg0.getActionCommand();
		//Pour le JBouton Aleatoire
		if (res.equals("Aleatoire")) {
			System.out.println("Mode Aleatoire active.");
			l.allumerAleatoire((int) (Math.round(Math.random()*8)));
		}
		//Pour le JBouton Jouer
		if (res.equals("Jouer")) {
			if (l.finiounon()) {
				System.out.println("Veuillez configurer la partie ou lancer en aleatoire avant de jouer");
			}else {
				System.out.println("Le jeu se lance!");
				vb.getAleatoire().setEnabled(false);
				vb.getConfigurer().setEnabled(false);
				vb.getJouer().setEnabled(false);
				vb.setStatut("Statut : en jeu");
				l.setUneouplusieur(true);
				l.setJouerounon(true);
				l.setNbpas(0);
			}
		}
		//Pour le JBouton Configurer
		if (res.equals("Configurer")) {
			if (!l.getUneouplusieur()) {
				System.out.println("Le jeu n'est plus en configuration.");
				l.setUneouplusieur(true);
				vb.setStatut("Statut : en attente");
			}else {
				System.out.println("Le jeu est en train d'etre configurer.");
				l.setUneouplusieur(false);
				vb.setStatut("Statut : en config");
			}
		}
		//Pour le JBouton Quitter
		if (res.equals("Quitter / Relancer")) {
			System.out.println("On remet la partie a 0.");
			for (int i=0; i<l.getLengthTableauLumiere();i++) {
				for (int y=0; y<l.getLengthTableauLumiere();y++) {
					l.setTableauLumiereTrue(i, y);
				}
			}
			l.setJouerounon(false);
			vb.getAleatoire().setEnabled(true);
			vb.getConfigurer().setEnabled(true);
			vb.getJouer().setEnabled(true);
			vb.setScore("0");
			vb.setStatut("Statut : en attente");
		}
	}
}
