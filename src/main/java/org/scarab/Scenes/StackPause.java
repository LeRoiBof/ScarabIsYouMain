package org.scarab.Scenes;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.scarab.CustomButton;
import org.scarab.Elements.Elements;
import org.scarab.Main;
import org.scarab.Map;
import org.scarab.SceneChanger;

public class StackPause extends BorderPane {
    private VBox panel = new VBox();
    private final CustomButton save = new CustomButton("SAVE");
    private final CustomButton quit = new CustomButton("QUIT");
    private final CustomButton reload = new CustomButton("RELOAD");
    private final CustomButton continu = new CustomButton("CONTINUE");

    /**
     * Constructeur qui crée une nouvelle scène qui sera superposée à une autre
     */
    public StackPause(){
        this.setHeight(800);
        this.setWidth(800);
        Rectangle rectangle = new Rectangle(800,800);
        rectangle.setFill(Color.BLACK);
        rectangle.setOpacity(0.3);
        this.getChildren().add(rectangle);
        panel.setSpacing(10);
        panel.getChildren().addAll(continu,save,reload,quit);
        panel.setAlignment(Pos.CENTER);
        this.setCenter(panel);

        quit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            /**
             * @param event Event de click sur le bouton
             *              Méthode qui ferme la fenêtre
             */
            @Override
            public void handle(MouseEvent event) {
                Main.primaryStage.close();
            }
        });
        save.setOnMouseClicked(new EventHandler<MouseEvent>() {
            /**
             * @param event Event de click sur le bouton
             *              Méthode qui sauvegarde la partie et revient au menu. Les mouvements sont rétablis
             */
            @Override
            public void handle(MouseEvent event) {
                Map.save();
                Elements.changeMove(true);
                Map.clearElements();
                SceneChanger.changeTo(SceneChanger.enumScene.MENU);
            }
        });
        continu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            /**
             * @param event Event de click sur le bouton
             *              Méthode qui ferme la scène de pause et relance le jeu. Les mouvements sont rétablis
             */
            @Override
            public void handle(MouseEvent event) {
                GameScene.removePause();
                Elements.changeMove(true);
            }
        });
        reload.setOnMouseClicked(new EventHandler<MouseEvent>() {
            /**
             * @param event Event de click de souris
             *              Methode permettant de recommencer un niveau. Les mouvements sont rétablis
             */
            @Override
            public void handle(MouseEvent event) {
                Map.clearElements();
                Elements.changeMove(true);
                SceneChanger.setPath("src/main/resources/maps/map");
                SceneChanger.changeTo(SceneChanger.enumScene.GAME);
            }
        });

    }
}
