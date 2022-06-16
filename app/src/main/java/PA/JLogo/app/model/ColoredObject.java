package PA.JLogo.app.model;

import java.awt.*;

public interface ColoredObject {
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
