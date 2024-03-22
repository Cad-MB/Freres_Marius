import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;
import java.util.List;

public class GameEngine {
    private final List<Enemy> enemies = new ArrayList<>();
    private Player player;  // Reference to the player object
    private int score = 0;
    private List<Platform> platforms;

    // Constructor that accepts a Player instance
    public GameEngine(Player player) {
        this.player = player;
        enemies.add(new Enemy(200, 300));
        enemies.add(new Enemy(500, 300));
    }

    // Update method now properly accepts a double for deltaTime
    public void update(double deltaTime) {
        player.update(deltaTime);  // Update player with the elapsed time
        for (Enemy enemy : enemies) {
            enemy.update(deltaTime);  // Update each enemy with the elapsed time
            if (enemy.collidesWith(player)) {
                score -= 100;  // Decrease score if collision occurs
                break;
            }
        }
    }

    // Render method to draw all game elements
    public void render(GraphicsContext gc) {
        player.render(gc);  // Render the player
        for (Enemy enemy : enemies) {
            enemy.render(gc);  // Render each enemy
        }
        gc.fillText(STR."Score: \{score}", 10, 20);  // Draw the score
    }
}
