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

public class CreditsScene extends MenuConstructor{
    private final static BorderPane root = new BorderPane();
    private final CustomButton back = new CustomButton("BACK");
    public CreditsScene(){
        super(root);
        back.setAlignment(Pos.BOTTOM_CENTER);
        root.setBottom(back);

        back.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                SceneChanger.changeTo(SceneChanger.enumScene.MENU);
            }
        });
    }
}
