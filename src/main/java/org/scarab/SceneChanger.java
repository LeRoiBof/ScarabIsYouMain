package org.scarab;

public class SceneChanger {

    public enum enumScene {MENU,CREDITS,SETTINGS,GAME}
    public static void changeTo(enumScene enums){
        switch(enums){
            case MENU:
                Main.primaryStage.setScene(Main.menuScene);
                break;
            case CREDITS:
                Main.primaryStage.setScene(Main.creditsScene);
                break;
            case SETTINGS:
                Main.primaryStage.setScene(Main.settingsScene);
                break;
            case GAME:
                Main.primaryStage.setScene(Main.gameScene);
                Main.primaryStage.sizeToScene();
                Main.primaryStage.centerOnScreen();
                break;

        }

    }
}
