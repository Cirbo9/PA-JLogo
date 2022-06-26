package PA.JLogo.app.model;

import PA.JLogo.app.util.Coordinate2D;
import java.awt.Color;

import java.util.List;

public interface Canvas {

    /**
     * resets to a clear canvas with default settings
     */
    void clear();

    /**
     * adds an element to the list of the user-made elements on the canvas
     * @param e the element to be added
     */
    void add(AbstractColoredElement e);
    int getBase();
    int getHeight();
    void setColor(Color bgColor);

    /**
     *
     * @return the Home position of the canvas
     */
    default Coordinate2D getHomePosition() {
        return new Coordinate2D(this.getBase() / 2, this.getHeight() / 2);
    }

    List<AbstractColoredElement> getElements();

}
