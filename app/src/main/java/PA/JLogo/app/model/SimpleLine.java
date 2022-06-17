package PA.JLogo.app.model;

import PA.JLogo.app.util.Coordinate;

import java.awt.Color;

public class SimpleLine<T extends Number> extends AbstractColoredElement implements Line<T> {
    final Coordinate<T> start;
    final Coordinate<T> end;
    int thickness;

    public SimpleLine(Coordinate<T> start, Coordinate<T> end, Color color, int thickness) {
        super(color);
        this.start = start;
        this.end = end;
        this.thickness = thickness;
    }

    public Coordinate<T> getStartCoordinate() {
        return start;
    }

    public Coordinate<T> getEndCoordinate() {
        return end;
    }

    public int getThickness() {
        return thickness;
    }

}
