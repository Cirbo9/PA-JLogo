package src.main.java.PA.JLogo.app.model;

import src.main.java.PA.JLogo.app.util.Coordinate2D;
import src.main.java.PA.JLogo.app.util.CursorState;

import java.awt.Color;
import java.util.function.Function;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static src.main.java.PA.JLogo.app.util.CursorState.DOWN;
import static src.main.java.PA.JLogo.app.util.CursorState.UP;

public class SimpleCursor implements Cursor {
    private CursorState state;
    private Color color;
    private Color areaColor;
    private int direction;
    private int penSize;
    private Coordinate2D currentPosition;

    /**
     * Represents a translation function which takes a Coordinate and returns the same Coordinate translated
     * by the distance and the angle specified
     */
    private final Function<Integer, Coordinate2D> translation = (px) ->
            new Coordinate2D(this.currentPosition.x() + (px * cos(Math.toRadians(this.direction))),
            this.currentPosition.y() + (px * sin(Math.toRadians(this.direction))));

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

    @Override
    public void setPenColor(Color color) {
        this.color = color;
    }

    public void setPenSize(int t) {
        this.penSize = t;
    }

    @Override
    public void setFillColor(Color newAreaColor) {
        this.areaColor = newAreaColor;
    }

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

    @Override
    public Line forward(Canvas canvas, int px) {
        if (px == 0)
            return null;
        Coordinate2D start = this.currentPosition;
        this.currentPosition = this.translation.apply(px);
        return new Line(start, this.currentPosition, this.color, this.penSize);
    }
}
