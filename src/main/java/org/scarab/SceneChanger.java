package org.scarab;

import org.scarab.Scenes.GameScene;
import org.scarab.Scenes.LoadScene;

import java.io.FileNotFoundException;
import java.security.spec.ECField;

public class SceneChanger {

    /**
     * Liste des cases possibles lors d'appel de la méthode changeTo
     */
    public enum enumScene {MENU,SETTINGS,GAME,LOAD}
    private static int count = 0;
    private static String path = "src/main/resources/maps/map";

    /**
     * @param enums Prends en paramètre un enum déclaré plus haut
     *              Méthode permettant de changer de scène. Cette méthode set la nouvelle scene dans le primarystage.
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
                if (count < LoadScene.getFileCount()) {
                    Main.primaryStage.setScene(new GameScene(path + count + ".txt"));
                    Main.primaryStage.sizeToScene();
                    Main.primaryStage.centerOnScreen();
                }
                    else {
                        Main.primaryStage.setScene(Main.menuScene);
                        Main.primaryStage.sizeToScene();
                        Main.primaryStage.centerOnScreen();
            }
                break;
            case LOAD:
                Main.primaryStage.setScene(Main.loadScene);
                break;
        }

    }

    /**
     * @param count_ Permet de changer la valeur du count
     */
    public static void changeCount(int count_){
        count = count_;
    }

    /**
     * @return Renvoie le count de la classe
     */
    public static int getCount(){
        return count;
    }

    /**
     * @param path_ Permet de changer la valeur du path
     */
    public static void setPath(String path_){
        path = path_;
    }
}
