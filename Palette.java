

import javafx.scene.paint.Color;

public class Palette extends Grid {
    private int paletteID;

    //* Creates a blank palette */
    public Palette(int ID) {
        this.paletteID = ID;
        this.x = 2;
        this.y = 5;
        this.grid = new Color[2][5];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                this.grid[i][j] = Color.BLACK;
            }
        }
    }
    //* Load a palette */
    public Palette(int ID, Color[][] grid) {
        this.paletteID = ID;
        this.x = 2;
        this.y = 5;
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
