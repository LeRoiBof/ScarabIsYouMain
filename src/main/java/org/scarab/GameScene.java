package org.scarab;

import javafx.scene.input.KeyEvent;
import org.scarab.Elements.Elements;
import org.scarab.Elements.Rules;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

import javafx.event.EventHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameScene extends Scene implements EventHandler<KeyEvent> {
    private final static BorderPane root = new BorderPane();
    Map map1 = new Map();
    public GameScene() {
        super(root, 600, 600);
        Group test = new Group();

        for (int i = 0; i < map1.getAllElements().size(); i++) {
            test.getChildren().add(map1.getAllElements().get(i).getImageView());
            map1.getAllElements().get(i).getImageView().setTranslateX(map1.getAllElements().get(i).getPosX() * 40);
            map1.getAllElements().get(i).getImageView().setTranslateY(map1.getAllElements().get(i).getPosY() * 40);
        }
        root.setCenter(test);
        setOnKeyPressed(this);
        setFill(Color.BLACK);
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
        for (Elements elementstomove: map1.getAllElements()) {
            elementstomove.setIsPush(false);
            elementstomove.setIsYou(false);
            elementstomove.setIsWin(false);
            elementstomove.setIsStop(false);
        }

    }
}

