package org.scarab;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MenuScene extends MenuConstructor {
    private final static BorderPane root = new BorderPane();
    private final VBox panel = new VBox();
    private final CustomButton play = new CustomButton("PLAY");
    private final CustomButton quit = new CustomButton("QUIT");
    private final CustomButton credits = new CustomButton("CREDITS");
    private final CustomButton settings = new CustomButton("SETTINGS");
    public MenuScene() {
        super(root);
        /// Button settings
        panel.setSpacing(10);
        panel.getChildren().addAll(play, credits, settings,quit);
        panel.setAlignment(Pos.TOP_CENTER);
        root.setCenter(panel);

        //Event handler
        credits.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                SceneChanger.changeTo(SceneChanger.enumScene.CREDITS);
            }
        });
        quit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Main.primaryStage.close();
            }
        });
        settings.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                SceneChanger.changeTo(SceneChanger.enumScene.SETTINGS);
            }
        });
        play.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                SceneChanger.changeTo(SceneChanger.enumScene.GAME);
            }
        });
    }
}
