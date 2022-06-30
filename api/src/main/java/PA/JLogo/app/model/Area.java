package src.main.java.PA.JLogo.app.model;

import java.awt.*;
import java.util.ArrayList;

public class Area extends AbstractColoredElement {

    private final ArrayList<Line> lines;

    public Area(Color color, ArrayList<Line> lines) {
        super(color);
        this.lines = lines;
    }

    /**
     * Retrieves the number of lines this enclosed Area is made up of
     * @return the number of lines this enclosed Area is made up of
     */
    public int numberOfLines() {
        return this.lines.size();
    }

    /**
     * Retrieves a List of the lines this enclosed Area is made up of
     * @return an ArrayList containing all the lines this enclosed Area is made up of. Note: only
     * the lines which are part of the external perimeter of the shape will be returned.
     */
    public ArrayList<Line> getLines() {
        return lines;
    }
}
