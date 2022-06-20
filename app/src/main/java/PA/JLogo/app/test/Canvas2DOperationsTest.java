package PA.JLogo.app.test;

import PA.JLogo.app.util.Canvas2DOperations;
import PA.JLogo.app.util.Coordinate2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Canvas2DOperationsTest {

    Coordinate2D c1 = new Coordinate2D(0, 0);

    @Test
    public void testForwardTranslation() {
        assertThrows(NullPointerException.class, () -> Canvas2DOperations.forwardTranslation(null, 30, 100));
        assertThrows(IllegalArgumentException.class, () -> Canvas2DOperations.forwardTranslation(c1, 360, 100));
        Coordinate2D c2 = Canvas2DOperations.forwardTranslation(c1, 90, 100);
        System.out.println(c2);
        assertEquals("(0, 100)", c2.toString());
    }

    @Test
    public void testBackwardTranslation() {
        assertThrows(NullPointerException.class, () -> Canvas2DOperations.backwardTranslation(null, 30, 100));
        assertThrows(IllegalArgumentException.class, () -> Canvas2DOperations.backwardTranslation(c1, 360, 100));
        Coordinate2D c2 = Canvas2DOperations.backwardTranslation(c1, 90, 100);
        System.out.println(c2);
        assertEquals("(-0, -100)", c2.toString());
    }
}