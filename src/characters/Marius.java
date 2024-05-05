package characters;

import java.awt.Image;
import java.util.Objects;

import javax.swing.ImageIcon;

import items.Item;
import jeu.Main;
import items.Coin;

public class Marius extends Character {


	private final Image imgMario;
    private boolean saut;
    private int compteurSaut;
    private int compteurMort;

	public Marius(int x, int y) {

	super(x, y, 28, 50);
        ImageIcon icoMario = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/mariusWalkR.png")));
	this.imgMario = icoMario.getImage();
	
	this.saut = false;
	this.compteurSaut = 0;
	this.compteurMort = 0;
	}

	public Image getImgMario() {return imgMario;}

	public boolean isSaut() {return saut;}

	public void setSaut(boolean saut) {this.saut = saut;}

	@Override
	public Image marche(String nom, int frequence) {
    	String str;
    	ImageIcon ico;
		Image img;			
		if (!this.marche || Main.level1Scene.getxPos() <= 0 || Main.level1Scene.getxPos() > 4430) {
			if(this.versDroite){str = STR."src/images/\{nom}ArretDroite.png";}
			else{str = STR."src/images/\{nom}ArretGauche.png";}
		}else{
		    this.compteur++;
		    if (this.compteur / frequence == 0) {
		    	if(this.versDroite){str = STR."src/images/\{nom}ArretDroite.png";}
		    	else{str = STR."src/images/\{nom}ArretGauche.png";}
		    }else{
		    	if(this.versDroite){str = STR."src/images/\{nom}MarcheDroite.png";}
		    	else{str = STR."src/images/\{nom}MarcheGauche.png";}
		    }		    
		    if (this.compteur == 2 * frequence) {this.compteur = 0;}
		}

		ico = new ImageIcon(str);
		img = ico.getImage();
		return img;
	}
	
    public Image saute(){		
	    ImageIcon ico;
	    Image img;
	    String str;
	
		this.compteurSaut++;
		if(this.compteurSaut <= 40){
			if(this.getY() > Main.level1Scene.getHautPlafond()){this.setY(this.getY() - 4);}
			else{this.compteurSaut = 41;}			
			if(this.isVersDroite()){str = "/images/mariusJumpR.png";}
			else{str = "/images/mariusJumpL.png";}
			
		}else if(this.getY() + this.getHauteur() < Main.level1Scene.getySol()){this.setY(this.getY() + 1);
			if(this.isVersDroite()){str = "/images/mariusJumpR.png";}
			else{str = "/images/mariusJumpL.png";}
			
		}else{
			if(this.isVersDroite()){str = "/images/mariusNormalR.png";}
			else{str = "/images/mariusNormalL.png";}
			this.saut = false;
			this.compteurSaut = 0;
		}
		ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
		img = ico.getImage();
		return img;
	}
    
	public void contact(Item item) {
		if((super.contactAvant(item) && this.isVersDroite()) || (super.contactArriere(item) && !this.isVersDroite())){
			Main.level1Scene.setDx(0);
		    this.setMarche(false);
		}
        if(super.contactDessous(item) && this.saut){
			Main.level1Scene.setySol(item.getY());
		}else if(!super.contactDessous(item)){
			Main.level1Scene.setySol(293);
			if(!this.saut){this.setY(243);}
		}
        if(super.contactDessus(item)){
			Main.level1Scene.setHautPlafond(item.getY() + item.getHauteur());
		}else if(!super.contactDessus(item) && !this.saut){
			Main.level1Scene.setHautPlafond(0);
		}     
	}
	
	public boolean contactPiece(Coin coin){
        return this.contactArriere(coin) || this.contactAvant(coin) || this.contactDessous(coin) ||
                this.contactDessus(coin);
	}	

	public void contact(Character character) {
		if((super.contactAvant(character)) || (super.contactArriere(character))){
			this.setMarche(false);
		    this.setVivant(false);
		}else if(super.contactDessous(character)){
			character.setMarche(false);
			character.setVivant(false);
		}
    }
	
	public Image meurt(){		
		String str;
    	ImageIcon ico;
		Image img;	
		
        str = "/images/death.png";
        this.compteurMort++;
        if(this.compteurMort > 100){
        	str = "/images/mariusDeath.png";
        	this.setY(this.getY() - 1);
        }
		ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
		img = ico.getImage();
		return img; 
	} 
}
