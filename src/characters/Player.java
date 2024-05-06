package characters;

import java.awt.Image;
import java.util.Objects;

import javax.swing.ImageIcon;

import items.Item;
import mechanics.Main;
import items.Coin;

public class Player extends Character {


	private final Image imgMarius;
    private boolean jump;
    private int countJump;
    private int countDeath;

	public Player(int x, int y) {

	super(x, y, 28, 30);
        ImageIcon icoMario = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/mariusWalkR.png")));
	this.imgMarius = icoMario.getImage();
	
	this.jump = false;
	this.countJump = 0;
	this.countDeath = 0;
	}

	public Image getImgMarius() {return imgMarius;}

	public boolean isJump() {return jump;}

	public void setJump(boolean jump) {this.jump = jump;}

	@Override
	public Image walk(String nom, int frequence) {
    	String str;
    	ImageIcon ico;
		Image img;
		if (!this.walk || Main.level1Scene.getxPos() <= 0 || Main.level1Scene.getxPos() > 4430) {
			if(this.toRight){str = STR."src/images/\{nom}NormalR.png";}
			else{str = STR."src/images/\{nom}NormalL.png";}
		}else{
		    this.count++;
		    if (this.count / frequence == 0) {
		    	if(this.toRight){str = STR."src/images/\{nom}NormalR.png";}
		    	else{str = STR."src/images/\{nom}NormalL.png";}
		    }else{
		    	if(this.toRight){str = STR."src/images/\{nom}WalkR.png";}
		    	else{str = STR."src/images/\{nom}WalkL.png";}
		    }
		    if (this.count == 2 * frequence) {this.count = 0;}
		}

		ico = new ImageIcon(str);
		img = ico.getImage();
		return img;
	}

    public Image jump(){
	    ImageIcon ico;
	    Image img;
	    String str;
	
		this.countJump++;
		if(this.countJump <= 40){
			if(this.getY() > Main.level1Scene.getHautPlafond()){this.setY(this.getY() - 4);}
			else{this.countJump = 41;}
			if(this.isToRight()){str = "/images/mariusJumpR.png";}
			else{str = "/images/mariusJumpL.png";}
			
		}else if(this.getY() + this.getHeight() < Main.level1Scene.getyGrnd()){this.setY(this.getY() + 1);
			if(this.isToRight()){str = "/images/mariusJumpR.png";}
			else{str = "/images/mariusJumpL.png";}
			
		}else{
			if(this.isToRight()){str = "/images/mariusNormalR.png";}
			else{str = "/images/mariusNormalL.png";}
			this.jump = false;
			this.countJump = 0;
		}
		ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
		img = ico.getImage();
		return img;
	}
    
	public void contact(Item item) {
		if((super.contactAhead(item) && this.isToRight()) || (super.contactBehind(item) && !this.isToRight())){
			Main.level1Scene.setDx(0);
		    this.setWalk(false);
		}
        if(super.contactDown(item) && this.jump){
			Main.level1Scene.setyGrnd(item.getY());
		}else if(!super.contactDown(item)){
			Main.level1Scene.setyGrnd(293);
			if(!this.jump){this.setY(260);}
		}
        if(super.contactUp(item)){
			Main.level1Scene.setHautPlafond(item.getY() + item.getHeight());
		}else if(!super.contactUp(item) && !this.jump){
			Main.level1Scene.setHautPlafond(0);
		}     
	}
	
	public boolean contactCoin(Coin coin){
        return this.contactBehind(coin) || this.contactAhead(coin) || this.contactDown(coin) ||
                this.contactUp(coin);
	}	

	public void contact(Character character) {
		if((super.contactAhead(character)) || (super.contactBehind(character))){
			this.setWalk(false);
		    this.setAlive(false);
		}else if(super.contactDown(character)){
			character.setWalk(false);
			character.setAlive(false);
		}
    }
	
	public Image death(){
		String str;
    	ImageIcon ico;
		Image img;	
		
        str = "/images/death.png";
        this.countDeath++;
        if(this.countDeath > 100){
        	str = "/images/mariusDeath.png";
        	this.setY(this.getY() - 1);
        }
		ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
		img = ico.getImage();
		return img; 
	} 
}
