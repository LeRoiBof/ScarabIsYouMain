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
import java.io.FileNotFoundException;

public class CreditsScene extends Scene{
    private final static BorderPane root = new BorderPane();
    private final Font titlefont = Font.font("Lucida Sans Unicode", FontWeight.BOLD,25);
    private final CustomButton back = new CustomButton("BACK",titlefont);
    public CreditsScene(){
        super(root);

        back.setAlignment(Pos.BOTTOM_CENTER);
        root.setBottom(back);

        try {
            root.setBackground(new Background(
                    new BackgroundImage(
                            new Image(new FileInputStream("src/main/resources/assets/menu/menu.png")),
                            BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
                            new BackgroundPosition(Side.LEFT,0,true,Side.BOTTOM,0,true),
                            new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO,true,true,false,true))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Image title = null;
        try {
            title = new Image(new FileInputStream("src/main/resources/assets/menu/menutitle.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView titleView = new ImageView(title);
        BorderPane.setAlignment(titleView,Pos.CENTER);
        root.setTop(titleView);
        back.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                SceneChanger.changeTo(SceneChanger.enumScene.MENU);
            }
        });
    }
}
