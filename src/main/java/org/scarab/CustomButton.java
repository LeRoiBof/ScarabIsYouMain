package org.scarab;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class CustomButton extends Button {
        private final Font titleFont = Font.font("Lucida Sans Unicode", FontWeight.BOLD,25);
        public CustomButton (String name){
        super(name);
        setFont(titleFont);
        setPrefSize(300,50);
        setShape(new Polygon(100.0,0.0,200.0,0.0,170.0,30.0,70.0,30.0));
        setTextFill(Color.WHITE);
        setStyle("-fx-background-color: #0D0D0E; ");
        setOpacity(0.7);
        setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                        setOpacity(0.9);
                }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                        setOpacity(0.7);
                }
        });
    }
}
