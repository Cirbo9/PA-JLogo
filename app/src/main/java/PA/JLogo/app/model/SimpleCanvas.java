package PA.JLogo.app.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.function.Predicate;

public class SimpleCanvas implements Canvas {

    private ArrayList<AbstractColoredElement> elements;
    private final int base;
    private final int height;
    private Color color;

    Predicate<Line> makesUpArea = (line) -> {
        return false;
    };

    public SimpleCanvas(ArrayList<AbstractColoredElement> elements, Color color, int base, int height) {
        this.elements = elements;
        this.base = base;
        this.height = height;
        this.color = color;
    }

    /**
     * @return the base of the canvas
     */
    @Override
    public int getBase() {
        return this.base;
    }

    /**
     * @return the height of the canvas
     */
    @Override
    public int getHeight() {
        return this.height;
    }

    /**
     * @return the background color of the canvas
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * @param newColor the new background color of the canvas
     */
    public void setColor(Color newColor) {
        this.color = newColor;
    }

    /**
     * Clears the canvas, in other words deletes all the user-made elements
     */
    @Override
    public void clear() {
        this.elements.clear();
    }

    /**
     * @return the canvas as an ArrayList of user-made elements
     */
    @Override
    public ArrayList<AbstractColoredElement> toArrayList() {
        return this.elements;
    }

    /**
     * @param e the element to be added to the canvas
     */
    @Override
    public void add(AbstractColoredElement e) {
        this.elements.add(e);
    }

}
