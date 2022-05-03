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

public class MenuScene {
    private final BorderPane root = new BorderPane();
    private final Scene menu = new Scene(root,1280,720);
    private final VBox panel = new VBox();
    private final Font titleFont = Font.font("Lucida Sans Unicode", FontWeight.BOLD,25);
    private final CustomButton play = new CustomButton("PLAY", titleFont);
    private final CustomButton quit = new CustomButton("QUIT", titleFont);
    private final CustomButton credits = new CustomButton("CREDITS", titleFont);
    public MenuScene() throws Exception{
        /// Button settings
        panel.setSpacing(10);
        panel.getChildren().addAll(play,credits ,quit);
        panel.setAlignment(Pos.TOP_CENTER);
        root.setCenter(panel);

        ///Background settings
        root.setBackground(new Background(
                new BackgroundImage(
                        new Image(new FileInputStream("src/main/resources/assets/menu/menu.png")),
                        BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
                        new BackgroundPosition(Side.LEFT,0,true,Side.BOTTOM,0,true),
                        new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO,true,true,false,true))));

        ///Title settings
        Image title = new Image(new FileInputStream("src/main/resources/assets/menu/menutitle.png"));
        ImageView titleView = new ImageView(title);
        BorderPane.setAlignment(titleView,Pos.CENTER);
        root.setTop(titleView);

        //Event handler button
        play.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                play.setOpacity(0.9);
            }
        });
        play.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                play.setOpacity(0.7);
            }
        });
        credits.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                credits.setOpacity(0.9);
            }
        });
        credits.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                credits.setOpacity(0.7);
            }
        });
        quit.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                quit.setOpacity(0.9);
            }
        });
        quit.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                quit.setOpacity(0.7);
            }
        });
    }
    public Scene getMenu(){
        return menu;
    }
}
