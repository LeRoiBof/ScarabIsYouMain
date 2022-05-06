/*** package org.scarab;

import org.scarab.Elements.Elements;
import org.scarab.Elements.Rules;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class App extends Application implements EventHandler<KeyEvent>
{
    Map map1;
    @Override
    public void start(Stage stage) throws IOException, FileNotFoundException
    {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 400, 400);
        Group test = new Group();

        for (int i = 0; i < map1.getAllElements().size(); i++) {
            test.getChildren().add(map1.getAllElements().get(i).getImageView());
            map1.getAllElements().get(i).getImageView().setTranslateX(map1.getAllElements().get(i).getPosX() * 40);
            map1.getAllElements().get(i).getImageView().setTranslateY(map1.getAllElements().get(i).getPosY() * 40);
        }

        root.setCenter(test);
        stage.setTitle("baba is you");
        scene.setOnKeyPressed(this);
        scene.setFill(Color.BLACK);
        
        stage.setScene(scene);
        stage.show();
    }
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

        public static void main(String[] args)
        {
            launch(args);
        }

} ***/
