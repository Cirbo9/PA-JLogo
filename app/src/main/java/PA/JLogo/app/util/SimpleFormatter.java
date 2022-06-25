package PA.JLogo.app.util;

import PA.JLogo.app.model.AbstractColoredElement;
import PA.JLogo.app.model.Area;
import PA.JLogo.app.model.Canvas;
import PA.JLogo.app.model.Line;

import java.awt.*;
import java.text.DecimalFormat;

public class SimpleFormatter implements Formatter {

    private static final DecimalFormat coordinateFormatter = new DecimalFormat("0");

    /**
     * @return the Coordinate formatted with int values
     */
    @Override
    public String formatCoordinate(Coordinate2D c) {
        return coordinateFormatter.format(c.x()) + " " + coordinateFormatter.format(c.y());
    }

    /**
     * @return the formatted Line
     */
    @Override
    public String formatElement(AbstractColoredElement element) {
        if (element.isFillable())
            return this.formatArea(element);
        else if (element.isLine())
            return this.formatLine(element);
        return null;
    }

    private String formatLine(AbstractColoredElement element) {
        Line line = (Line)element;
        return  "LINE " + this.formatCoordinate(line.getStartCoordinate()) + " " +
                this.formatCoordinate(line.getEndCoordinate()) + " " +
                formatColor(line.getColor()) + " " + line.getThickness() + "\n";
    }

    private String formatArea(AbstractColoredElement element) {
        Area area = (Area)element;
        return "POLYGON " + area.numberOfLines() + formatColor(area.getColor()) + "\n" +
                area.getLines().stream()
                        .map(this::formatLine)
                        .reduce("", String::concat);

    }

    /**
     * Formats the canvas in order to save it into a file
     * @return the formatted Canvas
     */
    @Override
    public String formatCanvas(Canvas canvas) {
        String s = "SIZE " + canvas.getBase() + " " + canvas.getHeight() + " ";
        s += formatColor(canvas.getColor()) + "\n" ;
        s += this.formatAllSingleLines(canvas);
        s += this.formatAllAreas(canvas);
        return s;
    }

    private String formatAllSingleLines(Canvas canvas) {
        return canvas.getElements().stream()
                .filter(AbstractColoredElement::isFillable)
                .map(this::formatElement)
                .reduce("", String::concat);
    }

    private String formatAllAreas(Canvas canvas) {
        return canvas.getElements().stream()
                .filter(AbstractColoredElement::isLine)
                .map(this::formatElement)
                .reduce("", String::concat);
    }

    private String formatColor(Color c) {
        return c.getRed() + " " + c.getGreen() + " " + c.getBlue();
    }

}
