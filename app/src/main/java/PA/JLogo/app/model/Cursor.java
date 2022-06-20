package PA.JLogo.app.model;

import PA.JLogo.app.util.CursorState;
import PA.JLogo.app.util.RotationDirection;

public interface Cursor {

    void setState(CursorState state);
    void rotate(RotationDirection direction, int rotation);

    //TODO who has the responsibility of preserving cursor current position? cursor or canvas?
    //method getCurrentPosition() or something needs to get implemented here or in canvas
    //i should hurry. i can't be wasting all this time for this bullshit.
}
