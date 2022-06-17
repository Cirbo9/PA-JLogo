package PA.JLogo.app.model;

import java.awt.*;

public abstract class AbstractColoredElement {
    /**
     * The color of the element
     */
    Color color;

    public AbstractColoredElement(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
