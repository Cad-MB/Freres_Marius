package items;

import java.awt.Image;
import java.util.Objects;
import javax.swing.ImageIcon;

public class Coin extends Item implements Runnable{

	private int compteur;

    public Coin(int x, int y){
	    super(x, y, 15, 30);
	    
	    super.icoObjet = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/coin1.png")));
	    super.imgObjet = super.icoObjet.getImage();
    }

    public Image bouge(){
    	String str;
    	ImageIcon ico;
		Image img;
			
        this.compteur++;
		if (this.compteur / 100 == 0) {str = "/images/coin1.png";}
		else{str = "/images/coin2.png";}
		if (this.compteur == 200) {this.compteur = 0;}

		ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
		img = ico.getImage();
		return img;   	
	}

	@Override
	public void run() {
		try{Thread.sleep(20);}
		catch (InterruptedException _){}
			
		while(true){
			this.bouge();
			try{
                int PAUSE = 15;
                Thread.sleep(PAUSE);}
			catch (InterruptedException _){}
		}			
	}
}
