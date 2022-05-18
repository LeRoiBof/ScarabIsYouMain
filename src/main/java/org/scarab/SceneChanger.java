package org.scarab;

import org.scarab.Scenes.GameScene;

public class SceneChanger {

    public enum enumScene {MENU,SETTINGS,GAME,LOAD,LOADLEVEL}
    private static int count = 0;
    private static int loadCount = 0;
    private static String path = "src/main/resources/maps/map";
    public static void changeTo(enumScene enums){
        switch(enums){
            case MENU:
                Main.primaryStage.setScene(Main.menuScene);
                Main.primaryStage.centerOnScreen();
                break;
            case SETTINGS:
                Main.primaryStage.setScene(Main.settingsScene);
                break;
            case GAME:
                Main.primaryStage.setScene(new GameScene(path+count+".txt"));
                Main.primaryStage.sizeToScene();
                Main.primaryStage.centerOnScreen();
                break;
            case LOAD:
                Main.primaryStage.setScene(Main.loadScene);
                break;
            case LOADLEVEL: {
                Main.primaryStage.setScene(new GameScene(path + loadCount + ".txt"));
                Main.primaryStage.sizeToScene();
                Main.primaryStage.centerOnScreen();
                break;
            }
        }

    }
    public static void changeCount(int count_){
        count = count_;
    }
    public static int getCount(){
        return count;
    }
    public static void setPath(String path_){
        path = path_;
    }
    public static void setLoadCount(int count_){
        loadCount = count_;
    }
}
