package PA.JLogo.app.model;

import java.awt.*;
import java.util.ArrayList;

public class Area extends AbstractColoredElement {

    private ArrayList<Line> lines;

    public Area(Color color, ArrayList<Line> lines) {
        super(color);
        this.lines = lines;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public void setLines(ArrayList<Line> lines) {
        this.lines = lines;
    }
}
