package jeu;

import characters.Marius;
import characters.Mushroom;
import characters.Turtle;
import hud.Score;
import hud.Time;
import items.Bloc;
import items.Coin;
import items.Item;
import items.Pipe;

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
	
	public Marius marius;
	
	public Pipe pipe1;
	public Pipe pipe2;
	public Pipe pipe3;
	public Pipe pipe4;
	public Pipe pipe5;
	public Pipe pipe6;
	public Pipe pipe7;
	public Pipe pipe8;
	
	public Bloc bloc1;
	public Bloc bloc2;
	public Bloc bloc3;
	public Bloc bloc4;
	public Bloc bloc5;
	public Bloc bloc6;
	public Bloc bloc7;
	public Bloc bloc8;
	public Bloc bloc9;
	public Bloc bloc10;
	public Bloc bloc11;
	public Bloc bloc12;
	
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
	
	public Mushroom mushroom1;
	public Mushroom mushroom2;
	public Mushroom mushroom3;
	public Mushroom mushroom4;
	public Mushroom mushroom5;
	public Mushroom mushroom6;
	public Mushroom mushroom7;
	public Mushroom mushroom8;
	
	public Turtle turtle1;
	public Turtle turtle2;
	public Turtle turtle3;
	public Turtle turtle4;
	public Turtle turtle5;
	public Turtle turtle6;
	public Turtle turtle7;
	public Turtle turtle8;
	public Turtle turtle9;

    private final Image imgDrapeau;
    private final Image imgChateauFin;
	
	private final ArrayList<Item> tabItems;
	private final ArrayList<Coin> tabCoins;
	private final ArrayList<Turtle> tabTurtles;
	private final ArrayList<Mushroom> tabMushrooms;
	
	private final Score score;
	private final Font police;
	private final Time time;

	public Level1Scene(){
		
		super();
		
		this.xFond1 = -50;
		this.xFond2 = 750;
		this.dx = 0;
		this.xPos = -1;
		this.ySol = 293;
		this.hauteurPlafond = 0;

        ImageIcon icoFond = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/BR.png")));
		this.imgFond1 = icoFond.getImage();
		this.imgFond2 = icoFond.getImage();
		
		marius = new Marius(300, 245);
		
		pipe1 = new Pipe(600, 230);
		pipe2 = new Pipe(1000, 230);
		pipe3 = new Pipe(1600, 230);
		pipe4 = new Pipe(1900, 230);
		pipe5 = new Pipe(2500, 230);
		pipe6 = new Pipe(3000, 230);
		pipe7 = new Pipe(3800, 230);
		pipe8 = new Pipe(4500, 230);
		
		bloc1 = new Bloc(400, 180);
		bloc2 = new Bloc(1200, 180);
		bloc3 = new Bloc(1270, 170);
		bloc4 = new Bloc(1340, 160);
		bloc5 = new Bloc(2000, 180);
		bloc6 = new Bloc(2600, 160);
		bloc7 = new Bloc(2650, 180);
		bloc8 = new Bloc(3500, 160);
		bloc9 = new Bloc(3550, 140);
		bloc10 = new Bloc(4000, 170);
		bloc11 = new Bloc(4200, 200);
		bloc12 = new Bloc(4300, 210);
		
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
		
		mushroom1 = new Mushroom(800, 263);
		mushroom2 = new Mushroom(1100, 263);
		mushroom3 = new Mushroom(2100, 263);
		mushroom4 = new Mushroom(2400, 263);
		mushroom5 = new Mushroom(3200, 263);
		mushroom6 = new Mushroom(3500, 263);
		mushroom7 = new Mushroom(3700, 263);
		mushroom8 = new Mushroom(4500, 263);
		
		turtle1 = new Turtle(950, 243);
		turtle2 = new Turtle(1500, 243);
		turtle3 = new Turtle(1800, 243);
		turtle4 = new Turtle(2400, 243);
		turtle5 = new Turtle(3100, 243);
		turtle6 = new Turtle(3600, 243);
		turtle7 = new Turtle(3900, 243);
		turtle8 = new Turtle(4200, 243);
		turtle9 = new Turtle(4400, 243);

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
		
		score = new Score();
		police = new Font("Arial", Font.PLAIN, 18);
		time = new Time();
				
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
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
        return this.time.getCompteurTemps() > 0 && this.marius.isVivant() && this.score.getNbrePieces() == 10
                && this.xPos > 4400;
	}
	
	private boolean partiePerdue(){
        return !this.marius.isVivant() || this.time.getCompteurTemps() <= 0;
	}
		
	public boolean finDePartie(){
        return this.partieGagnee() || this.partiePerdue();
	}
	
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);


        for (Item item : this.tabItems) {
            if (this.marius.proche(item)) {
                this.marius.contact(item);
            }
            for (Mushroom tabMushroom : this.tabMushrooms) {
                if (tabMushroom.proche(item)) {
                    tabMushroom.contact(item);
                }
            }
            for (Turtle tabTurtle : this.tabTurtles) {
                if (tabTurtle.proche(item)) {
                    tabTurtle.contact(item);
                }
            }
        }

 	 	for(int i = 0; i < this.tabCoins.size(); i++){
 	 		if(this.marius.proche(this.tabCoins.get(i))){
 	 			if(this.marius.contactPiece(this.tabCoins.get(i))){
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
            for (Turtle tabTurtle : this.tabTurtles) {
                if (tabTurtle.proche(this.tabMushrooms.get(i))) {
                    tabTurtle.contact(this.tabMushrooms.get(i));
                }
            }
 	    }

 	 	for(int i = 0; i < this.tabTurtles.size(); i++){
            for (Mushroom tabMushroom : this.tabMushrooms) {
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

        for (Mushroom mushroom : this.tabMushrooms) {
            if (this.marius.proche(mushroom) && mushroom.isVivant()) {
                this.marius.contact(mushroom);
            }
        }
        for (Turtle turtle : this.tabTurtles) {
            if (this.marius.proche(turtle) && turtle.isVivant()) {
                this.marius.contact(turtle);
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
            for (Mushroom tabMushroom : this.tabMushrooms) {
                tabMushroom.deplacement();
            }
            for (Turtle tabTurtle : this.tabTurtles) {
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
 	 	
 		if(this.marius.isVivant()){
 			if(this.marius.isSaut()){
                g.drawImage(this.marius.saute(), this.marius.getX(), this.marius.getY(), null);}
 	 		else{
                g.drawImage(this.marius.marche("marius", 25), this.marius.getX(), this.marius.getY(), null);}
 		}else{
            g.drawImage(this.marius.meurt(), this.marius.getX(), this.marius.getY(), null);}

        for (Mushroom tabMushroom : this.tabMushrooms) {
            if (tabMushroom.isVivant()) {
                g.drawImage(tabMushroom.marche("mush", 45), tabMushroom.getX(), tabMushroom.getY(), null);
            } else {
                g.drawImage(tabMushroom.meurt(), tabMushroom.getX(), tabMushroom.getY() + 20, null);
            }
        }

        for (Turtle tabTurtle : this.tabTurtles) {
            if (tabTurtle.isVivant()) {
                g.drawImage(tabTurtle.marche("turt", 50), tabTurtle.getX(), tabTurtle.getY(), null);
            } else {
                g.drawImage(tabTurtle.meurt(), tabTurtle.getX(), tabTurtle.getY() + 30, null);
            }
        }
	    g.setFont(police);
	    g.drawString(STR."\{this.score.getNbrePieces()} Coins / \{this.score.getNBRE_TOTAL_PIECES()}", 460, 25);
	    
	    g.drawString(this.time.getStr(), 5, 25);

		if (this.finDePartie()) {
			Font policeFin = new Font("Arial", Font.BOLD, 50);
			g.setFont(policeFin);
			if (this.partieGagnee()) {
				g.drawString("Victory", 180, 180);
			} else {
				ImageIcon deathIcon = new ImageIcon("/images/deathTitle.gif");
				if (deathIcon.getImage() != null) { // Check if the image is not null
					g.drawImage(deathIcon.getImage(), 180, 180, null);
				} else {
					System.out.println("Error: Unable to load the death image.");
				}
			}
		}
    }
}