package characters;

import java.awt.Image;
import java.util.Objects;
import javax.swing.ImageIcon;
import items.Item;

public class Enemy extends Character implements Runnable {
    private Image imgEnemy;
    private ImageIcon icoEnemy;
    private int dx;
    private boolean isTurtle;
    private int pause = 15;  // Common pause for all enemies, can be adjusted if needed

    // Constructor
    public Enemy(String type, int x, int y) {
        super(x, y, type.equals("Mushroom") ? 32 : 32, type.equals("Mushroom") ? 30 : 50);
        this.isTurtle = type.equals("Turtle");
        this.dx = 1; // Starting movement direction
        String imagePath = type.equals("Mushroom") ? "/images/mushNormalR.png" : "/images/turtNormalR.png";
        this.icoEnemy = new ImageIcon(Objects.requireNonNull(getClass().getResource(imagePath)));
        this.imgEnemy = icoEnemy.getImage();
        Thread chrono = new Thread(this);
        chrono.start();
    }

    public Image getImgEnemy() {
        return imgEnemy;
    }

    public void move() {
        if (super.isVersDroite()) {
            this.dx = 1;
        } else {
            this.dx = -1;
        }
        super.setX(super.getX() + this.dx);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            if (this.vivant) {
                this.move();
                try {
                    Thread.sleep(pause);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void contact(Item item) {
        if (super.contactAvant(item) && this.isVersDroite()) {
            super.setVersDroite(false);
            this.dx = -1;
        } else if (super.contactArriere(item) && !this.isVersDroite()) {
            super.setVersDroite(true);
            this.dx = 1;
        }
    }

    public void contact(Character character) {
        if (super.contactAvant(character) && this.isVersDroite()) {
            super.setVersDroite(false);
            this.dx = -1;
        } else if (super.contactArriere(character) && !this.isVersDroite()) {
            super.setVersDroite(true);
            this.dx = 1;
        }
    }

    public Image death() {
        String str = isTurtle ? "/images/turtDeath.png" : (super.isVersDroite() ? "/images/mushDeathlR.png" : "/images/mushDeathlL.png.png");
        ImageIcon ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
        return ico.getImage();
    }
}
