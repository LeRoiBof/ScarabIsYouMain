package org.scarab;


import javafx.css.Rule;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import org.scarab.Elements.Elements;
import org.scarab.Elements.Rules;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import javafx.event.EventHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameScene extends Scene implements EventHandler<KeyEvent> {
    private final static BorderPane root = new BorderPane();
    static Map map1;

    public GameScene(String path) {
        super(root, 1000, 1000);
        map1 = new Map(path);
        Group test = new Group();
        root.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        for (int i = 0; i < map1.getAllElements().size(); i++) {
            System.out.println(map1.getAllElements().get(i).getName());
            test.getChildren().add(map1.getAllElements().get(i).getImageView());
            map1.getAllElements().get(i).getImageView().setTranslateX(map1.getAllElements().get(i).getPosX() * 40);
            map1.getAllElements().get(i).getImageView().setTranslateY(map1.getAllElements().get(i).getPosY() * 40);
        }
        root.setCenter(test);
        setOnKeyPressed(this);
        setFill(Color.BLACK);
        root.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ESCAPE){
                    Main.primaryStage.close();
                }
            }
        });
    }

    @Override
    public void handle(KeyEvent event)
    {
        Rules.updaterules(map1);
        for(Elements elementstomove : map1.getAllElements()) {
            if (elementstomove.getIsYou()) {
                elementstomove.move(event.getCode(), map1.getGrid());
            }
        }
        switch (Rules.check(map1)) {
            case 0:
                SceneChanger.changeTo(SceneChanger.enumScene.GAME);
                break;

        }
    }
}

