package PA.JLogo.app.model;

import java.awt.*;
import java.util.ArrayList;

public interface Canvas {

    /**
     *
     * @return the base value of the canvas
     */
    int getBase();

    /**
     *
     * @return the height value of the canvas
     */
    int getHeight();

    /**
     *
     * @return the background color of the canvas
     */
    Color getColor();

    /**
     * resets to a clear canvas with default settings
     */
    void clear();

    /**
     *
     * @return the canvas info in a format which is ready to be saved in memory
     */
    String toString();

    /**
     * @return an ArrayList containing all elements drawn by the user
     */
    ArrayList<AbstractColoredElement> toArrayList();

    /**
     * adds an element to the list of the user-made elements on the canvas
     * @param e
     */
    public void add(AbstractColoredElement e);

}
