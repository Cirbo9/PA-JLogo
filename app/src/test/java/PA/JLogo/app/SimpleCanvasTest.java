package PA.JLogo.app;

import PA.JLogo.app.model.SimpleCanvas;
import PA.JLogo.app.util.Coordinate2D;
import org.junit.jupiter.api.Test;


import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SimpleCanvasTest {

    SimpleCanvas s = new SimpleCanvas(new ArrayList<>(), Color.red, 1920, 1080);

    @Test
    public void testGetHomePosition() {
        Coordinate2D c = new Coordinate2D(1920/2.0, 1080/2.0);
        assertEquals(c, s.getHomePosition());
    }
}