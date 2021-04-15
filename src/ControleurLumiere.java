import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControleurLumiere implements MouseListener{

	private Lumiere l;
	private VueBouton vb;
	
	public ControleurLumiere(Lumiere lu, VueBouton vbb) {
		l=lu;
		vb=vbb;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Méthode mousePressed (celle qui nous intéresse) qui agit lorsque que l'on click sur la grille
	 */
	public void mousePressed(MouseEvent arg0) {
		int x = arg0.getX();
		int y = arg0.getY();
		int pas = l.getnbPas();
		if(l.getJouerounon()) {
			if (l.finiounonApresClick(x,y)) {
				vb.setStatut("Statut : Gagné !");
				System.out.println("Tu as gagnée!");
			}else {
				vb.setStatut("Statut : en jeu");
				pas = pas + 1;
				System.out.println("Nombre de pas : " + pas);
				l.setNbpas(pas);
				vb.setScore(""+l.getnbPas());
			}	
		}else {
			if(!l.getUneouplusieur()) {
				l.allumeroueteindreunelampe(x, y);
				System.out.println("La lampe en "+ x/100+" ; "+y/100+" a ete modifiee");
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
