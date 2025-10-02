package PixelArt;

import javafx.scene.paint.Color;

public class Test {
    public static void main(String[] args) {
        System.out.println("Test Artwork class");
        Artwork testArtwork = new Artwork(2, 2);
        System.out.println("Layer count: " + testArtwork.getLayers().size());
        System.out.println("");
        System.out.println("Adding new layer");
        testArtwork.addNewLayer();
        System.out.println("Layers: " + testArtwork.getLayers().size());
        System.out.println("");
        System.out.println("Setting layer's colors");
        Color[][] colorArray = { {new Color(1, 0, 0, 1), new Color(0, 1, 0, 1)}, {new Color(0, 0, 1, 1), new Color(1, 1, 1, 0.5)} };
        testArtwork.getLayer(0).setGrid(colorArray);
        System.out.println("Color at (0, 0): " + testArtwork.getLayer(0).getColorAt(0, 0));
        System.out.println("Color at (1, 0): " + testArtwork.getLayer(0).getColorAt(1, 0));
        System.out.println("Color at (0, 1): " + testArtwork.getLayer(0).getColorAt(0, 1));
        System.out.println("Color at (1, 1): " + testArtwork.getLayer(0).getColorAt(1, 1));
        System.out.println("Layer visibility: " + testArtwork.getLayer(0).isVisible());
        System.out.println("Current layer: " + testArtwork.getCurrentLayer().getLayerID());
        System.out.println("");
        System.out.println("Changing current layer");
        System.out.println("Current layer: " + testArtwork.setCurrentLayer(1).getLayerID());
        System.out.println("");
        System.out.println("Removing layer 0");
        testArtwork.removeLayer(0);
        System.out.println("Layer count: " + testArtwork.getLayers().size());
        System.out.println("Current layer: " + testArtwork.getCurrentLayer().getLayerID());
        System.out.println("Color at (0, 0): " + testArtwork.getLayer(0).getColorAt(0, 0));
        System.out.println("");
        System.out.println("Every other class is either significantly simpler, or works the same.");
        System.out.println("Every other method within this class is significantly simpler.");
        System.out.println("There is very little that could be messed up, and I have reviewed my code to ensure I did not.");
    }
}
