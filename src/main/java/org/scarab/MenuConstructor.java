package org.scarab;

import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MenuConstructor extends Scene {
    private String path = "src/main/resources/music/menu1.mp3";
    private static MediaPlayer menuMedia = null;
    private static Media temp;

    /**
     * @param root Prends en paramètre le root de la scène pour en définir les propriétés
     *             Constructeur de toutes les scènes du menu
     */
    public MenuConstructor(BorderPane root){
        super(root,1280,720);
        changeMusic(path);
        Media menuVid = new Media(new File("src/main/resources/videos/menuvideo.mp4").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(menuVid);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setFitHeight(720);
        mediaView.setFitWidth(1280);

        root.getChildren().add(mediaView);


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
        Image credits = null;
        try {
            credits = new Image(new FileInputStream("src/main/resources/assets/menu/credits.png"));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ImageView creditsView = new ImageView(credits);
        BorderPane.setAlignment(creditsView,Pos.CENTER);
        root.setBottom(creditsView);
    }

    /**
     * @param path Prends en paramètre un path pour le changement de musique
     *             Méthode permettant de changer la musique en cours du menu. La méthode arrête la musique en cours et lance une nouvelle
     */
    public static void changeMusic(String path){
        if (menuMedia != null){
            menuMedia.stop();
        }
        Media media = new Media(new File(path).toURI().toString());
        menuMedia = new MediaPlayer(media);
        menuMedia.setAutoPlay(true);
        menuMedia.setCycleCount(MediaPlayer.INDEFINITE);
        menuMedia.setVolume(0.1);
    }

    /**
     * Méthode permettant d'arrêter la musique en cours tout en la sauvegardant dans une variable
     */
    public static void stopMusic(){
        temp = menuMedia.getMedia();
        menuMedia.stop();
    }

    /**
     * Méthode permettant de reprendre la musique précédemment arrêtée
     */
    public static void replayMusic(){
        menuMedia = new MediaPlayer(temp);
        menuMedia.setAutoPlay(true);
        menuMedia.setCycleCount(MediaPlayer.INDEFINITE);
        menuMedia.setVolume(0.1);

    }
}
