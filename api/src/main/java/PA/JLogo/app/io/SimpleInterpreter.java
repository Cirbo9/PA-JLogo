package src.main.java.PA.JLogo.app.io;

import src.main.java.PA.JLogo.app.model.Canvas;
import src.main.java.PA.JLogo.app.model.*;
import src.main.java.PA.JLogo.app.util.Coordinate2D;
import src.main.java.PA.JLogo.app.util.Validations;

import java.awt.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SimpleInterpreter implements CanvasLoader {
    private StringTokenizer tokenizer;
    private int base;
    private int height;
    private ArrayList<AbstractColoredElement> elements;

    @Override
    public Canvas getCanvas(String s) throws Exception {
        this.tokenizer = new StringTokenizer(s, " ", false);
        elements = new ArrayList<>();
        getCanvasSize();
        Color color = getColor();
        while (tokenizer.hasMoreTokens()) {
            getNextElement();
        }
        return new SimpleCanvas(elements, color, base, height);
    }

    private void getCanvasSize() throws Exception {
        try {
            Validations.validateSyntax(tokenizer.nextToken(), "SIZE");
            this.base = Integer.parseInt(tokenizer.nextToken());
            this.height = Integer.parseInt(tokenizer.nextToken());
        } catch (Exception e) {
            throw new Exception("Error reading the file");
        }
    }

    private void getNextElement() throws Exception {
        switch (tokenizer.nextToken()) {
            case "POLYGON" -> elements.add(getArea());
            case "LINE" -> elements.add(getLine());
            default -> throw new Exception("Couldn't understand file");
        }
    }

    private Area getArea() {
        int numOfLines = Integer.parseInt(tokenizer.nextToken());
        ArrayList<Line> lines = new ArrayList<>();
        for (int i = 0; i < numOfLines; i++) {
            lines.add(getLine());
        }
        return new Area(getColor(), lines);
    }

    private Line getLine() {
        return new Line(
                getCoordinate2D(),          //start
                getCoordinate2D(),          //end
                getColor(),                 //penColor
                Integer.parseInt(tokenizer.nextToken()) //penSize
        );
    }

    private Coordinate2D getCoordinate2D() {
        return new Coordinate2D(
                Double.parseDouble(tokenizer.nextToken()),
                Double.parseDouble(tokenizer.nextToken())
        );
    }

    private Color getColor() {
        return new Color(
                Integer.parseInt(tokenizer.nextToken()),
                Integer.parseInt(tokenizer.nextToken()),
                Integer.parseInt(tokenizer.nextToken())
        );
    }
}
