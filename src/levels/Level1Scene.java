package levels;

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

	private final Image imgFond1;
	private final Image imgFond2;
	private int xFond1;
	private int xFond2;
	private int dx;
	private int xPos;
	private int ySol;
	private int hauteurPlafond;

	public Player player;

	public Platforms pipe1;
	public Platforms pipe2;
	public Platforms pipe3;
	public Platforms pipe4;
	public Platforms pipe5;
	public Platforms pipe6;
	public Platforms pipe7;
	public Platforms pipe8;

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

	public Enemy mushroom1;
	public Enemy mushroom2;
	public Enemy mushroom3;
	public Enemy mushroom4;
	public Enemy mushroom5;
	public Enemy mushroom6;
	public Enemy mushroom7;
	public Enemy mushroom8;

	public Enemy turtle1;
	public Enemy turtle2;
	public Enemy turtle3;
	public Enemy turtle4;
	public Enemy turtle5;
	public Enemy turtle6;
	public Enemy turtle7;
	public Enemy turtle8;
	public Enemy turtle9;

	private final Image imgDrapeau;
	private final Image imgChateauFin;

	private final ArrayList<Item> tabItems;
	private final ArrayList<Coin> tabCoins;
	private final ArrayList<Enemy> tabTurtles;
	private final ArrayList<Enemy> tabMushrooms;

	private final HUB score;
	private final Font police;
	private final HUB time;

	public Level1Scene(){

		super();

		this.xFond1 = -50;
		this.xFond2 = 750;
		this.dx = 0;
		this.xPos = -1;
		this.ySol = 260;
		this.hauteurPlafond = 0;

		ImageIcon icoFond = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/BR.png")));
		this.imgFond1 = icoFond.getImage();
		this.imgFond2 = icoFond.getImage();

		player = new Player(300, 260);

		pipe1 = Platforms.createPipe(600, 230);
		pipe2 = Platforms.createPipe(1000, 230);
		pipe3 = Platforms.createPipe(1600, 230);
		pipe4 = Platforms.createPipe(1900, 230);
		pipe5 = Platforms.createPipe(2500, 230);
		pipe6 = Platforms.createPipe(3000, 230);
		pipe7 = Platforms.createPipe(3800, 230);
		pipe8 = Platforms.createPipe(4500, 230);

		bloc1 = Platforms.createBloc(400, 180);
		bloc2 = Platforms.createBloc(1200, 180);
		bloc3 = Platforms.createBloc(1270, 170);
		bloc4 = Platforms.createBloc(1340, 160);
		bloc5 = Platforms.createBloc(2000, 180);
		bloc6 = Platforms.createBloc(2600, 160);
		bloc7 = Platforms.createBloc(2650, 180);
		bloc8 = Platforms.createBloc(3500, 160);
		bloc9 = Platforms.createBloc(3550, 140);
		bloc10 = Platforms.createBloc(4000, 170);
		bloc11 = Platforms.createBloc(4200, 200);
		bloc12 = Platforms.createBloc(4300, 210);

		coin1 = new Coin(402, 145);
		coin2 = new Coin(1202, 140);
		coin3 = new Coin(1272, 95);
		coin4 = new Coin(1342, 40);
		coin5 = new Coin(1650, 145);
		coin6 = new Coin(2650, 145);
		coin7 = new Coin(3000, 135);
		coin8 = new Coin(3400, 125);
		coin9 = new Coin(4200, 145);
		coin10 = new Coin(4600, 40);

		mushroom1 = new Enemy("Mushroom", 800, 263);
		mushroom2 = new Enemy("Mushroom",1100, 263);
		mushroom3 = new Enemy("Mushroom",2100, 263);
		mushroom4 = new Enemy("Mushroom",2400, 263);
		mushroom5 = new Enemy("Mushroom",3200, 263);
		mushroom6 = new Enemy("Mushroom",3500, 263);
		mushroom7 = new Enemy("Mushroom",3700, 263);
		mushroom8 = new Enemy("Mushroom",4500, 263);

		turtle1 = new Enemy("Turtle",950, 243);
		turtle2 = new Enemy("Turtle",1500, 243);
		turtle3 = new Enemy("Turtle",1800, 243);
		turtle4 = new Enemy("Turtle",2400, 243);
		turtle5 = new Enemy("Turtle",3100, 243);
		turtle6 = new Enemy("Turtle",3600, 243);
		turtle7 = new Enemy("Turtle",3900, 243);
		turtle8 = new Enemy("Turtle",4200, 243);
		turtle9 = new Enemy("Turtle",4400, 243);

		ImageIcon icoChateauFin = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/end.png")));
		this.imgChateauFin = icoChateauFin.getImage();

		ImageIcon icoDrapeau = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/flag.png")));
		this.imgDrapeau = icoDrapeau.getImage();

		tabItems = new ArrayList<>();
		this.tabItems.add(this.pipe1);
		this.tabItems.add(this.pipe2);
		this.tabItems.add(this.pipe3);
		this.tabItems.add(this.pipe4);
		this.tabItems.add(this.pipe5);
		this.tabItems.add(this.pipe6);
		this.tabItems.add(this.pipe7);
		this.tabItems.add(this.pipe8);

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

		tabMushrooms = new ArrayList<>();
		this.tabMushrooms.add(this.mushroom1);
		this.tabMushrooms.add(this.mushroom2);
		this.tabMushrooms.add(this.mushroom3);
		this.tabMushrooms.add(this.mushroom4);
		this.tabMushrooms.add(this.mushroom5);
		this.tabMushrooms.add(this.mushroom6);
		this.tabMushrooms.add(this.mushroom7);
		this.tabMushrooms.add(this.mushroom8);

		tabTurtles = new ArrayList<>();
		this.tabTurtles.add(this.turtle1);
		this.tabTurtles.add(this.turtle2);
		this.tabTurtles.add(this.turtle3);
		this.tabTurtles.add(this.turtle4);
		this.tabTurtles.add(this.turtle5);
		this.tabTurtles.add(this.turtle6);
		this.tabTurtles.add(this.turtle7);
		this.tabTurtles.add(this.turtle8);
		this.tabTurtles.add(this.turtle9);

		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Keys());

		score = new HUB();
		police = new Font("Arial", Font.PLAIN, 18);
		time = new HUB();

		// Creation and initiation of the HUB instance
		HUB hub = new HUB();
		Thread chronoEcran = new Thread(hub);
		chronoEcran.start();  // Starting the thread to manage both the timer and repaint actions

	}

	public int getDx() {return dx;}

	public int getxPos() {return xPos;}

	public int getySol() {return ySol;}

	public int getHautPlafond(){return hauteurPlafond;}

	public void setDx(int dx) {this.dx = dx;}

	public void setxPos(int xPos) {this.xPos = xPos;}

	public void setySol(int ySol) {this.ySol = ySol;}

	public void setHautPlafond(int hauteurPlafond) {this.hauteurPlafond = hauteurPlafond;}

	public void setxFond1(int xFond1) {this.xFond1 = xFond1;}

	public void setxFond2(int xFond2) {this.xFond2 = xFond2;}

	public void deplacementFond(){

		if(this.xPos >= 0 && this.xPos <= 4430){
			this.xPos = this.xPos + this.dx;
			this.xFond1 = this.xFond1 - this.dx;
			this.xFond2 = this.xFond2 - this.dx;
		}
		if(this.xFond1 == -800){this.xFond1 = 800;}
		else if(this.xFond2 == -800){this.xFond2 = 800;}
		else if(this.xFond1 == 800){this.xFond1 = -800;}
		else if(this.xFond2 == 800){this.xFond2 = -800;}
	}

	private boolean partieGagnee(){
		return this.time.getCompteurTemps() > 0 && this.player.isVivant() && this.score.getNbrePieces() == 10
				&& this.xPos > 4400;
	}

	private boolean partiePerdue(){
		return !this.player.isVivant() || this.time.getCompteurTemps() <= 0;
	}

	public boolean finDePartie(){
		return this.partieGagnee() || this.partiePerdue();
	}


	public void paintComponent(Graphics g) {

		super.paintComponent(g);


		for (Item item : this.tabItems) {
			if (this.player.proche(item)) {
				this.player.contact(item);
			}
			for (Enemy tabMushroom : this.tabMushrooms) {
				if (tabMushroom.proche(item)) {
					tabMushroom.contact(item);
				}
			}
			for (Enemy tabTurtle : this.tabTurtles) {
				if (tabTurtle.proche(item)) {
					tabTurtle.contact(item);
				}
			}
		}

		for(int i = 0; i < this.tabCoins.size(); i++){
			if(this.player.proche(this.tabCoins.get(i))){
				if(this.player.contactPiece(this.tabCoins.get(i))){
					this.tabCoins.remove(i);
					this.score.setNbrePieces(this.score.getNbrePieces() + 1);
				}
			}
		}

		for(int i = 0; i < this.tabMushrooms.size(); i++){
			for(int j = 0; j < this.tabMushrooms.size(); j++){
				if(j != i){
					if(this.tabMushrooms.get(j).proche(this.tabMushrooms.get(i))){this.tabMushrooms.get(j).contact(this.tabMushrooms.get(i));}
				}
			}
			for (Enemy tabTurtle : this.tabTurtles) {
				if (tabTurtle.proche(this.tabMushrooms.get(i))) {
					tabTurtle.contact(this.tabMushrooms.get(i));
				}
			}
		}

		for(int i = 0; i < this.tabTurtles.size(); i++){
			for (Enemy tabMushroom : this.tabMushrooms) {
				if (tabMushroom.proche(this.tabTurtles.get(i))) {
					tabMushroom.contact(this.tabTurtles.get(i));
				}
			}
			for(int j = 1; j < this.tabTurtles.size(); j++){
				if(j != i){
					if(this.tabTurtles.get(j).proche(this.tabTurtles.get(i))){this.tabTurtles.get(j).contact(this.tabTurtles.get(i));}
				}
			}
		}

		for (Enemy mushroom : this.tabMushrooms) {
			if (this.player.proche(mushroom) && mushroom.isVivant()) {
				this.player.contact(mushroom);
			}
		}
		for (Enemy turtle : this.tabTurtles) {
			if (this.player.proche(turtle) && turtle.isVivant()) {
				this.player.contact(turtle);
			}
		}

		this.deplacementFond();

		if(this.xPos >= 0 && this.xPos <= 4430){
			for (Item tabItem : this.tabItems) {
				tabItem.deplacement();
			}
			for (Coin tabCoin : this.tabCoins) {
				tabCoin.deplacement();
			}
			for (Enemy tabMushroom : this.tabMushrooms) {
				tabMushroom.deplacement();
			}
			for (Enemy tabTurtle : this.tabTurtles) {
				tabTurtle.deplacement();
			}
		}

		g.drawImage(this.imgFond1, this.xFond1, 0, null);
		g.drawImage(this.imgFond2, this.xFond2, 0, null);

		for (Item tabItem : this.tabItems) {
			g.drawImage(tabItem.getImgObjet(), tabItem.getX(), tabItem.getY(), null);
		}

		for (Coin tabCoin : this.tabCoins) {
			g.drawImage(tabCoin.bouge(), tabCoin.getX(), tabCoin.getY(), null);
		}

		g.drawImage(imgDrapeau, 4650 - this.xPos, 115, null);
		g.drawImage(imgChateauFin, 5000 - this.xPos, 200, null);

		if(this.player.isVivant()){
			if(this.player.isSaut()){
				g.drawImage(this.player.saute(), this.player.getX(), this.player.getY(), null);}
			else{
				g.drawImage(this.player.marche("marius", 25), this.player.getX(), this.player.getY(), null);}
		}else{
			g.drawImage(this.player.meurt(), this.player.getX(), this.player.getY(), null);}

		for (Enemy tabMushroom : this.tabMushrooms) {
			if (tabMushroom.isVivant()) {
				g.drawImage(tabMushroom.marche("mush", 45), tabMushroom.getX(), tabMushroom.getY(), null);
			} else {
				g.drawImage(tabMushroom.death(), tabMushroom.getX(), tabMushroom.getY() + 20, null);
			}
		}

		for (Enemy tabTurtle : this.tabTurtles) {
			if (tabTurtle.isVivant()) {
				g.drawImage(tabTurtle.marche("turt", 50), tabTurtle.getX(), tabTurtle.getY(), null);
			} else {
				g.drawImage(tabTurtle.death(), tabTurtle.getX(), tabTurtle.getY() + 30, null);
			}
		}
		g.setFont(police);
		g.drawString(STR."\{this.score.getNbrePieces()} Coin(s) / \{this.score.getNBRE_TOTAL_PIECES()}", 460, 25);

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