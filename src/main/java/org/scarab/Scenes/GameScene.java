package org.scarab.Scenes;


import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import org.scarab.Elements.Elements;
import org.scarab.Elements.Rules;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import javafx.event.EventHandler;
import org.scarab.Map;
import org.scarab.SceneChanger;

public class GameScene extends Scene implements EventHandler<KeyEvent> {
    private static BorderPane root;
    static Map map1;
    static Group test;
    private final static StackPause stackPause = new StackPause();

    /**
     * Constructeur des niveaux
     * @param path_ Le chemin d'accès vers la map
     */
    public GameScene(String path_) {
        super(new BorderPane(), 800, 800);
        root = (BorderPane) super.getRoot();
        map1 = new Map(path_);
        test = new Group();
        root.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        for (int i = 0; i < map1.getAllElements().size(); i++) {
            test.getChildren().add(map1.getAllElements().get(i).getImageView());
            map1.getAllElements().get(i).getImageView().setTranslateX(map1.getAllElements().get(i).getPosX() * 40);
            map1.getAllElements().get(i).getImageView().setTranslateY(map1.getAllElements().get(i).getPosY() * 40);
        }
        root.setCenter(test);
        setOnKeyPressed(this);
        setFill(Color.BLACK);
    }

    /**
     * Méthode permettant de sortir du menu pause
     */
    public static void removePause(){
        root.getChildren().remove(stackPause);
    }

    /**
     * Méthode permettant de gérer les différents event liés à l'appui de touches du clavier
     * @param event Action d'appui sur une touche du clavier
     */
    @Override
    public void handle(KeyEvent event)
    {
        Rules.updaterules(map1);
        for(Elements elementstomove : map1.getAllElements()) {
            if (elementstomove.getIsYou()) {
                elementstomove.move(event.getCode(), map1.getGrid());
            }
        }

        if (event.getCode() == KeyCode.R){
            Elements.changeMove(false);
            root.getChildren().add(stackPause);
        }



        for (Elements elementstomove: map1.getAllElements()) {
            if (!elementstomove.getName().equals("border")) {
                elementstomove.setIsPush(false);
                elementstomove.setIsYou(false);
                elementstomove.setIsWin(false);
                elementstomove.setIsStop(false);
                elementstomove.setIsSink(false);
                elementstomove.setBest(false);

            }
        }

        Rules.updaterules(map1);

        switch (Rules.check(map1)) {
            case 0:
                Map.clearElements();
                SceneChanger.setPath("src/main/resources/maps/map");
                SceneChanger.changeCount(SceneChanger.getCount()+1);
                SceneChanger.changeTo(SceneChanger.enumScene.GAME);
                Map.save();
                break;

        }

    }
}

