package PixelArt;

import javafx.scene.paint.Color;

public abstract class Grid {
    protected Color[][] grid;
    protected int x;
    protected int y;

    //* Create default Grid */
    public Grid() {
        this.grid = new Color[15][15];
        this.x = 15;
        this.y = 15;
    }
    //* Create specific sized Grid */
    public Grid(int x, int y) {
        this.grid = new Color[x][y];
        this.x = x;
        this.y = y;
    }
    //* Create specific Grid from array */
    public Grid(Color[][] grid) {
        this.grid = grid;
        this.x = grid.length;
        this.y = grid[0].length;
    }
    //* Return array of Grid */
    public Color[][] getGrid() {
        return this.grid;
    }
    //* Set new array for Grid */
    public Color[][] setGrid(Color[][] grid) {
        this.grid = grid;
        this.x = this.grid.length;
        this.y = this.grid[0].length;
        return this.grid;
    }
    //* Returns the color at a specific coordinate */
    public Color getColorAt(int x, int y) {
        return this.grid[x][y];
    }
    //* Sets the color at a specific coordinate */
    public Color setColorAt(int x, int y, Color color) {
        this.grid[x][y] = color;
        return this.grid[x][y];
    }
    //* Returns x */
    public int getX() {
        return this.x;
    }
    //* Sets x (Not recommended for use) */
    public void setX(int x) {
        this.x = x;
    }
        //* Returns y */
    public int getY() {
        return this.y;
    }
    //* Sets y (Not recommended for use) */
    public void sety(int y) {
        this.y = y;
    }
}
