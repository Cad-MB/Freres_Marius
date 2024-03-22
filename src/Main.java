import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        showGameMenu(primaryStage);  // Show game menu initially
    }

    public void showGameMenu(Stage primaryStage) {
        MenuScene menuScene = new MenuScene();  // Assuming MenuScene is another class that sets up the menu
        menuScene.start(primaryStage);  // Start menu scene
    }

    public static void main(String[] args) {
        launch(args);
    }
}
