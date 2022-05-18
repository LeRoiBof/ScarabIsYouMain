package org.scarab;

import javafx.application.Preloader;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class LoadScene extends MenuConstructor{
    private static final BorderPane root = new BorderPane();
    private final CustomButton back = new CustomButton("BACK");
    public LoadScene(){
        super(root);

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
