package org.scarab;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PauseScene extends MenuConstructor {
    private final static BorderPane root = new BorderPane();
    private final VBox panel = new VBox();
    private final CustomButton save = new CustomButton("SAVE");
    private final CustomButton quit = new CustomButton("QUIT");
    private final CustomButton reload = new CustomButton("RELOAD");
    private final CustomButton continu = new CustomButton("CONTINUE");

    public PauseScene() {
        super(root);
        panel.setSpacing(10);
        panel.getChildren().addAll(continu,save,reload,quit);
        panel.setAlignment(Pos.TOP_CENTER);
        root.setCenter(panel);

        quit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Main.primaryStage.close();
            }
        });
        save.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Map.save();
            }
        });
    }
}
