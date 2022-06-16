package PA.JLogo.app.model;

import PA.JLogo.app.util.CursorState;

import java.awt.*;

public class SimpleCursor {
    private CursorState state;
    private Color color;
    private Color areaColor;
    private int direction;

    public SimpleCursor(CursorState state, Color color, Color areaColor, int direction) {
        this.state = state;
        this.color = color;
        this.areaColor = areaColor;
        this.direction = direction;
    }

    public CursorState getState() {
        return state;
    }

    public void setState(CursorState state) {
        this.state = state;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     *
     * @return the current color used to fill an enclosed area when it is created.
     */
    public Color getAreaColor() {
        return areaColor;
    }

    /**
     * Sets the color which will be used to fill an enclosed area next time it will be created.
     * @param newAreaColor the color to be set
     */
    public void setAreaColor(Color newAreaColor) {
        this.areaColor = newAreaColor;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
