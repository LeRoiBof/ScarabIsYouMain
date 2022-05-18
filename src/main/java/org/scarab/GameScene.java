package org.scarab;


import javafx.css.Rule;
import javafx.geometry.Insets;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
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
    String [] allmap = { "src/main/resources/maps/map.txt",
            "src/main/resources/maps/map2.txt",
            "src/main/resources/maps/map3.txt",
            "src/main/resources/maps/map4.txt"
    };

    Map map1;

    int count = 0;
    public GameScene() {
<<<<<<< HEAD
        super(root, 700, 700);
        map1 = new Map(allmap[count]);

=======
        super(root, 1000, 1000);
        map1 = new Map(allmap[count]);
>>>>>>> e5b1062d05a64022a3ec3cb7d11df607a0d7b215
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
        System.out.println(Rules.check(map1));
        switch (Rules.check(map1)) {
            case 0:
                System.out.println("j'ai gagné");


        }
        for (Elements elementstomove: map1.getAllElements()) {
            if (!elementstomove.getName().equals("border")) {
                elementstomove.setIsPush(false);
                elementstomove.setIsYou(false);
                elementstomove.setIsWin(false);
                elementstomove.setIsStop(false);
                elementstomove.setIsSink(false);

            }
        }
    }
}

