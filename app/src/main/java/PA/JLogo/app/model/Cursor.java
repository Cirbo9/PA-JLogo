package PA.JLogo.app.model;

import PA.JLogo.app.util.Coordinate2D;
import PA.JLogo.app.util.CursorState;

public interface Cursor {

    CursorState getState();
    void up();
    void down();
    void setPosition(Coordinate2D c);
    void rotateLeft(int rotation);
    void rotateRight(int rotation);
    void forward(int px);
    void backward(int px);
}