package org.scarab;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.FileInputStream;

public class CreditsScene{
    private final BorderPane root = new BorderPane();
    private final Scene credits = new Scene(root,1280,720);
    private final Font titlefont = Font.font("Lucida Sans Unicode", FontWeight.BOLD,25);
    private final CustomButton back = new CustomButton("BACK",titlefont);
    public CreditsScene() throws Exception{
        credits.setFill(Color.TRANSPARENT);

        back.setAlignment(Pos.BOTTOM_CENTER);
        root.setBottom(back);

        root.setBackground(new Background(
                new BackgroundImage(
                        new Image(new FileInputStream("src/main/resources/assets/menu/menu.png")),
                        BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
                        new BackgroundPosition(Side.LEFT,0,true,Side.BOTTOM,0,true),
                        new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO,true,true,false,true))));

        Image title = new Image(new FileInputStream("src/main/resources/assets/menu/menutitle.png"));
        ImageView titleView = new ImageView(title);
        BorderPane.setAlignment(titleView,Pos.CENTER);
        root.setTop(titleView);

        back.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                back.setOpacity(0.9);
            }
        });
        back.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                back.setOpacity(0.7);
            }
        });
        back.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
    }

    public Scene getCredits() {
        return credits;
    }
}
