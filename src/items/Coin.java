package items;

import java.awt.Image;
import java.util.Objects;
import javax.swing.ImageIcon;

public class Coin extends Item implements Runnable{

	private int count;

    public Coin(int x, int y){
	    super(x, y, 15, 30);
	    
	    super.icoObject = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/coin1.png")));
	    super.imgObjet = super.icoObject.getImage();
    }

    public Image move(){
    	String str;
    	ImageIcon ico;
		Image img;
			
        this.count++;
		if (this.count / 100 == 0) {str = "/images/coin1.png";}
		else{str = "/images/coin2.png";}
		if (this.count == 200) {this.count = 0;}

		ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
		img = ico.getImage();
		return img;   	
	}

	@Override
	public void run() {
		try{Thread.sleep(20);}
		catch (InterruptedException _){}
			
		while(true){
			this.move();
			try{
                int PAUSE = 15;
                Thread.sleep(PAUSE);}
			catch (InterruptedException _){}
		}			
	}
}
