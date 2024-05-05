package items;

import java.awt.Image;
import javax.swing.ImageIcon;
import jeu.Main;

public class Item {

	private int largeur, hauteur;
	private int x, y;
	
	protected Image imgObjet;
	protected ImageIcon icoObjet;

	public Item(int x, int y, int largeur, int hauteur){
		this.x = x;
		this.y = y;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

    public int getX() {return x;}

	public int getY() {return y;}

	public int getLargeur() {return largeur;}

	public int getHauteur() {return hauteur;}
	
	public Image getImgObjet() {return imgObjet;}

	public void setX(int x) {this.x = x;}

	public void setY(int y) {this.y = y;}

	public void setLargeur(int largeur) {this.largeur = largeur;}

	public void setHauteur(int hauteur) {this.hauteur = hauteur;}

	public void deplacement(){
		
		if(Main.level1Scene.getxPos() >= 0){
			this.x = this.x - Main.level1Scene.getDx();
		}
	}
	
}
