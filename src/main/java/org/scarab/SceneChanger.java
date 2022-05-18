package org.scarab;

public class SceneChanger {

    public enum enumScene {MENU,SETTINGS,GAME,PAUSE}
    public static void changeTo(enumScene enums){
        switch(enums){
            case MENU:
                Main.primaryStage.setScene(Main.menuScene);
                break;
            case SETTINGS:
                Main.primaryStage.setScene(Main.settingsScene);
                break;
            case GAME:
                Main.primaryStage.setScene(Main.gameScene);
                Main.primaryStage.sizeToScene();
                Main.primaryStage.centerOnScreen();
                break;
            case PAUSE:
                Main.primaryStage.setScene(Main.pauseScene);

        }

    }
}
