package org.scarab.Scenes;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import org.scarab.*;

public class MenuScene extends MenuConstructor {
    private final static BorderPane root = new BorderPane();
    private final VBox panel = new VBox();
    private final CustomButton play = new CustomButton("PLAY");
    private final CustomButton quit = new CustomButton("QUIT");
    private final CustomButton settings = new CustomButton("SETTINGS");
    private final CustomButton continu = new CustomButton("CONTINUE");
    private final CustomButton load = new CustomButton("LOAD LEVEL");

    /**
     * Constructeur du menu principal
     */
    public MenuScene() {
        super(root);
        /// Button settings
        panel.setSpacing(10);
        panel.getChildren().addAll(play,load,settings,quit);
        panel.setAlignment(Pos.TOP_CENTER);
        root.setCenter(panel);

        //Event handler
        quit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            /**
             * Méthode permettant de quitter le jeu
             * @param event Evènement de la souris
             */
            @Override
            public void handle(MouseEvent event) {
                Main.primaryStage.close();
            }
        });
        settings.setOnMouseClicked(new EventHandler<MouseEvent>() {
            /**
             * Méthode permettant d'aller au menu des paramètres
             * @param event Evènement de la souris
             */
            @Override
            public void handle(MouseEvent event) {
                SceneChanger.changeTo(SceneChanger.enumScene.SETTINGS);
            }
        });
        play.setOnMouseClicked(new EventHandler<MouseEvent>() {
            /**
             * Méthode permettant de commencer le jeu. Le bouton est changé après le premier click
             * @param event Evènement de la souris
             */
            @Override
            public void handle(MouseEvent event) {
                panel.getChildren().add(1,continu);
                panel.getChildren().remove(play);
                SceneChanger.setPath("src/main/resources/maps/map");
                SceneChanger.changeTo(SceneChanger.enumScene.GAME);
                Map.save();
            }
        });
        load.setOnMouseClicked(new EventHandler<MouseEvent>() {
            /**
             * Méthode permettant d'aller vers le menu de chargement
             * @param event Evènement de la souris
             */
            @Override
            public void handle(MouseEvent event) {
                SceneChanger.changeTo(SceneChanger.enumScene.LOAD);
            }
        });
        continu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            /** Méthode permettant de lancer la dernière sauvegarde du jeu
             * @param event Evènement de la souris
             */
            @Override
            public void handle(MouseEvent event) {
                    SceneChanger.setPath("src/main/resources/save/save");
                    SceneChanger.changeTo(SceneChanger.enumScene.GAME);
            }
        });
    }
}
