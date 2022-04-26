package org.scarab;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class CustomButton extends Button {
        public CustomButton (String name, Font titleFont){
        super(name);
        setFont(titleFont);
        setPrefSize(300,50);
        setShape(new Polygon(100.0,0.0,200.0,0.0,170.0,30.0,70.0,30.0));
        setTextFill(Color.WHITE);
        setStyle("-fx-background-color: #0D0D0E; ");
        setOpacity(0.7);
    }
}
