package PixelArt;

import javafx.scene.paint.Color;

public class Palette extends Grid {
    private int paletteID;

    //* Creates a blank palette */
    public Palette(int ID) {
        this.paletteID = ID;
        this.x = 5;
        this.y = 2;
        this.grid = new Color[5][2];
    }
    //* Load a palette */
    public Palette(int ID, Color[][] grid) {
        this.paletteID = ID;
        this.x = 5;
        this.y = 2;
        this.grid = grid;
    }
    //* Returns palette id */
    public int getPaletteID() {
        return this.paletteID;
    }
    //* Sets palette id */
    public int setPaletteID(int ID) {
        this.paletteID = ID;
        return this.paletteID;
    }
}
