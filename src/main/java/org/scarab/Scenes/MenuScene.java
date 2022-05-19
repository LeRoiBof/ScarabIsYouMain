package org.scarab.Scenes;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.scarab.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.spec.ECField;
import java.util.Objects;

public class MenuScene extends MenuConstructor {
    private final static BorderPane root = new BorderPane();
    private final VBox panel = new VBox();
    private final CustomButton play = new CustomButton("PLAY");
    private final CustomButton quit = new CustomButton("QUIT");
    private final CustomButton settings = new CustomButton("SETTINGS");
    private final CustomButton continu = new CustomButton("CONTINUE");
    private final CustomButton load = new CustomButton("LOAD LEVEL");
    private final int fileCount = Objects.requireNonNull(new File("src/main/resources/save").list()).length;

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
             * @param event Event de click sur le bouton
             *              Méthode permettant de fermer la fenêtre
             */
            @Override
            public void handle(MouseEvent event) {
                Main.primaryStage.close();
            }
        });
        settings.setOnMouseClicked(new EventHandler<MouseEvent>() {
            /**
             * @param event Event de click sur le bouton
             *              Méthode permettant d'aller vers le menu paramètres
             */
            @Override
            public void handle(MouseEvent event) {
                SceneChanger.changeTo(SceneChanger.enumScene.SETTINGS);
            }
        });
        play.setOnMouseClicked(new EventHandler<MouseEvent>() {
            /**
             * @param event Event de click sur le bouton
             *              Méthode permettant de lancer le jeu au niveau 0. Le bouton est changé en continue une fois appuyé
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
             * @param event Event de click sur le bouton
             *              Méthode permettant de changer vers la scene de chargement des niveaux
             */
            @Override
            public void handle(MouseEvent event) {
                SceneChanger.changeTo(SceneChanger.enumScene.LOAD);
            }
        });
        continu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            /**
             * @param event Event de click sur le bouton
             *              Méthode permettant de continuer dans le niveau sauvegardé au préalable
             */
            @Override
            public void handle(MouseEvent event) {
                    SceneChanger.setPath("src/main/resources/save/save");
                    SceneChanger.changeTo(SceneChanger.enumScene.GAME);
            }
        });
    }
}
