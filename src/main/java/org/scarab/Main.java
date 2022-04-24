package org.scarab;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import javax.imageio.stream.FileImageInputStream;
import java.io.FileInputStream;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private final BorderPane root = new BorderPane();
    private final VBox panel = new VBox();
    private final Button play = new Button("PLAY");
    private final Button quit = new Button("QUIT");
    private final Font titleFont = Font.font("Lucida Sans Unicode", FontWeight.BOLD,25);
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        ///Stage init
        primaryStage.setTitle("Scarab Is You");
        primaryStage.getIcons().add(new Image (new FileInputStream("src/main/resources/assets/menu/scarablogo.jpg")));
        primaryStage.setMinHeight(760);
        primaryStage.setMinWidth(1290);
        primaryStage.setMaxHeight(760);
        primaryStage.setMaxWidth(1290);
        root.setPadding(new Insets(20));

        /// Button settings
        play.setFont(titleFont);
        play.setPrefSize(300,50);
        play.setShape(new Polygon(100.0,0.0,200.0,0.0,170.0,30.0,70.0,30.0));
        quit.setFont(titleFont);
        quit.setPrefSize(300,50);
        quit.setShape(new Polygon(100.0,0.0,200.0,0.0,170.0,30.0,70.0,30.0));
        panel.getChildren().addAll(play,quit);
        panel.setAlignment(Pos.TOP_CENTER);
        panel.setPadding(new Insets(50,0,50,0));
        root.setCenter(panel);

        ///Background settings
        root.setBackground(new Background(
                new BackgroundImage(
                        new Image(new FileInputStream("src/main/resources/assets/menu/menu.png")),
                        BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
                        new BackgroundPosition(Side.LEFT,0,true,Side.BOTTOM,0,true),
                        new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO,true,true,false,true))));

        ///Title settings
        Image title = new Image(new FileInputStream("src/main/resources/assets/menu/menutitle.png"));
        ImageView titleView = new ImageView(title);
        BorderPane.setAlignment(titleView,Pos.CENTER);
        root.setTop(titleView);



        ///Scene opening
        Scene scene = new Scene(root,1290,760);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
