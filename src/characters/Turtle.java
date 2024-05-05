package characters;

import java.awt.Image;

import javax.swing.ImageIcon;

import items.Item;

public class Turtle extends Character implements Runnable{

	private Image imgTortue;
	private ImageIcon icoTortue;
	
	private final int PAUSE = 15; // temps d'attente en ms entre 2 tours de boucle
	private int dxTortue; // pas de d�placement de la tortue
	
	//**** CONSTRUCTEUR	****//
	public Turtle(int x, int y) {
			
		super(x, y, 43, 50);
		super.setVersDroite(true);
		super.setMarche(true);
		this.dxTortue = 1;
			
		this.icoTortue = new ImageIcon(getClass().getResource("/images/turtNormalL.png"));
		this.imgTortue = this.icoTortue.getImage();
			
		Thread chronoChamp = new Thread(this);
		chronoChamp.start();
		}
	//**** GETTERS ****//		
	public Image getImgTortue() {return imgTortue;}

			
	//**** SETTERS ****//
			
			
	//**** METHODES ****//	
	public void bouge(){ // D�placement de la tortue
	    if(super.isVersDroite() == true){this.dxTortue = 1;}
	    else{this.dxTortue = -1;}
	    super.setX(super.getX() + this.dxTortue);  	
	}
	
	@Override
	public void run() {
		try{Thread.sleep(20);} // on attend 20 ms avant d'appeler bouge pour que tous les items soient compl�tement cr��s
		catch (InterruptedException e){}		
		
		while(true){ // boucle infinie
			if(this.vivant == true){
		    this.bouge();
		    try{Thread.sleep(PAUSE);}
			catch (InterruptedException e){}
			}
		}
	}
	

	public void contact(Item item) {
		if(super.contactAvant(item) == true && this.isVersDroite() == true){
            super.setVersDroite(false);
	    	this.dxTortue = -1; 
	    }else if(super.contactArriere(item) == true && this.isVersDroite() == false){
	    	super.setVersDroite(true);
	    	this.dxTortue = 1;     
	    }	
	}
	
	public void contact(Character character) {
	    if(super.contactAvant(character) == true && this.isVersDroite() == true){
            super.setVersDroite(false);
    	    this.dxTortue = -1; 
        }else if(super.contactArriere(character) == true && this.isVersDroite() == false){
    	    super.setVersDroite(true);
    	    this.dxTortue = 1;     
        }	
    }
	
    public Image meurt(){		
		String str;
    	ImageIcon ico;
		Image img;	
		
        str = "/images/turtDeath.png";
        ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}
}
