import java.awt.*;

public abstract class AbstractColoredElement implements ColoredElement {
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
}
