

import javafx.scene.paint.Color;

public class Layer extends Grid {
    private int layerID;
    private boolean visible = true;

    //* Creates blank Layer with specified dimensions */
    public Layer(int ID, int x, int y) {
        this.layerID = ID;
        this.x = x;
        this.y = y;
        this.grid = new Color[x][y];
    }
    //* Creates a layer with a specified grid */
    public Layer(int ID, boolean visible, Color[][] grid, int x, int y) {
        this.layerID = ID;
        this.visible = visible;
        this.x = x;
        this.y = y;
        this.grid = grid;
    }
    //* Returns the layer's ID */
    public int getLayerID() {
        return this.layerID;
    }
    //* Changes the layer's ID */
    public int setLayerID(int ID) {
        this.layerID = ID;
        return this.layerID;
    }
    //* Returns the visibility status of the layer */
    public boolean isVisible() {
        return this.visible;
    }
    //* Changes the visibility status of the layer */
    public boolean setVisible(boolean visible) {
        this.visible = visible;
        return this.visible;
    }
}
