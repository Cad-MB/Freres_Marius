package characters;

import java.awt.Image;
import java.util.Objects;
import javax.swing.ImageIcon;
import items.Item;

public class Enemy extends Character implements Runnable {
    private final Image imgEnemy;
    private int dx;
    private final boolean isTurtle;

    public Enemy(String type, int x, int y) {
        super(x, y, 32, type.equals("Mushroom") ? 30 : 50);
        this.isTurtle = type.equals("Turtle");
        this.dx = 1;
        String imagePath = type.equals("Mushroom") ? "/images/mushNormalR.png" : "/images/turtNormalR.png";
        ImageIcon icoEnemy = new ImageIcon(Objects.requireNonNull(getClass().getResource(imagePath)));
        this.imgEnemy = icoEnemy.getImage();
        Thread chrono = new Thread(this);
        chrono.start();
    }

    public Image getImgEnemy() {
        return imgEnemy;
    }

    public void move() {
        if (super.isToRight()) {
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
            if (this.alive) {
                this.move();
                try {
                    int pause = 15;
                    Thread.sleep(pause);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void contact(Item item) {
        if (super.contactAhead(item) && this.isToRight()) {
            super.setToRight(false);
            this.dx = -1;
        } else if (super.contactBehind(item) && !this.isToRight()) {
            super.setToRight(true);
            this.dx = 1;
        }
    }

    public void contact(Character character) {
        if (super.contactAhead(character) && this.isToRight()) {
            super.setToRight(false);
            this.dx = -1;
        } else if (super.contactBehind(character) && !this.isToRight()) {
            super.setToRight(true);
            this.dx = 1;
        }
    }

    public Image death() {
        String str = isTurtle ? "/images/turtDeath.png" : (super.isToRight() ? "/images/mushDeathlR.png" : "/images/mushDeathlL.png.png");
        ImageIcon ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
        return ico.getImage();
    }
}
