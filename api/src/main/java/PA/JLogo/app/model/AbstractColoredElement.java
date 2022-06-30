package PA.JLogo.app.model;


import java.awt.Color;

public abstract class AbstractColoredElement implements ColoredElement {
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

    public boolean isFillable() {
        return (this instanceof Area);
    }

    public boolean isLine() {
        return (this instanceof Line);
    }

}
