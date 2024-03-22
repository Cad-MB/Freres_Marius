import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class GameScene {
    private Canvas canvas;
    private Player player;
    private GameEngine engine;
    private long lastTime = System.nanoTime();

    private String selectedCharacter = "marius";  // Default character

    // Setter for selected character
    public void setSelectedCharacter(String characterName) {
        this.selectedCharacter = characterName;
        // Make sure the UI is ready before initializing the player
        if (canvas != null) {
            initializePlayer();
        }
    }

    public Parent createContent() {
        Pane root = new Pane();
        canvas = new Canvas(800, 600);
        root.getChildren().add(canvas);
        root.setFocusTraversable(true);
        root.requestFocus();

        // Initialize the player after ensuring canvas is set up
        initializePlayer();  // Now safe to call here

        engine = new GameEngine(player);

        root.setOnKeyPressed(this::handleKeyPress);
        root.setOnKeyReleased(this::handleKeyRelease);

        return root;
    }

    private void initializePlayer() {
        if (canvas != null) {  // Additional safety check
            String basePath = "file:src/images/sprites/" + selectedCharacter + "/";
            player = new Player(
                    canvas.getWidth() / 2,
                    canvas.getHeight() - 30,
                    new Image(basePath + "normal.png"),
                    new Image(basePath + "jump.png"),
                    new Image[] {
                            new Image(basePath + "walk1.png"),
                            new Image(basePath + "walk2.png"),
                            new Image(basePath + "walk3.png")
                    },
                    new Image(basePath + "death.png")
            );
        }
    }

    public void startGame() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                double deltaTime = (now - lastTime) / 1_000_000_000.0;
                lastTime = now;
                engine.update(deltaTime);
                render();
            }
        }.start();
    }

    private void handleKeyPress(KeyEvent event) {
        System.out.println("Key pressed: " + event.getCode());
        switch (event.getCode()) {
            case LEFT -> player.moveLeft();
            case RIGHT -> player.moveRight();
            case UP -> player.jump();
        }
    }

    private void handleKeyRelease(KeyEvent event) {
        System.out.println("Key released: " + event.getCode());
        player.stop();
    }

    private void render() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        engine.render(gc);
    }
}
