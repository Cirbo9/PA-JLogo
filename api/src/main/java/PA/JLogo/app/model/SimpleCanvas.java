package PA.JLogo.app.model;

import java.awt.Color;

import java.util.ArrayList;
import java.util.List;

public class SimpleCanvas implements Canvas {

    private ArrayList<AbstractColoredElement> elements;
    private final int base;
    private final int height;
    private Color color;

    public SimpleCanvas(ArrayList<AbstractColoredElement> elements, Color color, int base, int height) {
        this.elements = elements;
        this.base = base;
        this.height = height;
        this.color = color;
    }

    @Override
    public int getBase() {
        return this.base;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public List<AbstractColoredElement> getElements() {
        return this.elements;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setColor(Color newColor) {
        this.color = newColor;
    }

    @Override
    public void clear() {
        this.elements.clear();
    }

    @Override
    public void add(AbstractColoredElement e) {
        this.elements.add(e);
    }

}
