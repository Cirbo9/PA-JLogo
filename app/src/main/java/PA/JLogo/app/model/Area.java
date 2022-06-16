package PA.JLogo.app.model;

import java.awt.*;
import java.util.ArrayList;

public class Area<T extends Number> extends AbstractColoredElement {

    private ArrayList<Line<T>> lines;

    public Area(Color color, ArrayList<Line<T>> lines) {
        super(color);
        this.lines = lines;
    }

    public ArrayList<Line<T>> getLines() {
        return lines;
    }

    public void setLines(ArrayList<Line<T>> lines) {
        this.lines = lines;
    }
}
