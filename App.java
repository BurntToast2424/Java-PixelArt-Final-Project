

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
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
    PaletteHandler paletteHandler = new PaletteHandler();
    Rectangle current = new Rectangle(0, 0, 60, 60);
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

        // TextField tfName = new TextField("Untitled"); Maybe another time..
        // Label lblName = new Label("Artwork Name: ");
        // name.getChildren().addAll(lblName, tfName);
        // border.setTop(name);

        // Button btSaveArt = new Button("Save Artwork"); 
        // Button btLoadArt = new Button("Load Artwork");
        // Button btSavePalette = new Button("Save Palette");
        // Button btLoadPalette = new Button("Load Palette");
        // Button btView = new Button("View"); // Shows just the artwork, allowing for easier screenshot
        // buttonsBox.getChildren().addAll(btView, new Label("While viewing artwork, \n click to return to editor."));
        // border.setLeft(buttonsBox);

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                Rectangle pixel = new Rectangle(0, 0, 45, 45);
                pixel.setFill(artwork.getCurrentLayer().getColorAt(i, j));
                pixel.setOnMouseClicked(e -> colorPixelA(e));
                center.add(pixel, i, j);
            }
        }
        border.setCenter(center);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                Rectangle pixel = new Rectangle(0, 0, 60, 60);
                pixel.setFill(paletteHandler.getCurrenPalette().getColorAt(i, j));
                pixel.setOnMouseClicked(e -> colorPixelP(e));
                palette.add(pixel, i, j);
            }
        }
        current.setFill(paletteHandler.getColor());
        Circle colorpick = new Circle(30);
        Stage pickStage = new Stage();
        colorpick.setOnMouseClicked(e -> {
            pickStage.show();
            primaryStage.close();
        });
        Label lblCurrent = new Label("Current");
        Label lblSelector = new Label("Selector");
        Button btlinesShow = new Button("Show lines");
        Button btlinesHide = new Button("Hide lines");
        btlinesShow.setOnAction(e -> {
            center.setHgap(1);
            center.setVgap(1);
        });
        btlinesHide.setOnAction(e -> {
            center.setHgap(0);
            center.setVgap(0);
        });
        palette.add(current, 0, 5);
        palette.add(colorpick, 1, 5);
        palette.add(lblCurrent, 0, 6);
        palette.add(lblSelector, 1, 6);
        palette.add(btlinesShow, 0, 7);
        palette.add(btlinesHide, 1, 7);
        border.setRight(palette);

        // Make pickStage
        Pane bigPane = new VBox();
        StackPane textPane = new StackPane();
        textPane.setAlignment(Pos.CENTER);
        GridPane sliders = new GridPane();
        bigPane.setPadding(new Insets(15, 12.5, 15, 12.5));
        sliders.setPadding(new Insets(15, 12.5, 15, 12.5));
        Pane buttons = new HBox();
        // Make label and add it to pane
        Rectangle label = new Rectangle(60, 60);
        textPane.getChildren().add(label);
        bigPane.getChildren().add(textPane);
        // Make sliders and their labels
        Slider red = new Slider(0, 1, 0);
        Slider green = new Slider(0, 1, 0);
        Slider blue = new Slider(0, 1, 0);
        red.valueProperty().addListener(e -> label.setFill(new Color(red.getValue(), green.getValue(), blue.getValue(), 1)));
        green.valueProperty().addListener(e -> label.setFill(new Color(red.getValue(), green.getValue(), blue.getValue(), 1)));
        blue.valueProperty().addListener(e -> label.setFill(new Color(red.getValue(), green.getValue(), blue.getValue(), 1)));
        Label redLabel = new Label("Red");
        Label greenLabel = new Label("Green");
        Label blueLabel = new Label("Blue");
        // Add sliders to pane and pane to big pane
        sliders.add(redLabel, 0, 0);
        sliders.add(red, 1, 0);
        sliders.add(greenLabel, 0, 1);
        sliders.add(green, 1, 1);
        sliders.add(blueLabel, 0, 2);
        sliders.add(blue, 1, 2);
        bigPane.getChildren().add(sliders);
        // Make buttons
        Button btconfirm = new Button("Confirm");
        Button btcancel = new Button("Cancel");
        btconfirm.setOnAction(e -> {
            paletteHandler.setColor(new Color(red.getValue(), green.getValue(), blue.getValue(), 1));
            current.setFill(new Color(red.getValue(), green.getValue(), blue.getValue(), 1));
            primaryStage.show();
            pickStage.close();
        });
        btcancel.setOnAction(e -> {
            primaryStage.show();
            pickStage.close();
        });
        buttons.getChildren().addAll(btconfirm, btcancel);
        bigPane.getChildren().add(buttons);
        // Set pickscene and pickstage
        Scene pickScene = new Scene(bigPane);
        pickStage.setTitle("Pick a color");
        pickStage.setScene(pickScene);

        Scene scene = new Scene(border);
        primaryStage.setTitle("Pixel Art Maker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void colorPixelA(MouseEvent e) {
        Rectangle source = (Rectangle) e.getSource();
        if (e.getButton() == MouseButton.PRIMARY) {
            source.setFill(paletteHandler.getColor());
            artwork.getCurrentLayer().setColorAt(GridPane.getRowIndex(source), GridPane.getColumnIndex(source), paletteHandler.getColor());
        } else if (e.getButton() == MouseButton.SECONDARY) {
            current.setFill(source.getFill());
            paletteHandler.setColor((Color)source.getFill());
        }
    }
    private void colorPixelP(MouseEvent e) {
        Rectangle source = (Rectangle) e.getSource();
        if (e.getButton() == MouseButton.PRIMARY) {
            current.setFill(source.getFill());
            paletteHandler.setColor((Color)source.getFill());
        } else if (e.getButton() == MouseButton.SECONDARY) {
            source.setFill(paletteHandler.getColor());
            paletteHandler.getCurrenPalette().setColorAt(GridPane.getRowIndex(source), GridPane.getColumnIndex(source), paletteHandler.getColor());
        }
    }
    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }
}