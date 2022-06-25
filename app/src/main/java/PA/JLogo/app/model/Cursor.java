package PA.JLogo.app.model;

import PA.JLogo.app.util.Coordinate2D;
import PA.JLogo.app.util.CursorState;

public interface Cursor {

    CursorState getState();
    void up();
    void down();
    void home();
    void rotateLeft(int rotation);
    void rotateRight(int rotation);
    Line forward(Canvas canvas, int px);
    Line backward(Canvas canvas, int px);
}
