package src.main.java.PA.JLogo.app.model;


import src.main.java.PA.JLogo.app.util.Coordinate2D;

import java.awt.*;
import java.util.List;

/**
 * Represents a Canvas.
 * The user will be able to draw Lines and shapes, which will be added to this Canvas' List by the add() method.
 * This interface currently represents a two-dimensional Canvas.
 */
public interface Canvas {

    /**
     * Deletes all Lines and shapes drawn by the user.
     */
    void clear();

    /**
     * adds an element to the list of the user-made elements on the canvas
     * @param e the element to be added
     */
    void add(AbstractColoredElement e);

    /**
     * @return the size in pixels of the base of the Canvas
     */
    int getBase();

    /**
     * @return the size in pixels of the height of the Canvas
     */
    int getHeight();
    Color getColor();
    void setColor(Color bgColor);

    /**
     * Retrieves the Home position of the canvas, which is located at the center of the Canvas.
     * @return the Home position of the canvas
     */
    default Coordinate2D getHomePosition() {
        return new Coordinate2D(this.getBase() / 2, this.getHeight() / 2);
    }

    /**
     * Retrieves the List of all the elemets drawn so far by the user.
     * @return a List containing all the elements currently in the canvas.
     */
    List<AbstractColoredElement> getElements();

}
