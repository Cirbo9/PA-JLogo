package PA.JLogo.app.model;

import PA.JLogo.app.util.Coordinate2D;
import PA.JLogo.app.util.CursorState;
import java.awt.Color;

import java.util.function.Function;

import static PA.JLogo.app.util.CursorState.*;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class SimpleCursor implements Cursor {
    private CursorState state;
    private Color color;
    private Color areaColor;
    private int direction;
    private int penSize;
    private Coordinate2D currentPosition;


    private Function<Integer, Coordinate2D> translation = (px) -> {
        if (px == 0)
            return this.currentPosition;
        return new Coordinate2D(this.currentPosition.x() + (px * cos(Math.toRadians(this.direction))),
                this.currentPosition.y() + (px * sin(Math.toRadians(this.direction))));
    };

    public SimpleCursor(CursorState state, Color color, Color areaColor, int direction, int penSize, Coordinate2D position) {
        this.state = state;
        this.color = color;
        this.areaColor = areaColor;
        this.direction = direction;
        this.currentPosition = position;
        this.penSize = penSize;
    }

    @Override
    public CursorState getState() {
        return this.state;
    }

    @Override
    public void up() {
        this.state = UP;
    }

    @Override
    public void down() {
        this.state = DOWN;
    }

    @Override
    public void setPosition(Coordinate2D c) {
        this.currentPosition = c;
    }

    public Color getPenColor() {
        return color;
    }

    @Override
    public void setPenColor(Color color) {
        this.color = color;
    }

    public void setPenSize(int t) {
        this.penSize = t;
    }

    /**
     * @return the current color used to fill an enclosed area when it is created.
     */
    public Color getFillColor() {
        return areaColor;
    }

    /**
     * Sets the color which will be used to fill an enclosed area next time it will be created.
     *
     * @param newAreaColor the color to be set
     */
    @Override
    public void setFillColor(Color newAreaColor) {
        this.areaColor = newAreaColor;
    }

    public int getDirection() {
        return direction;
    }

    /**
     * Rotates the cursor clockwise by [rotation] degrees
     *
     * @param rotation how much the cursor has to rotate
     */
    @Override
    public void rotateLeft(int rotation) {
        this.direction = (this.direction + rotation) % 360;
    }

    @Override
    public void rotateRight(int rotation) {
        int r = rotation % 360;
        if (r > this.direction)
            this.direction += 360;
        this.direction -= r;
    }

    /**
     * @param px how much the cursor has to move forward
     */
    @Override
    public Line forward(Canvas canvas, int px) {
        return new Line(this.currentPosition, translation.apply(px), this.color, this.penSize);
    }

    /**
     * @param px how much the cursor has to move backward
     */
    @Override
    public Line backward(Canvas canvas, int px) {
        return new Line(this.currentPosition, translation.apply(-px), this.color, this.penSize);
    }
}
