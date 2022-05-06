package org.scarab;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileInputStream;

public class Main extends Application {


    public static Stage primaryStage;
    private final BorderPane root = new BorderPane();
    static MenuScene menuScene = new MenuScene();
    static CreditsScene creditsScene = new CreditsScene();
    static SettingsScene settingsScene = new SettingsScene();
    static GameScene gameScene = new GameScene();

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage _primaryStage) throws Exception {
        ///Stage init
        this.primaryStage = _primaryStage;
        primaryStage.setTitle("Scarab Is You");
        primaryStage.getIcons().add(new Image (new FileInputStream("src/main/resources/assets/menu/scarablogo.jpg")));
        primaryStage.setWidth(1280);
        primaryStage.setHeight(720);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        root.setPadding(new Insets(20));


        ///Scene opening

        primaryStage.setScene(menuScene);
        primaryStage.show();

    }
}
