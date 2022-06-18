package PA.JLogo.app.model;

import PA.JLogo.app.util.CursorState;
import PA.JLogo.app.util.RotationDirection;

public interface Cursor {

    void setCursorState(CursorState state);
    void rotate(RotationDirection direction, int rotation);
}
