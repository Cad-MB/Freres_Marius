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
	protected boolean walk;
	protected boolean toRight;
	public int count;
	protected boolean alive;

	public Character(int x, int y, int width, int height){
				
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.count = 0;
		this.walk = false;
		this.toRight = true;
		this.alive = true;
	}

	public int getX() {return x;}

	public int getY() {return y;}

    public int getWidth() {return width;}
	
	public int getHeight() {return height;}

	public boolean isWalk() {return walk;}

	public boolean isToRight() {return toRight;}

	public int getCount() {return count;}
	
	public boolean isAlive() {return alive;}

	public void setX(int x) {this.x = x;}

	public void setY(int y) {this.y = y;}
	
	public void setWalk(boolean walk) {this.walk = walk;}
	
	public void setToRight(boolean toRight) {this.toRight = toRight;}

	public void setCount(int count) {this.count = count;}
	
	public void setAlive(boolean alive) {this.alive = alive;}

	public Image walk(String nom, int frequence){
		String str;
		ImageIcon ico;
		Image img;		
		if(!this.walk){
			if(this.toRight){str = STR."/images/\{nom}NormalR.png";}
			else{str = STR."/images/\{nom}NormalL.png";}
		}else{
			this.count++;
			if(this.count / frequence == 0){
				if(this.toRight){str = STR."/images/\{nom}NormalR.png";}
				else{str = STR."/images/\{nom}NormalL.png";}
			}else{
				if(this.toRight){str = STR."/images/\{nom}WalkR.png";}
				else{str = STR."/images/\{nom}WalkL.png";}
			}
			if(this.count == 2 * frequence){this.count = 0;}
		}

		ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
		img = ico.getImage();
		return img;
	}
    
	public void movement(){
		if(Main.level1Scene.getxPos() >= 0){this.x = this.x - Main.level1Scene.getDx();}
	}

    protected boolean contactAhead(Item item){
        return this.x + this.width >= item.getX() && this.x + this.width <= item.getX() + 5 &&
                this.y + this.height > item.getY() && this.y < item.getY() + item.getHeight();
	} 

    protected boolean contactBehind(Item item){
        return this.x <= item.getX() + item.getWidth() && this.x + this.width >= item.getX() + item.getWidth() - 5 &&
                this.y + this.height > item.getY() && this.y < item.getY() + item.getHeight();
	}

    protected boolean contactDown(Item item){
        return this.x + this.width >= item.getX() + 5 && this.x <= item.getX() + item.getWidth() - 5 &&
                this.y + this.height >= item.getY() && this.y + this.height <= item.getY() + 5;
	}

    protected boolean contactUp(Item item){
        return this.x + this.width >= item.getX() + 5 && this.x <= item.getX() + item.getWidth() - 5 &&
                this.y >= item.getY() + item.getHeight() && this.y <= item.getY() + item.getHeight() + 5;
	}   
    
    public boolean nearr(Item item){
        return (this.x > item.getX() - 10 && this.x < item.getX() + item.getWidth() + 10)
                || (this.x + this.width > item.getX() - 10 && this.x + this.width < item.getX() + item.getWidth() + 10);
    }

    protected boolean contactAhead(Character character){
		if(this.isToRight()){
            return this.x + this.width >= character.getX() && this.x + this.width <= character.getX() + 5 &&
                    this.y + this.height > character.getY() && this.y < character.getY() + character.getHeight();
		}else{return false;}
	} 
    
    protected boolean contactBehind(Character character){
        return this.x <= character.getX() + character.getWidth() && this.x + this.width >= character.getX() + character.getWidth() - 5 &&
                this.y + this.height > character.getY() && this.y < character.getY() + character.getHeight();
	}
    
    protected boolean contactDown(Character character){
        return this.x + this.width >= character.getX() && this.x <= character.getX() + character.getWidth() &&
                this.y + this.height >= character.getY() && this.y + this.height <= character.getY();
	}
    
    public boolean nearr(Character character){
        return (this.x > character.getX() - 10 && this.x < character.getX() + character.getWidth() + 10)
                || (this.x + this.width > character.getX() - 10 && this.x + this.width < character.getX() + character.getWidth() + 10);
    }
	// Method to draw hitbox for debugging
	public void drawHitbox(Graphics g) {
		Color hitboxColor = new Color(255, 0, 0, 128);
		g.setColor(hitboxColor);
		g.drawRect(this.x, this.y, this.width, this.height);
	}
    
}
