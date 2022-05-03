package org.scarab;

import javafx.stage.Stage;

public class SceneChanger {
    MenuScene menuScene;

    {
        try {
            menuScene = new MenuScene();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    CreditsScene creditsScene;

    {
        try {
            creditsScene = new CreditsScene();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private Stage primaryStage;

    public enum enumScene {MENU,CREDITS}
    public static void changeTo(enumScene enums){
        switch(enums){
            /*** case MENU -> ***/
        }

    }
}
