package PA.JLogo.app.model;

import java.awt.*;

public interface ColoredElement {
    /**
     *
     * @return the color of the element
     */
    Color getColor();

    /**
     * Changes the color of an element
     * @param newColor the new color of the element
     */
    void setColor(Color newColor);
}
