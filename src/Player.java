import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Scale;

public class Player {
    private double x, y;
    private double dx = 0, dy = 0;
    private boolean onGround = false;
    private boolean facingRight = true;  // Direction the player is facing
    private State currentState;
    private final ImageView imageView;

    // Images for each state
    private final Image normalImage;
    private final Image jumpImage;
    private final Image[] walkImages;

    private int currentWalkIndex = 0;
    private double animationTime = 0;
    private double animationDuration = 0.5; // Duration for each frame in seconds

    enum State {
        NORMAL, JUMPING, WALKING, DYING
    }

    public Player(double x, double y, Image normal, Image jump, Image[] walk, Image death) {
        this.x = x;
        this.y = y;
        this.normalImage = normal;
        this.jumpImage = jump;
        this.walkImages = walk;
        this.imageView = new ImageView(normal); // Start with normal state
        this.currentState = State.NORMAL;
    }

    public void moveLeft() {
        dx = -5; // Speed for moving left
        currentState = State.WALKING;
        facingRight = false;  // Player is facing left
        updateSpriteAnimation();
    }

    public void moveRight() {
        dx = 5; // Speed for moving right
        currentState = State.WALKING;
        facingRight = true;  // Player is facing right
        updateSpriteAnimation();
    }

    public void stop() {
        dx = 0; // Stop horizontal movement
        currentState = State.NORMAL; // Set state to normal, indicating no movement
        imageView.setImage(normalImage); // Set the image to the normal standing image
    }


    public void jump() {
        if (onGround) {
            dy = -15; // Jump force
            currentState = State.JUMPING;
            onGround = false;
            imageView.setImage(jumpImage);
        }
    }

    public void update(double deltaTime) {
        x += dx * deltaTime;
        y += dy * deltaTime;

        // Manage sprite animation timing based on actual time
        animationTime += deltaTime;
        if (animationTime >= animationDuration) {
            animationTime = 0;
            updateSpriteAnimation();
        }

        // Simulate gravity
        if (!onGround) {
            dy += 0.6; // Gravity effect
        }

        // Check if the player is on the ground
        if (y >= 300) {
            y = 300;
            dy = 0;
            onGround = true;
            if (dx != 0) {
                currentState = State.WALKING;  // Maintain walking state if moving horizontally
            } else {
                currentState = State.NORMAL;  // Set to normal if not moving
                imageView.setImage(normalImage);
            }
        }

        // Apply friction to slow down
        if (dx != 0) {
            dx *= 0.8;  // Friction effect
            if (Math.abs(dx) < 0.1) {
                dx = 0;
                if (onGround) {  // Reset to normal state if stopped on the ground
                    currentState = State.NORMAL;
                    imageView.setImage(normalImage);
                }
            }
        }
    }

    private void updateSpriteAnimation() {
        if (currentState == State.WALKING) {
            currentWalkIndex = (currentWalkIndex + 1) % walkImages.length;
            imageView.setImage(walkImages[currentWalkIndex]);
        }
    }

    public void render(GraphicsContext gc) {
        if (!facingRight) {
            // Apply horizontal flip by scaling x by -1 around the center of the image
            gc.save(); // Save the current state of the GraphicsContext
            gc.translate(x + imageView.getImage().getWidth(), y); // Move the pivot point to the center of the image
            gc.scale(-1, 1); // Flip horizontally
            gc.drawImage(imageView.getImage(), 0, 0); // Draw the image at the new pivot point
            gc.restore(); // Restore the original GraphicsContext state to avoid affecting other drawings
        } else {
            // Draw the image normally
            gc.drawImage(imageView.getImage(), x, y);
        }
    }



    // Getter methods for player's position and dimensions
    public double getX() { return x; }
    public double getY() { return y; }
    public double getWidth() { return imageView.getImage().getWidth(); }
    public double getHeight() { return imageView.getImage().getHeight(); }
}
