

import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;

public class Artwork extends Grid {
    private List<Layer> layers;
    private Layer currentLayer;
    private String name;

    //* Creates a default, blank artwork */
    public Artwork() {
        this.grid = new Color[15][15];
        this.x = 15;
        this.y = 15;
        this.layers = new ArrayList<Layer>();
        this.layers.add(new Layer(0, 15, 15));
        this.currentLayer = this.layers.getFirst();
        this.name = "Untitled";
    }
    //* Creates a blank artwork of a specific size */
    public Artwork(int x, int y) {
        this.grid = new Color[x][y];
        this.x = x;
        this.y = y;
        this.layers = new ArrayList<Layer>();
        this.layers.add(new Layer(0, x, y));
        this.currentLayer = this.layers.getFirst();
        this.name = "Untitled";
    }
    //* Load an existing artwork */
    public Artwork(List<Layer> layers, String name, int x, int y) {
        this.grid = new Color[x][y];
        this.x = x;
        this.y = y;
        this.layers = layers;
        this.currentLayer = this.layers.getFirst();
        this.name = name;
    }
    //* Return a specific layer */
    public Layer getLayer(int n) {
        return this.layers.get(n);
    }
    //* Replace a specific layer */
    public Layer setLayer(int n, Layer layer) {
        this.layers.set(n, layer);
        return this.layers.get(n);
    }
    //* Return a list of all layers */
    public List<Layer> getLayers() {
        return this.layers;
    }
    //* Adds a new layer */
    public Layer addNewLayer() {
        this.layers.add(new Layer(this.layers.size(), x, y));
        return this.layers.getLast();
    }
    //* Adds a specific layer */
    public Layer addLayer(Layer layer) {
        this.layers.add(layer);
        return this.layers.getLast();
    }
    //* Removes a specific layer */
    public void removeLayer(int n) {
        this.layers.remove(n);
        for (int i = 0; i < this.layers.size(); i++ ) {
            if (this.layers.get(i).getLayerID() != i) {
                this.layers.get(i).setLayerID(i);
            }
        }
    }
    //* Return the current layer */
    public Layer getCurrentLayer() {
        return this.currentLayer;
    }
    //* Sets the current layer */
    public Layer setCurrentLayer(int n) {
        this.currentLayer = this.layers.get(n);
        return this.currentLayer;
    }
    //* Returns the name of the artwork */
    public String getName() {
        return this.name;
    }
    //* Replaces the current name */
    public String setName(String name) {
        this.name = name;
        return this.name;
    }
}
