package PA.JLogo.app.util;

import PA.JLogo.app.model.AbstractColoredElement;
import PA.JLogo.app.model.Area;
import PA.JLogo.app.model.Canvas;
import PA.JLogo.app.model.Line;

public interface Formatter {

    String formatCoordinate(Coordinate2D c);
    String formatElement(AbstractColoredElement element);
    String formatCanvas(Canvas c);

}
