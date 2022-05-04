package org.scarab;

import javafx.stage.Stage;

import java.awt.*;

public class SceneChanger {

    public enum enumScene {MENU,CREDITS,SETTINGS}
    public static void changeTo(enumScene enums){
        switch(enums){
             case MENU -> Main.primaryStage.setScene(Main.menuScene);
            case CREDITS -> Main.primaryStage.setScene(Main.creditsScene);
            case SETTINGS -> Main.primaryStage.setScene(Main.settingsScene);
        }

    }
}
