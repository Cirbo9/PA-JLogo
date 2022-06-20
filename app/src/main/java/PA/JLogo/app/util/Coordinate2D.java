package PA.JLogo.app.util;

import java.text.DecimalFormat;

public class Coordinate2D implements Coordinate {
    private final double x;
    private final double y;

    private static final DecimalFormat df = new DecimalFormat("0");

    public Coordinate2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "(" + df.format(this.x) + ", " + df.format(this.y) + ")";
    }
}