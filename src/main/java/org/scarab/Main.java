package org.scarab;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
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
        primaryStage = _primaryStage;
        primaryStage.setTitle("Scarab Is You");
        primaryStage.getIcons().add(new Image (new FileInputStream("src/main/resources/assets/menu/scarablogo.jpg")));
        primaryStage.setWidth(1280);
        primaryStage.setHeight(720);
        Media media = new Media(new File("src/main/resources/music/menu.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setVolume(0.1);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        root.setPadding(new Insets(20));


        ///Scene opening

        primaryStage.setScene(menuScene);
        primaryStage.show();

    }
}
