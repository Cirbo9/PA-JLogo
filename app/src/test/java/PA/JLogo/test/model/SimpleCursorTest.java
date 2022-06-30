package PA.JLogo.test.model;

import org.junit.jupiter.api.Test;
import src.main.java.PA.JLogo.app.model.SimpleCursor;
import src.main.java.PA.JLogo.app.util.Coordinate2D;
import src.main.java.PA.JLogo.app.util.CursorState;

import java.awt.*;

public class SimpleCursorTest {

    SimpleCursor cursor = new SimpleCursor(CursorState.DOWN, Color.BLACK, Color.WHITE, 0, 2, new Coordinate2D(0.0, 0.0));

    @Test
    public void testTranslation() {

    }

}