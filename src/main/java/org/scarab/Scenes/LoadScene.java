package org.scarab.Scenes;

import javafx.application.Preloader;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import org.scarab.CustomButton;
import org.scarab.Map;
import org.scarab.MenuConstructor;
import org.scarab.SceneChanger;

import java.io.File;
import java.util.Objects;

public class LoadScene extends MenuConstructor {
    private static final BorderPane root = new BorderPane();
    private final CustomButton back = new CustomButton("BACK");
    private final HBox panel = new HBox();
    static int fileCount = Objects.requireNonNull(new File("src/main/resources/maps").list()).length;

    /**
     * Constructeur de la scene de chargements de niveaux
     */
    public LoadScene(){
        super(root);

        for (int i = 0;i<fileCount;i++){
            CustomButton button = new CustomButton("Level " + i);
            panel.getChildren().add(button);
        }
        panel.setSpacing(10);
        panel.setAlignment(Pos.CENTER);
        root.setCenter(panel);

        back.setAlignment(Pos.CENTER);
        root.setBottom(back);

        back.setOnMouseClicked(new EventHandler<MouseEvent>() {
            /**
             * @param event Event de click sur le bouton
             *              Méthode permettant de revenir au menu principal
             */
            @Override
            public void handle(MouseEvent event) {
                SceneChanger.changeTo(SceneChanger.enumScene.MENU);
            }
        });
        panel.getChildren().get(0).setOnMouseClicked(new EventHandler<MouseEvent>() {
            /**
             * @param event Event de click sur le bouton
             *              Méthode qui charge le niveau correspondant
             */
            @Override
            public void handle(MouseEvent event) {
                SceneChanger.changeCount(0);
                SceneChanger.setPath("src/main/resources/maps/map");
                SceneChanger.changeTo(SceneChanger.enumScene.GAME);
            }
        });
        panel.getChildren().get(1).setOnMouseClicked(new EventHandler<MouseEvent>() {
            /**
             * @param event Event de click sur le bouton
             *              Méthode qui charge le niveau correspondant
             */
            @Override
            public void handle(MouseEvent event) {
                SceneChanger.changeCount(1);
                SceneChanger.setPath("src/main/resources/maps/map");
                SceneChanger.changeTo(SceneChanger.enumScene.GAME);
            }
        });
        panel.getChildren().get(2).setOnMouseClicked(new EventHandler<MouseEvent>() {
            /**
             * @param event Event de click sur le bouton
             *              Méthode qui charge le niveau correspondant
             */
            @Override
            public void handle(MouseEvent event) {
                SceneChanger.changeCount(2);
                SceneChanger.setPath("src/main/resources/maps/map");
                SceneChanger.changeTo(SceneChanger.enumScene.GAME);
            }
        });
        panel.getChildren().get(3).setOnMouseClicked(new EventHandler<MouseEvent>() {
            /**
             * @param event Event de click sur le bouton
             *              Méthode qui charge le niveau correspondant
             */
            @Override
            public void handle(MouseEvent event) {
                SceneChanger.changeCount(3);
                SceneChanger.setPath("src/main/resources/maps/map");
                SceneChanger.changeTo(SceneChanger.enumScene.GAME);
            }
        });

    }

    /**
     * @return Renvoie le nombre de fichier dans le dossier courant
     */
    public static int getFileCount(){
        return fileCount;
    }
}
