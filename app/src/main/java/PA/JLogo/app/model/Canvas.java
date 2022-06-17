package PA.JLogo.app.model;

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
     * @param e
     */
    public void add(AbstractColoredElement e);

}
