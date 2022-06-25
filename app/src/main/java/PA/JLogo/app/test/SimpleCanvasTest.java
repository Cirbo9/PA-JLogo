package PA.JLogo.app.test;

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
        Coordinate2D c = new Coordinate2D(1920/2, 1080/2);
        assertEquals(c.x(), s.getHomePosition().x());
        assertEquals(c.y(), s.getHomePosition().y());
    }




}