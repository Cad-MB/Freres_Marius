package items;

import java.awt.*;
import javax.swing.ImageIcon;
import mechanics.Main;

public class Item {

	private int width, height;
	private int x, y;
	
	protected Image imgObjet;
	protected ImageIcon icoObject;

	public Item(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

    public int getX() {return x;}

	public int getY() {return y;}

	public int getWidth() {return width;}

	public int getHeight() {return height;}
	
	public Image getImgObjet() {return imgObjet;}

	public void setX(int x) {this.x = x;}

	public void setY(int y) {this.y = y;}

	public void setWidth(int width) {this.width = width;}

	public void setHeight(int height) {this.height = height;}

	public void movement(){
		
		if(Main.level1Scene.getxPos() >= 0){
			this.x = this.x - Main.level1Scene.getDx();
		}
	}
	public void drawHitbox(Graphics g) {
		Color hitboxColor = new Color(255, 0, 0, 128);
		g.setColor(hitboxColor);
		g.drawRect(this.x, this.y, this.width, this.height);
	}
	
}
