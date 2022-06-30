package src.main.java.PA.JLogo.app.model;

import src.main.java.PA.JLogo.app.util.Coordinate2D;
import src.main.java.PA.JLogo.app.util.CursorState;

import java.awt.*;

/**
 * Represents a Cursor, or turtle.
 * a Cursor has the following attributes:
 * STATE: if the next movement of the Cursor will draw a Line
 * ROTATION/DIRECTION: the angle at which the next Line will be drawn
 * COLOR: the color of the next Line
 * FILLCOLOR: the next enclosed Area to be created will be automatically filled with this color
 * PENSIZE: the size of the cursor
 */
public interface Cursor {

    /**
     *
     * @return the current state of this Cursor
     */
    CursorState getState();

    /**
     * Raises the Cursor from the Canvas. The next Cursor movement will draw a Line.
     */
    void up();

    /**
     * Lays the Cursor down on the Canvas. The next Cursor movement will not draw a Line and will
     * only change the cursor's position on the Canvas.
     */
    void down();

    /**
     * sets the color of the Cursor.
     * @param color the Color of the next Line to be drawn.
     */
    void setPenColor(Color color);

    /**
     * Sets the color which will be used to fill an enclosed area next time it will be created.
     * @param color the color to be set
     */
    void setFillColor(Color color);

    /**
     * sets the size of the Cursor (the thickness of the pen)
     * @param size the new size of the Cursor
     */
    void setPenSize(int size);

    /**
     * Rotates the Cursor counter-clockwise
     * @param rotation the degrees by which the Cursor has to rotate
     */
    void rotateLeft(int rotation);

    /**
     * Rotates the Cursor clockwise
     * @param rotation the degrees by which the Cursor has to rotate
     */
    void rotateRight(int rotation);

    /**
     * moves the Cursor to a new position, without drawing a Line even if the Cursor's state is DOWN
     * @param c the new location of the Cursor
     */
    void setPosition(Coordinate2D c);

    /**
     * Moves the Cursor forward and retrieves the resulting Line.
     * The canvas parameter is used to perform checks on whether the Line will be out of bounds.
     * @param canvas the canvas where the Line will be drawn.
     * @param px the distance the Cursor has to move.
     * @return <code>null</code> if the distance specified is zero, or the Cursor's state is not DOWN
     */
    Line forward(Canvas canvas, int px);
}
