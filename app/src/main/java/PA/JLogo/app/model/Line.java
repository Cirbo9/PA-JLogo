package PA.JLogo.app.model;

import PA.JLogo.app.util.Coordinate;

public interface Line<T extends Number> {
    Coordinate<T> getStartCoordinate();
    Coordinate<T> getEndCoordinate();
}
