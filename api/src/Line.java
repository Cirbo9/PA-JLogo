import java.awt.*;

public abstract class Line extends AbstractColoredElement {
    Coordinate start;
    Coordinate end;
    int thickness;

    public Line(Coordinate start, Coordinate end, Color color, int thickness) {
        super(color);
        this.start = start;
        this.end = end;
        this.thickness = thickness;
    }

}
