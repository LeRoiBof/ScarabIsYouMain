 package org.scarab.Scenes;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.scarab.CustomButton;
import org.scarab.MenuConstructor;
import org.scarab.SceneChanger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;


 public class SettingsScene extends MenuConstructor {
    private final static BorderPane root = new BorderPane();
    private final CustomButton back = new CustomButton("BACK");
    private final CustomButton changeMusic = new CustomButton("CHANGE MUSIC");
    private final CustomButton stopMusic = new CustomButton("STOP MUSIC");
    private static int count = 0;
    private final VBox panel = new VBox();
    private final Random random = new Random();
    public SettingsScene(){
        super(root);
        panel.setSpacing(10);
        panel.getChildren().addAll(changeMusic,stopMusic,back);
        panel.setAlignment(Pos.TOP_CENTER);
        root.setCenter(panel);
        back.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                SceneChanger.changeTo(SceneChanger.enumScene.MENU);
            }
        });

        changeMusic.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Random random = new Random();
                int randomNumber = random.nextInt(5);
                switch (randomNumber){
                    case 0: {
                        String path = "src/main/resources/music/menu" + 1 + ".mp3";
                        MenuConstructor.changeMusic(path);
                        break;
                    }
                    case 1: {
                        String path = "src/main/resources/music/menu" + 2 + ".mp3";
                        MenuConstructor.changeMusic(path);
                        break;
                    }
                    case 2: {
                        String path = "src/main/resources/music/menu" + 3 + ".mp3";
                        MenuConstructor.changeMusic(path);
                        break;
                    }
                    case 3: {
                        String path = "src/main/resources/music/menu" + 4 + ".mp3";
                        MenuConstructor.changeMusic(path);
                        break;
                    }
                    case 4: {
                        String path = "src/main/resources/music/menu" + 5 + ".mp3";
                        MenuConstructor.changeMusic(path);
                        break;
                    }
                }
            }
        });
        stopMusic.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (count == 0) {
                    MenuConstructor.stopMusic();
                    stopMusic.setText("REPLAY");
                    count+=1;
                }
                else {
                    MenuConstructor.replayMusic();
                    stopMusic.setText("STOP MUSIC");
                    count = 0;
                }
            }
        });



    }
}
