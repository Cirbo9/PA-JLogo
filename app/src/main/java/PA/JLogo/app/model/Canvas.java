package PA.JLogo.app.model;

import PA.JLogo.app.util.Coordinate2D;

import java.util.ArrayList;

public interface Canvas {

    /**
     * resets to a clear canvas with default settings
     */
    void clear();

    /**
     * @return an ArrayList containing all elements drawn by the user
     */
    ArrayList<AbstractColoredElement> toArrayList();

    /**
     * adds an element to the list of the user-made elements on the canvas
     * @param e the element to be added
     */
    void add(AbstractColoredElement e);
    int getBase();
    int getHeight();

    /**
     *
     * @return the Home position of the canvas
     */
    default Coordinate2D getHomePosition() {
        return new Coordinate2D(this.getBase() / 2, this.getHeight() / 2);
    }

}
