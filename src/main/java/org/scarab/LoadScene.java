package org.scarab;

import javafx.application.Preloader;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.io.File;
import java.util.Objects;

public class LoadScene extends MenuConstructor{
    private static final BorderPane root = new BorderPane();
    private final CustomButton back = new CustomButton("BACK");
    private final HBox panel = new HBox();
    public LoadScene(){
        super(root);
        int fileCount = Objects.requireNonNull(new File("src/main/resources/maps").list()).length;

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
            @Override
            public void handle(MouseEvent event) {
                SceneChanger.changeTo(SceneChanger.enumScene.MENU);
            }
        });

    }
}
