package org.scarab;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main extends Application {


    public static Stage primaryStage;
    private final BorderPane root = new BorderPane();
    static MenuScene menuScene = new MenuScene();
    static SettingsScene settingsScene = new SettingsScene();
    static GameScene gameScene = new GameScene();

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage _primaryStage) throws Exception {
        //Stage init
        primaryStage = _primaryStage;
        primaryStage.setTitle("Scarab Is You");
        primaryStage.getIcons().add(new Image (new FileInputStream("src/main/resources/assets/menu/scarablogo.jpg")));
        primaryStage.setWidth(1280);
        primaryStage.setHeight(720);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        root.setPadding(new Insets(20));

        try {
            root.setBackground(new Background(
                    new BackgroundImage(
                            new Image(new FileInputStream("src/main/resources/assets/menu/menu.png")),
                            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                            new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
                            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        //Scene opening

        primaryStage.setScene(menuScene);
        primaryStage.show();

    }
}
