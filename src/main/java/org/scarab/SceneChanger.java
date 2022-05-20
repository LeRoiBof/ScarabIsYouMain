package org.scarab;

import org.scarab.Scenes.GameScene;

import java.io.File;
import java.util.Objects;

public class SceneChanger {

    public enum enumScene {MENU,SETTINGS,GAME,LOAD}
    private static int count = 0;
    private static String path = "src/main/resources/maps/map";
    private static final int fileCount = Objects.requireNonNull(new File("src/main/resources/maps").list()).length;

    /**
     * Méthode permettant de changer de scène
     * @param enums Une liste limitant les cases possibles
     */
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
                if (count < fileCount) {
                    Main.primaryStage.setScene(new GameScene(path + count + ".txt"));
                    Main.primaryStage.sizeToScene();
                    Main.primaryStage.centerOnScreen();
                } else {
                    Main.primaryStage.setScene(Main.menuScene);
                    Main.primaryStage.centerOnScreen();
                }
                break;
            case LOAD:
                Main.primaryStage.setScene(Main.loadScene);
                break;
        }

    }

    /**
     * Méthode permettant de changer l'état du count
     * @param count_ un entier de changement de paramètre
     */
    public static void changeCount(int count_){
        count = count_;
    }

    /**
     * Méthode permettant d'obtenir la valeur du count
     * @return un entier count
     */
    public static int getCount(){
        return count;
    }

    /**
     * Méthode permettant de changer le chemin d'accès
     * @param path_ Un chemin d'accès
     */
    public static void setPath(String path_){
        path = path_;
    }
}
