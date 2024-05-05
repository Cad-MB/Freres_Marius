package characters;

import java.awt.Image;
import java.util.Objects;

import javax.swing.ImageIcon;

import items.Item;

public class Mushroom extends Character implements Runnable{
	
	private final Image imgChamp;

    private int dxChamp;
	
	

	public Mushroom(int x, int y) {
		
		super(x, y, 27, 30);
		super.setVersDroite(true);
		super.setMarche(true);
		this.dxChamp = 1;

        ImageIcon icoChamp = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/mushNormalR.png")));
		this.imgChamp = icoChamp.getImage();
		
		Thread chronoChamp = new Thread(this);
		chronoChamp.start();
	}

	public Image getImgChamp() {return imgChamp;}

	public void bouge(){
    	if(super.isVersDroite()){this.dxChamp = 1;}
    	else{this.dxChamp = -1;}
        super.setX(super.getX() + this.dxChamp);  	
    }
	
	@Override
	public void run() {
		try{Thread.sleep(20);}
		catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
		
		while(true){
			if(this.vivant){
		    this.bouge();
		    try{
                int PAUSE = 15;
                Thread.sleep(PAUSE);}
			catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
			}
		}
	}
	
	public void contact(Item item) {
		if(super.contactAvant(item) && this.isVersDroite()){
            super.setVersDroite(false);
	    	this.dxChamp = -1; 
	    }else if(super.contactArriere(item) && !this.isVersDroite()){
	    	super.setVersDroite(true);
	    	this.dxChamp = 1;     
	    }	
	}
	
	public void contact(Character character) {
	    if(super.contactAvant(character) && this.isVersDroite()){
            super.setVersDroite(false);
    	    this.dxChamp = -1; 
        }else if(super.contactArriere(character) && !this.isVersDroite()){
    	    super.setVersDroite(true);
    	    this.dxChamp = 1;     
        }	
    }
	
	public Image meurt(){		
		String str;
    	ImageIcon ico;
		Image img;	
		
        if(this.isVersDroite()){str = "/images/mushDeathlR.png";}
        else{str = "/images/mushDeathlL.png.png";}
		ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
		img = ico.getImage();
		return img; 
	} 
}
