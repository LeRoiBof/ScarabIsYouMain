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

public class MenuScene extends Scene {
    private final static BorderPane root = new BorderPane();
    private final VBox panel = new VBox();
    private final Font titleFont = Font.font("Lucida Sans Unicode", FontWeight.BOLD,25);
    private final CustomButton play = new CustomButton("PLAY", titleFont);
    private final CustomButton quit = new CustomButton("QUIT", titleFont);
    private final CustomButton credits = new CustomButton("CREDITS", titleFont);
    private final CustomButton settings = new CustomButton("SETTINGS", titleFont);
    public MenuScene() {
        super(root);
        /// Button settings
        panel.setSpacing(10);
        panel.getChildren().addAll(play, credits, settings,quit);
        panel.setAlignment(Pos.TOP_CENTER);
        root.setCenter(panel);

        ///Background settings
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
    }
}
