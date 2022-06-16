package PA.JLogo.app.model;

import java.awt.*;

public abstract class AbstractColoredElement implements ColoredObject {
    /**
     * The color of the element
     */
    Color color;

    public AbstractColoredElement(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color newColor) {
        this.color = newColor;
    }
}
