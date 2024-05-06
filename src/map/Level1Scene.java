package map;

import characters.Enemy;
import characters.Player;
import items.Coin;
import items.Item;
import items.Platforms;
import mechanics.Keys;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Level1Scene extends JPanel {

	private final Image imgBR1;
	private final Image imgBR2;
	private int xBR1;
	private int xBR2;
	private int dx;
	private int xPos;
	private int yGrnd;
	private int heightUP;

	public Player player;

	public Platforms pipe1;
	public Platforms pipe2;
	public Platforms pipe3;
	public Platforms pipe4;
	public Platforms pipe5;
	public Platforms pipe6;
	public Platforms pipe7;

	public Platforms bloc1;
	public Platforms bloc2;
	public Platforms bloc3;
	public Platforms bloc4;
	public Platforms bloc5;
	public Platforms bloc6;
	public Platforms bloc7;
	public Platforms bloc8;
	public Platforms bloc9;
	public Platforms bloc10;
	public Platforms bloc11;
	public Platforms bloc12;

	public Coin coin1;
	public Coin coin2;
	public Coin coin3;
	public Coin coin4;
	public Coin coin5;
	public Coin coin6;
	public Coin coin7;
	public Coin coin8;
	public Coin coin9;
	public Coin coin10;
	public Coin coin11;
	public Coin coin12;
	public Coin coin13;
	public Coin coin14;
	public Coin coin15;

	public Enemy mushroom1;
	public Enemy mushroom2;
	public Enemy mushroom3;
	public Enemy mushroom4;
	public Enemy mushroom5;

	public Enemy turtle1;
	public Enemy turtle2;
	public Enemy turtle3;
	public Enemy turtle4;
	private final Image imgEnd;

	private final ArrayList<Item> tabItems;
	private final ArrayList<Coin> tabCoins;
	private final ArrayList<Enemy> tabTurtles;
	private final ArrayList<Enemy> tabMushrooms;

	private final HUB score;
	private final Font fontt;
	private final HUB time;

	public Level1Scene(){

		super();

		this.xBR1 = -50;
		this.xBR2 = 750;
		this.dx = 0;
		this.xPos = -1;
		this.yGrnd = 260;
		this.heightUP = 0;

		ImageIcon icoFond = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/BR.png")));
		this.imgBR1 = icoFond.getImage();
		this.imgBR2 = icoFond.getImage();

		player = new Player(250, 260);
		bloc1 = Platforms.createBloc(325, 180);
		coin1 = new Coin(365, 145);
		bloc2 = Platforms.createBloc(400, 180);
		coin2 = new Coin(440, 145);
		bloc3 = Platforms.createBloc(475, 180);

		pipe1 = Platforms.createPipe(600, 230);
		coin3 = new Coin(1020, 190);

		pipe2 = Platforms.createPipe(1000, 230);
		mushroom1 = new Enemy("Mushroom", 1300, 263);

		pipe3 = Platforms.createPipe(1600, 230);
		mushroom2 = new Enemy("Mushroom",1700, 263);
		mushroom3 = new Enemy("Mushroom",1800, 263);

		pipe4 = Platforms.createPipe(1900, 230);
		turtle1 = new Enemy("Turtle",2150, 243);
		bloc4 = Platforms.createBloc(2200, 180);
		coin4 = new Coin(2210, 140);
		turtle2 = new Enemy("Turtle",2350, 243);

		pipe5 = Platforms.createPipe(2500, 230);
		bloc5 = Platforms.createBloc(2665, 160);
		coin5 = new Coin(2675, 120);
		bloc6 = Platforms.createBloc(2835, 160);
		coin6 = new Coin(2845, 120);

		pipe6 = Platforms.createPipe(3000, 230);
		mushroom4 = new Enemy("Mushroom",3100, 263);
		turtle3 = new Enemy("Turtle",3300, 243);
		mushroom5 = new Enemy("Mushroom",3500, 263);
		turtle4 = new Enemy("Turtle",3700, 243);
		coin7 = new Coin(3350, 250);
		coin8 = new Coin(3450, 250);

		pipe7 = Platforms.createPipe(3800, 230);
		coin9 = new Coin(3900, 250);
		coin10 = new Coin(3950, 230);
		coin11 = new Coin(4000, 250);
		coin12 = new Coin(4050, 230);
		coin13 = new Coin(4100, 250);
		coin14 = new Coin(4150, 230);

		bloc7 = Platforms.createBloc(4170, 260);
		bloc8 = Platforms.createBloc(4236, 227);
		bloc9 = Platforms.createBloc(4302, 194);
		bloc10 = Platforms.createBloc(4368, 161);
		bloc11 = Platforms.createBloc(4434, 128);
		bloc12 = Platforms.createBloc(4500, 95);
		coin15 = new Coin(4570, 55);

		ImageIcon icoChateauFin = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/end.png")));
		this.imgEnd = icoChateauFin.getImage();


		tabItems = new ArrayList<>();
		this.tabItems.add(this.pipe1);
		this.tabItems.add(this.pipe2);
		this.tabItems.add(this.pipe3);
		this.tabItems.add(this.pipe4);
		this.tabItems.add(this.pipe5);
		this.tabItems.add(this.pipe6);
		this.tabItems.add(this.pipe7);

		this.tabItems.add(this.bloc1);
		this.tabItems.add(this.bloc2);
		this.tabItems.add(this.bloc3);
		this.tabItems.add(this.bloc4);
		this.tabItems.add(this.bloc5);
		this.tabItems.add(this.bloc6);
		this.tabItems.add(this.bloc7);
		this.tabItems.add(this.bloc8);
		this.tabItems.add(this.bloc9);
		this.tabItems.add(this.bloc10);
		this.tabItems.add(this.bloc11);
		this.tabItems.add(this.bloc12);

		tabCoins = new ArrayList<>();
		this.tabCoins.add(this.coin1);
		this.tabCoins.add(this.coin2);
		this.tabCoins.add(this.coin3);
		this.tabCoins.add(this.coin4);
		this.tabCoins.add(this.coin5);
		this.tabCoins.add(this.coin6);
		this.tabCoins.add(this.coin7);
		this.tabCoins.add(this.coin8);
		this.tabCoins.add(this.coin9);
		this.tabCoins.add(this.coin10);
		this.tabCoins.add(this.coin11);
		this.tabCoins.add(this.coin12);
		this.tabCoins.add(this.coin13);
		this.tabCoins.add(this.coin14);
		this.tabCoins.add(this.coin15);

		tabMushrooms = new ArrayList<>();
		this.tabMushrooms.add(this.mushroom1);
		this.tabMushrooms.add(this.mushroom2);
		this.tabMushrooms.add(this.mushroom3);
		this.tabMushrooms.add(this.mushroom4);
		this.tabMushrooms.add(this.mushroom5);

		tabTurtles = new ArrayList<>();
		this.tabTurtles.add(this.turtle1);
		this.tabTurtles.add(this.turtle2);
		this.tabTurtles.add(this.turtle3);
		this.tabTurtles.add(this.turtle4);

		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Keys());

		score = new HUB();
		fontt = new Font("Arial", Font.PLAIN, 18);
		time = new HUB();

		HUB hub = new HUB();
		Thread chronoEcran = new Thread(hub);
		chronoEcran.start();

	}

	public int getDx() {return dx;}

	public int getxPos() {return xPos;}

	public int getyGrnd() {return yGrnd;}

	public int getHautPlafond(){return heightUP;}

	public void setDx(int dx) {this.dx = dx;}

	public void setxPos(int xPos) {this.xPos = xPos;}

	public void setyGrnd(int yGrnd) {this.yGrnd = yGrnd;}

	public void setHautPlafond(int hauteurPlafond) {this.heightUP = hauteurPlafond;}

	public void setxBR1(int xBR1) {this.xBR1 = xBR1;}

	public void setxBR2(int xBR2) {this.xBR2 = xBR2;}

	public void deplacementFond(){

		if(this.xPos >= 0 && this.xPos <= 4430){
			this.xPos = this.xPos + this.dx;
			this.xBR1 = this.xBR1 - this.dx;
			this.xBR2 = this.xBR2 - this.dx;
		}
		if(this.xBR1 == -800){this.xBR1 = 800;}
		else if(this.xBR2 == -800){this.xBR2 = 800;}
		else if(this.xBR1 == 800){this.xBR1 = -800;}
		else if(this.xBR2 == 800){this.xBR2 = -800;}
	}

	private boolean partieGagnee(){
		return this.time.getCountTime() > 0 && this.player.isAlive() && this.score.getNbrCoins() == 15
				&& this.xPos > 4400;
	}

	private boolean partiePerdue(){
		return !this.player.isAlive() || this.time.getCountTime() <= 0;
	}

	public boolean finDePartie(){
		return this.partieGagnee() || this.partiePerdue();
	}


	public void paintComponent(Graphics g) {

		super.paintComponent(g);


		for (Item item : this.tabItems) {
			if (this.player.nearr(item)) {
				this.player.contact(item);
			}
			for (Enemy tabMushroom : this.tabMushrooms) {
				if (tabMushroom.nearr(item)) {
					tabMushroom.contact(item);
				}
			}
			for (Enemy tabTurtle : this.tabTurtles) {
				if (tabTurtle.nearr(item)) {
					tabTurtle.contact(item);
				}
			}
		}

		for(int i = 0; i < this.tabCoins.size(); i++){
			if(this.player.nearr(this.tabCoins.get(i))){
				if(this.player.contactCoin(this.tabCoins.get(i))){
					this.tabCoins.remove(i);
					this.score.setNbrCoins(this.score.getNbrCoins() + 1);
				}
			}
		}

		for(int i = 0; i < this.tabMushrooms.size(); i++){
			for(int j = 0; j < this.tabMushrooms.size(); j++){
				if(j != i){
					if(this.tabMushrooms.get(j).nearr(this.tabMushrooms.get(i))){this.tabMushrooms.get(j).contact(this.tabMushrooms.get(i));}
				}
			}
			for (Enemy tabTurtle : this.tabTurtles) {
				if (tabTurtle.nearr(this.tabMushrooms.get(i))) {
					tabTurtle.contact(this.tabMushrooms.get(i));
				}
			}
		}

		for(int i = 0; i < this.tabTurtles.size(); i++){
			for (Enemy tabMushroom : this.tabMushrooms) {
				if (tabMushroom.nearr(this.tabTurtles.get(i))) {
					tabMushroom.contact(this.tabTurtles.get(i));
				}
			}
			for(int j = 1; j < this.tabTurtles.size(); j++){
				if(j != i){
					if(this.tabTurtles.get(j).nearr(this.tabTurtles.get(i))){this.tabTurtles.get(j).contact(this.tabTurtles.get(i));}
				}
			}
		}

		for (Enemy mushroom : this.tabMushrooms) {
			if (this.player.nearr(mushroom) && mushroom.isAlive()) {
				this.player.contact(mushroom);
			}
		}
		for (Enemy turtle : this.tabTurtles) {
			if (this.player.nearr(turtle) && turtle.isAlive()) {
				this.player.contact(turtle);
			}
		}

		this.deplacementFond();

		if(this.xPos >= 0 && this.xPos <= 4430){
			for (Item tabItem : this.tabItems) {
				tabItem.movement();
			}
			for (Coin tabCoin : this.tabCoins) {
				tabCoin.movement();
			}
			for (Enemy tabMushroom : this.tabMushrooms) {
				tabMushroom.movement();
			}
			for (Enemy tabTurtle : this.tabTurtles) {
				tabTurtle.movement();
			}
		}

		g.drawImage(this.imgBR1, this.xBR1, 0, null);
		g.drawImage(this.imgBR2, this.xBR2, 0, null);

		for (Item tabItem : this.tabItems) {
			g.drawImage(tabItem.getImgObjet(), tabItem.getX(), tabItem.getY(), null);
		}

		for (Coin tabCoin : this.tabCoins) {
			g.drawImage(tabCoin.move(), tabCoin.getX(), tabCoin.getY(), null);
		}

		g.drawImage(imgEnd, 4800 - this.xPos, 117, null);

		if(this.player.isAlive()){
			if(this.player.isJump()){
				g.drawImage(this.player.jump(), this.player.getX(), this.player.getY(), null);}
			else{
				g.drawImage(this.player.walk("marius", 25), this.player.getX(), this.player.getY(), null);}
		}else{
			g.drawImage(this.player.death(), this.player.getX(), this.player.getY(), null);}

		for (Enemy tabMushroom : this.tabMushrooms) {
			if (tabMushroom.isAlive()) {
				g.drawImage(tabMushroom.walk("mush", 45), tabMushroom.getX(), tabMushroom.getY(), null);
			} else {
				g.drawImage(tabMushroom.death(), tabMushroom.getX(), tabMushroom.getY() + 20, null);
			}
		}

		for (Enemy tabTurtle : this.tabTurtles) {
			if (tabTurtle.isAlive()) {
				g.drawImage(tabTurtle.walk("turt", 50), tabTurtle.getX(), tabTurtle.getY(), null);
			} else {
				g.drawImage(tabTurtle.death(), tabTurtle.getX(), tabTurtle.getY() + 30, null);
			}
		}
		g.setFont(fontt);
		g.drawString(STR."\{this.score.getNbrCoins()} Coin(s) / \{this.score.getNbrTotalCoins()}", 460, 25);

		g.drawString(this.time.getStr(), 5, 25);

//		if (this.player != null) {
//			g.drawImage(this.player.getImgMario(), this.player.getX(), this.player.getY(), null);
//			this.player.drawHitbox(g); // Draw hitbox for player
//		}
//
//		// Integrate for all enemies
//		for (Enemy enemy : this.tabMushrooms) {
//			g.drawImage(enemy.getImgEnemy(), enemy.getX(), enemy.getY(), null);
//			enemy.drawHitbox(g); // Draw hitbox for each enemy
//		}
//
//		for (Enemy enemy : this.tabTurtles) {
//			g.drawImage(enemy.getImgEnemy(), enemy.getX(), enemy.getY(), null);
//			enemy.drawHitbox(g); // Draw hitbox for each enemy
//		}
//
//		// Integrate for items like coins
//		for (Coin coin : this.tabCoins) {
//			g.drawImage(coin.getImgObjet(), coin.getX(), coin.getY(), null);
//			coin.drawHitbox(g); // Draw hitbox for each coin
//		}
//
//		for (Item items : this.tabItems) {
//			g.drawImage(items.getImgObjet(), items.getX(), items.getY(), null);
//			items.drawHitbox(g); // Draw hitbox for each coin
//		}

		if (this.finDePartie()) {
			Font policeFin = new Font("Arial", Font.BOLD, 50);
			g.setFont(policeFin);
			if (this.partieGagnee()) {
				g.drawString("Win", 250, 180);
			} else {
				g.drawString("Death", 250, 180);
			}
		}
	}

}