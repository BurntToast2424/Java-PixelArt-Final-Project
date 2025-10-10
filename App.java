

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

// Originally, there were going to be a lot more features. You know this.
// I realize that those would be very difficult for me to add. I have never made something like this before.
// I did still build the program in a way so that adding these features later wouldn't require too much rewriting.
// But for now, it remains simple. I am sorry.

public class App extends Application {
    Artwork artwork = new Artwork();
    public void start(Stage primaryStage) {
        BorderPane border = new BorderPane(); // To organise everything
        border.setPadding(new Insets(10, 10, 10, 10));
        VBox buttonsBox = new VBox(); // To hold the buttons on the left
        buttonsBox.setPadding(new Insets(10, 10, 10, 10));
        buttonsBox.setAlignment(Pos.CENTER_LEFT);
        buttonsBox.setSpacing(10);
        GridPane center = new GridPane(); // To hold and display the artwork
        center.setPadding(new Insets(10, 10, 10, 10));
        center.setAlignment(Pos.CENTER);
        center.setVgap(1);
        center.setHgap(1);
        GridPane palette = new GridPane(); // To hold and display the palette
        palette.setPadding(new Insets(10, 10, 10, 10));
        palette.setAlignment(Pos.CENTER_RIGHT);
        palette.setVgap(10);
        palette.setHgap(10);
        HBox name = new HBox(); // To hold the name
        name.setPadding(new Insets(10, 10, 10, 10));
        name.setAlignment(Pos.TOP_LEFT);

        TextField tfName = new TextField("Untitled");
        Label lblName = new Label("Artwork Name: ");
        name.getChildren().addAll(lblName, tfName);
        border.setTop(name);

        Button btSaveArt = new Button("Save Artwork");
        Button btLoadArt = new Button("Load Artwork");
        Button btSavePalette = new Button("Save Palette");
        Button btLoadPalette = new Button("Load Palette");
        Button btView = new Button("View"); // Shows just the artwork, allowing for easier screenshot
        buttonsBox.getChildren().addAll(btSaveArt, btLoadArt, btSavePalette, btLoadPalette, btView, new Label("While viewing artwork, \n click to return to editor."));
        border.setLeft(buttonsBox);

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                Rectangle pixel = new Rectangle(0, 0, 45, 45);
                pixel.setFill(Color.BLACK);
                // Handle clicking the pixel here
                center.add(pixel, i, j);
            }
        }
        border.setCenter(center);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                Rectangle pixel = new Rectangle(0, 0, 60, 60);
                pixel.setFill(Color.BLACK);
                // Handle clicking the pixel here
                palette.add(pixel, i, j);
            }
        }
        Rectangle current = new Rectangle(0, 0, 60, 60);
        Circle colorpick = new Circle(30);
        Label lblCurrent = new Label("Current");
        Label lblSelector = new Label("Selector");
        Button btPrevious = new Button("Previous");
        Button btNext = new Button("Next");
        palette.add(current, 0, 5);
        palette.add(colorpick, 1, 5);
        palette.add(lblCurrent, 0, 6);
        palette.add(lblSelector, 1, 6);
        palette.add(btPrevious, 0, 7);
        palette.add(btNext, 1, 7);
        border.setRight(palette);

        Scene scene = new Scene(border);
        primaryStage.setTitle("Pixel Art Maker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }
}