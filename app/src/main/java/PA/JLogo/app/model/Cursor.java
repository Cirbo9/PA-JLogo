package PA.JLogo.app.model;

import PA.JLogo.app.util.Coordinate2D;
import PA.JLogo.app.util.CursorState;

import java.awt.*;

public interface Cursor {

    CursorState getState();
    void up();
    void down();
    void setPenColor(Color color);
    void setFillColor(Color color);
    void rotateLeft(int rotation);
    void rotateRight(int rotation);
    void setPosition(Coordinate2D c);
    Line forward(Canvas canvas, int px);
    Line backward(Canvas canvas, int px);
}
