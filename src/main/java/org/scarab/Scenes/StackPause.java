package org.scarab.Scenes;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.scarab.CustomButton;
import org.scarab.Elements.Elements;
import org.scarab.Main;
import org.scarab.Map;
import org.scarab.SceneChanger;

public class StackPause extends BorderPane {
    private VBox panel = new VBox();
    private final CustomButton save = new CustomButton("SAVE");
    private final CustomButton quit = new CustomButton("QUIT");
    private final CustomButton reload = new CustomButton("RELOAD");
    private final CustomButton continu = new CustomButton("CONTINUE");
    public StackPause(){
        this.setHeight(800);
        this.setWidth(800);
        Rectangle rectangle = new Rectangle(800,800);
        rectangle.setFill(Color.BLACK);
        rectangle.setOpacity(0.3);
        this.getChildren().add(rectangle);
        panel.setSpacing(10);
        panel.getChildren().addAll(continu,save,reload,quit);
        panel.setAlignment(Pos.CENTER);
        this.setCenter(panel);

        quit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                SceneChanger.changeTo(SceneChanger.enumScene.MENU);
            }
        });
        save.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Map.save();
            }
        });
        continu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                GameScene.removePause();
                Elements.changeMove(true);
            }
        });
        reload.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Map.clearElements();
                SceneChanger.changeCount(SceneChanger.getCount()-1);
                SceneChanger.changeTo(SceneChanger.enumScene.GAME);
            }
        });

    }
}
