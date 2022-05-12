package org.scarab;

import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MenuConstructor extends Scene {
    private String path = "src/main/resources/music/menu.mp3";
    public MenuConstructor(BorderPane root){
        super(root);
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

        ///Title settings
        Image title = null;
        try {
            title = new Image(new FileInputStream("src/main/resources/assets/menu/menutitle.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView titleView = new ImageView(title);
        BorderPane.setAlignment(titleView, Pos.CENTER);
        root.setTop(titleView);
    }
    public static void changeMusic(String path){
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setVolume(0.1);
    }
}
