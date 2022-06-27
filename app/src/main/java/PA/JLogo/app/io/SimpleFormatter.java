package PA.JLogo.app.io;

import PA.JLogo.app.model.AbstractColoredElement;
import PA.JLogo.app.model.Area;
import PA.JLogo.app.model.Canvas;
import PA.JLogo.app.model.Line;
import PA.JLogo.app.util.Coordinate2D;

import java.awt.Color;

import java.text.DecimalFormat;

public class SimpleFormatter implements CanvasWriter {

    private final DecimalFormat coordinateFormatter = new DecimalFormat("0");

    public SimpleFormatter() {
    }

    /**
     * @return a String representing the Coordinate, formatted with int values
     */
    public String formatCoordinate(Coordinate2D c) {
        return coordinateFormatter.format(c.x()) + " " + coordinateFormatter.format(c.y());
    }

    /**
     * Formats an element such as a Line or an enclosed Area
     * @return a String containing the formatted element
     */
    public String formatElement(AbstractColoredElement element) {
        if (element.isFillable())
            return this.formatArea(element);
        else if (element.isLine())
            return this.formatLine(element);
        return null;
    }

    /**
     * Formats a Line
     * @param element the Line to be formatted
     * @return a String containing the formatted Line
     */
    private String formatLine(AbstractColoredElement element) {
        Line line = (Line)element;
        return  "LINE " + this.formatCoordinate(line.getStartCoordinate()) + " " +
                this.formatCoordinate(line.getEndCoordinate()) + " " +
                formatColor(line.getColor()) + " " + line.getThickness() + "\n";
    }

    /**
     * Formats an enclosed Area element
     * @param element the enclosed Area to be formatted
     * @return a String containing the formatted enclosed Area
     */
    private String formatArea(AbstractColoredElement element) {
        Area area = (Area)element;
        return "POLYGON " + area.numberOfLines() + formatColor(area.getColor()) + "\n" +
                area.getLines().stream()
                        .map(this::formatLine)
                        .reduce("", String::concat);
    }

    /**
     * Formats the canvas in order to save it into a file
     * @return a String containing the formatted Canvas
     */
    public String formatCanvas(Canvas canvas) {
        String s = "SIZE " + canvas.getBase() + " " + canvas.getHeight() + " ";
        s += formatColor(canvas.getColor()) + "\n" ;
        s += this.formatAllSingleLines(canvas);
        s += this.formatAllAreas(canvas);
        return s;
    }

    /**
     * Cycles through the canvas and formats all the single Lines that are not making up an enclosed Area. syntax:
     * <code>LINE x1 y1 x2 y2 R G B PENSIZE</code> example:
     * <code>LINE 500 400 510 400 0 0 0 2</code>
     * @param canvas the canvas
     * @return a String containing a list of all the formatted single Lines that are not making up an enclosed Area
     */
    private String formatAllSingleLines(Canvas canvas) {
        return canvas.getElements().stream()
                .filter(AbstractColoredElement::isFillable)
                .map(this::formatElement)
                .reduce("", String::concat);
    }

    /**
     * Cycles through the canvas and formats all the enclosed Areas encountered.
     * @param canvas the canvas
     * @return a String containing a list of all the formatted enclosed Areas
     */
    private String formatAllAreas(Canvas canvas) {
        return canvas.getElements().stream()
                .filter(AbstractColoredElement::isLine)
                .map(this::formatElement)
                .reduce("", String::concat);
    }

    /**
     * Formats a Color as three byte values. example:
     * <code>255 255 255</code> (white)
     * @param c the color to be formatted
     * @return a String containing the formatted Color
     */
    private String formatColor(Color c) {
        return c.getRed() + " " + c.getGreen() + " " + c.getBlue();
    }

}
