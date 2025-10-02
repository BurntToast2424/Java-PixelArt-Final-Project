package PixelArt;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;

public class PaletteHandler {
    private List<Palette> palettes;
    private Palette currentPalette;
    private Color currentColor = new Color(0, 0, 0, 1);

    //* Create blank palette handler */
    public PaletteHandler() {
        this.palettes = new ArrayList<Palette>();
        this.palettes.add(new Palette(0));
        this.currentPalette = this.palettes.getFirst();
    }
    //* Load palette handler */
    public PaletteHandler(List<Palette> palettes) {
        this.palettes = palettes;
        this.currentPalette = this.palettes.getFirst();
    }
    //* Returns current color */
    public Color getColor() {
        return this.currentColor;
    }
    //* Sets current color */
    public Color setColor(Color color) {
        this.currentColor = color;
        return this.currentColor;
    }
    //* Returns a specific palette */
    public Palette getPalette(int n) {
        return this.palettes.get(n);
    }
    //* Replaces a palette */
    public Palette setPalette(int n, Palette palette) {
        this.palettes.set(n, palette);
        return this.palettes.get(n);
    }
    //* Return a list of all palettes */
    public List<Palette> getPalettes() {
        return this.palettes;
    }
    //* Adds a new palette */
    public Palette addNewPalette() {
        this.palettes.add(new Palette(this.palettes.size()));
        return this.palettes.getLast();
    }
    //* Adds a specific palette */
    public Palette addPalette(Palette palette) {
        this.palettes.add(palette);
        return this.palettes.getLast();
    }
    //* Removes a specific palette */
    public void removePalette(int n) {
        this.palettes.remove(n);
        for (int i = 0; i < this.palettes.size(); i++ ) {
            if (this.palettes.get(i).getPaletteID() != i) {
                this.palettes.get(i).setPaletteID(i);
            }
        }
    }
    //* Return the current palette */
    public Palette getCurrenPalette() {
        return this.currentPalette;
    }
    //* Sets the current palette */
    public Palette setCurrenPalette(int n) {
        this.currentPalette = this.palettes.get(n);
        return this.currentPalette;
    }
}
