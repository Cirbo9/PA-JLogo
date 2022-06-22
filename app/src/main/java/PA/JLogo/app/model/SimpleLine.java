package PA.JLogo.app.model;

import PA.JLogo.app.util.Coordinate2D;

import java.awt.*;

public class SimpleLine extends AbstractColoredElement implements Line {
    final Coordinate2D start;
    final Coordinate2D end;
    int thickness;

    public SimpleLine(Coordinate2D start, Coordinate2D end, Color color, int thickness) {
        super(color);
        this.start = start;
        this.end = end;
        this.thickness = thickness;
    }

    public Coordinate2D getStartCoordinate() {
        return start;
    }

    public Coordinate2D getEndCoordinate() {
        return end;
    }

    public int getThickness() {
        return thickness;
    }

}