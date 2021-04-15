import java.util.Observable;

public class Lumiere extends Observable{
	/**
	 * True : lumière allumé (vert clair)
	 * False : lumière éteinte (vert foncé)
	 */
	private boolean[][] tableauLumiere = new boolean[5][5];
	/**
	 * True : on peut jouer
	 * False : on ne peut pas jouer
	 */
	private boolean jouerounon = false;
	
	/**
	 * True : allumer plusieurs lumiere (quand on joue)
	 * False : allumer une seule lumiere (quand on configure)
	 */
	private boolean uneouplusieur = true;
	
	/**
	 * Argument qui prends le nombre de pas
	 */
	private int nbpas=0;
	
	/**
	 * Constructeur de Lumiere
	 */
	public Lumiere() {
		for (int i=0; i<tableauLumiere.length;i++) {
			for (int y=0; y<tableauLumiere.length;y++) {
				tableauLumiere[i][y] = true;
			}
		}
		jouerounon = false;
		nbpas=0;
	}
	
	/**
	 * Méthode changerValeur qui permet d'allumer une lumière ou de l'eteindre
	 * @param a
	 * @param b
	 */
	public void changerValeur(int a, int b) {
		if (tableauLumiere[a][b]) {
			tableauLumiere[a][b] = false;
		}else {
			tableauLumiere[a][b] = true;
		}
		if (a+1<=4) {
			if(tableauLumiere[a+1][b]) {
				tableauLumiere[a+1][b] = false;
			}else{
				tableauLumiere[a+1][b] = true;
			}
		}
		if (a-1>=0) {
			if (tableauLumiere[a-1][b]) {
				tableauLumiere[a-1][b] = false;
			}else{
				tableauLumiere[a-1][b] = true;
			}
		}
		if (b+1<=4) {
			if (tableauLumiere[a][b+1]) {
				tableauLumiere[a][b+1] = false;
			}else {
				tableauLumiere[a][b+1] = true;
			}
		}
		if (b-1>=0) {
			if(tableauLumiere[a][b-1]) {
				tableauLumiere[a][b-1] = false;
			}else {
				tableauLumiere[a][b-1] = true;
			}
		}
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Méthode qui retourne la taille du tableau de lumiere
	 * @return
	 */
	public int getLengthTableauLumiere(){
		return tableauLumiere.length;
	}
		
	/**
	 * Méthode getTableauLumiere qui permet de regarder si la lumière aux coordonées (a,b) est éteinte ou allumée
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean getTableauLumiere(int a,int b){
		return tableauLumiere[a][b];
	}
	
	/**
	 * Méthode qui permet de mettre la valeur d'une lumiere à true selon une valeur donnée 
	 * @param a
	 * @param b
	 */
	public void setTableauLumiereTrue(int a, int b) {
		tableauLumiere[a][b] = true;
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Setteur qui applique le droit de jouer ou non
	 * @param b
	 */
	public void setJouerounon(boolean b) {
		jouerounon = b;
	}
	
	/**
	 * Getteur qui nous donne l'information si l'on peut jouer ou non
	 * @return
	 */
	public boolean getJouerounon() {
		return jouerounon;
	}
	
	/**
	 * Setteur qui permet d'appliquer le droit de configurer ou de jouer
	 * @param b
	 */
	public void setUneouplusieur(boolean b) {
		uneouplusieur = b;
	}
	
	/**
	 * Getteur qui permet de voir si l'on joue ou si l'on configure
	 * @return
	 */
	public boolean getUneouplusieur() {
		return uneouplusieur;
	}
	
	/**
	 * Getteur de nbPas
	 * @return
	 */
	public int getnbPas() {
		return nbpas;
	}
	
	/**
	 * Setteur de nbPas
	 * @param i
	 */
	public void setNbpas(int i) {
		 nbpas=i;
	}
	
	/**
	 * Méthode qui permet d'allumer une seule lampe selon le click
	 * @param x
	 * @param y
	 */
	public void allumeroueteindreunelampe(int x, int y) {
		int a,b;
		a=y/100;
		b=x/100;
		if (tableauLumiere[a][b]) {
			tableauLumiere[a][b]=false;
		}else {
			tableauLumiere[a][b]=true;
		}
		setChanged();
		notifyObservers();
	}
	/**
	 * Méthode qui permet d'allumer ou d'eteindre une lumiere et celles adjacentes selon des coordonnées de click
	 * @param x
	 * @param y
	 */
	public void allumeroueteindre(int x, int y) {
		int a,b;
		a=y/100;
		b=x/100;
		changerValeur(a,b);
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Méthode qui permet d'éteindre obligatoirement i lumiere(s) donnée(s)
	 * @param i
	 */
	public void allumerAleatoire(int i) {
		for (int a=0; a<tableauLumiere.length;a++) {
			for (int z=0; z<tableauLumiere.length;z++) {
				tableauLumiere[a][z] = true;
			}
		}
		for (int y=0;y<i;y++) {
			int a=(int) (Math.random()*5);
			int b=(int) (Math.random()*5);
			while(!tableauLumiere[a][b]) {
				a=(int) (Math.random()*5);
				b=(int) (Math.random()*5);
			}
			tableauLumiere[a][b] = false;
			setChanged();
			notifyObservers();
		}
	}
	
	/**
	 * Méthode qui permet de voir s'il reste des lumiere éteinte ou non apres un click
	 * @return
	 */
	public boolean finiounonApresClick(int x, int y) {
		int e=0;
		e=x;
		x=y/100;
		y=e/100;
		changerValeur(x,y);
		boolean res = true;
		for (int i=0; i<tableauLumiere.length;i++) {
			for (int w=0; w<tableauLumiere.length;w++) {
				if (!tableauLumiere[i][w]) {
					res = false;
				}
			}
		}
		setChanged();
		notifyObservers();
		return res;
	}
	/**
	 * Méthode qui permet de voir s'il reste des lumiere éteinte ou non
	 * @return
	 */
	public boolean finiounon() {
		boolean res = true;
		for (int i=0; i<tableauLumiere.length;i++) {
			for (int w=0; w<tableauLumiere.length;w++) {
				if (!tableauLumiere[i][w]) {
					res = false;
				}
			}
		}
		return res;
	}
}
