package characters;

import java.awt.*;
import java.util.Objects;

import javax.swing.ImageIcon;

import items.Item;
import mechanics.Main;

public class Character {


	private final int width;
    private final int height;
	private int x, y;
	protected boolean marche;
	protected boolean versDroite;
	public int compteur;
	protected boolean vivant;

	public Character(int x, int y, int width, int height){
				
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.compteur = 0;
		this.marche = false;
		this.versDroite = true;	
		this.vivant = true;
	}

	public int getX() {return x;}

	public int getY() {return y;}

    public int getWidth() {return width;}
	
	public int getHeight() {return height;}

	public boolean isMarche() {return marche;}

	public boolean isVersDroite() {return versDroite;}

	public int getCompteur() {return compteur;}
	
	public boolean isVivant() {return vivant;}

	public void setX(int x) {this.x = x;}

	public void setY(int y) {this.y = y;}
	
	public void setMarche(boolean marche) {this.marche = marche;}
	
	public void setVersDroite(boolean versDroite) {this.versDroite = versDroite;}

	public void setCompteur(int compteur) {this.compteur = compteur;}
	
	public void setVivant(boolean vivant) {this.vivant = vivant;}

	public Image marche(String nom, int frequence){
		String str;
		ImageIcon ico;
		Image img;		
		if(!this.marche){
			if(this.versDroite){str = STR."/images/\{nom}NormalR.png";}
			else{str = STR."/images/\{nom}NormalL.png";}
		}else{
			this.compteur++;
			if(this.compteur / frequence == 0){
				if(this.versDroite){str = STR."/images/\{nom}NormalR.png";}
				else{str = STR."/images/\{nom}NormalL.png";}
			}else{
				if(this.versDroite){str = STR."/images/\{nom}WalkR.png";}
				else{str = STR."/images/\{nom}WalkL.png";}
			}
			if(this.compteur == 2 * frequence){this.compteur = 0;}
		}

		ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
		img = ico.getImage();
		return img;
	}
    
	public void deplacement(){		
		if(Main.level1Scene.getxPos() >= 0){this.x = this.x - Main.level1Scene.getDx();}
	}

    protected boolean contactAvant(Item item){
        return this.x + this.width >= item.getX() && this.x + this.width <= item.getX() + 5 &&
                this.y + this.height > item.getY() && this.y < item.getY() + item.getHeight();
	} 

    protected boolean contactArriere(Item item){
        return this.x <= item.getX() + item.getWidth() && this.x + this.width >= item.getX() + item.getWidth() - 5 &&
                this.y + this.height > item.getY() && this.y < item.getY() + item.getHeight();
	}

    protected boolean contactDessous(Item item){
        return this.x + this.width >= item.getX() + 5 && this.x <= item.getX() + item.getWidth() - 5 &&
                this.y + this.height >= item.getY() && this.y + this.height <= item.getY() + 5;
	}

    protected boolean contactDessus(Item item){
        return this.x + this.width >= item.getX() + 5 && this.x <= item.getX() + item.getWidth() - 5 &&
                this.y >= item.getY() + item.getHeight() && this.y <= item.getY() + item.getHeight() + 5;
	}   
    
    public boolean proche(Item item){
        return (this.x > item.getX() - 10 && this.x < item.getX() + item.getWidth() + 10)
                || (this.x + this.width > item.getX() - 10 && this.x + this.width < item.getX() + item.getWidth() + 10);
    }

    protected boolean contactAvant(Character character){
		if(this.isVersDroite()){
            return this.x + this.width >= character.getX() && this.x + this.width <= character.getX() + 5 &&
                    this.y + this.height > character.getY() && this.y < character.getY() + character.getHeight();
		}else{return false;}
	} 
    
    protected boolean contactArriere(Character character){
        return this.x <= character.getX() + character.getWidth() && this.x + this.width >= character.getX() + character.getWidth() - 5 &&
                this.y + this.height > character.getY() && this.y < character.getY() + character.getHeight();
	}
    
    protected boolean contactDessous(Character character){
        return this.x + this.width >= character.getX() && this.x <= character.getX() + character.getWidth() &&
                this.y + this.height >= character.getY() && this.y + this.height <= character.getY();
	}
    
    public boolean proche(Character character){
        return (this.x > character.getX() - 10 && this.x < character.getX() + character.getWidth() + 10)
                || (this.x + this.width > character.getX() - 10 && this.x + this.width < character.getX() + character.getWidth() + 10);
    }
	// Method to draw hitbox for debugging
	public void drawHitbox(Graphics g) {
		Color hitboxColor = new Color(255, 0, 0, 128); // Red with 50% transparency
		g.setColor(hitboxColor);
		g.drawRect(this.x, this.y, this.width, this.height);
	}
    
}
