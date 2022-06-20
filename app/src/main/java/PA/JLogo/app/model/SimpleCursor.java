package PA.JLogo.app.model;

import PA.JLogo.app.util.CursorState;
import PA.JLogo.app.util.RotationDirection;

import java.awt.*;

public class SimpleCursor implements Cursor {
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

    @Override
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

    /**
     * Rotates the cursor into either left or right
     * @param direction left or right
     * @param rotation how much the cursor has to rotate
     */
    @Override
    public void rotate(RotationDirection direction, int rotation) {
        //TODO implement and change direction/rotation name
    }
}
