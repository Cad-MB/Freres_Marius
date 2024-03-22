import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Enemy {
    private double x;
    private final double y;
    private final int width = 30;
    private final int height = 30;
    private boolean moveRight = true;

    // Images for walking animation
    private Image[] walkImages;
    private int imageIndex = 0;
    private double animationTimer = 0;
    private final double animationInterval = 0.5; // seconds per frame

    public Enemy(double x, double y) {
        this.x = x;
        this.y = y;
        this.walkImages = new Image[]{
                new Image("file:src/images/sprites/jumba/walk1.png"),
                new Image("file:src/images/sprites/jumba/walk2.png")
        };
    }

    public void update(double deltaTime) {
        double movementSpeed = 2.0;
        if (moveRight) {
            x += movementSpeed * deltaTime;  // Use deltaTime to scale movement
        } else {
            x -= movementSpeed * deltaTime;
        }

        // Randomly change direction with a probability that considers deltaTime
        if (Math.random() < 0.01 * deltaTime) {
            moveRight = !moveRight;
        }

        // Update animation based on deltaTime
        animationTimer += deltaTime;
        if (animationTimer >= animationInterval) {
            animationTimer = 0;
            imageIndex = (imageIndex + 1) % walkImages.length;
        }
    }

    public void render(GraphicsContext gc) {
        if (walkImages != null && walkImages.length > 0) {
            // Apply horizontal flip if moving left
            if (!moveRight) {
                gc.save(); // Save the current state of the GraphicsContext
                gc.translate(x + width, y); // Move the pivot point to the right edge of the enemy
                gc.scale(-1, 1); // Flip horizontally
                gc.drawImage(walkImages[imageIndex], 0, 0, width, height); // Draw the image at the new pivot point
                gc.restore(); // Restore the original GraphicsContext state
            } else {
                gc.drawImage(walkImages[imageIndex], x, y, width, height);
            }
        } else {
            gc.setFill(Color.BROWN);
            gc.fillRect(x, y, width, height);
        }
    }

    public boolean collidesWith(Player player) {
        return (x + width > player.getX() && x < player.getX() + player.getWidth() &&
                y + height > player.getY() && y < player.getY() + player.getHeight());
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
