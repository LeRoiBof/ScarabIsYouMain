package org.scarab;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
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
import java.util.Set;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    public static Stage primaryStage;
    private final BorderPane root = new BorderPane();
    private final Font titleFont = Font.font("Lucida Sans Unicode", FontWeight.BOLD,25);
    private final CustomButton play = new CustomButton("PLAY", titleFont);
    private final CustomButton quit = new CustomButton("QUIT", titleFont);
    private final CustomButton credits = new CustomButton("CREDITS", titleFont);
    static MenuScene menuScene = new MenuScene();
    static CreditsScene creditsScene = new CreditsScene();
    static SettingsScene settingsScene = new SettingsScene();
    static GameScene gameScene = new GameScene();

    @Override
    public void start(Stage _primaryStage) throws Exception {
        ///Stage init
        this.primaryStage = _primaryStage;
        primaryStage.setTitle("Scarab Is You");
        primaryStage.getIcons().add(new Image (new FileInputStream("src/main/resources/assets/menu/scarablogo.jpg")));
        primaryStage.setWidth(1280);
        primaryStage.setHeight(720);
        root.setPadding(new Insets(20));


        ///Scene opening

        primaryStage.setScene(menuScene);
        primaryStage.show();

    }
}
