import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuScene extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        VBox menuBox = new VBox(10);
        menuBox.setAlignment(Pos.CENTER);

        // Character selection
        ToggleGroup characterGroup = new ToggleGroup();
        RadioButton mariusButton = new RadioButton("Marius");
        mariusButton.setUserData("marius");  // Set user data
        mariusButton.setToggleGroup(characterGroup);
        mariusButton.setSelected(true);

        RadioButton luisButton = new RadioButton("Luis");
        luisButton.setUserData("luis");  // Set user data
        luisButton.setToggleGroup(characterGroup);

        // Button for level selection
        Button levelOneButton = new Button("Level 1");
        levelOneButton.setOnAction(e -> {
            if (characterGroup.getSelectedToggle() != null) {
                String selectedCharacter = characterGroup.getSelectedToggle().getUserData().toString();
                launchGameScene(selectedCharacter);
            }
        });

        // Exit button
        Button exitButton = new Button("Exit");
        exitButton.setOnAction(e -> System.exit(0));

        menuBox.getChildren().addAll(mariusButton, luisButton, levelOneButton, exitButton);

        Scene scene = new Scene(menuBox, 300, 200);
        primaryStage.setTitle("Game Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to launch the GameScene with the selected character
    private void launchGameScene(String selectedCharacter) {
        GameScene gameScene = new GameScene();
        gameScene.setSelectedCharacter(selectedCharacter);  // Set the selected character
        Scene scene = new Scene(gameScene.createContent());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Mario-style Game");
        primaryStage.show();
        gameScene.startGame();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
