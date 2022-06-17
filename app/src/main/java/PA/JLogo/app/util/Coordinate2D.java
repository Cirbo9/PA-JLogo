package PA.JLogo.app.util;

public class Coordinate2D<T extends Number> implements Coordinate<T> {
    private T x;
    private T y;

    public Coordinate2D(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return this.x;
    }

    public T getY() {
        return this.y;
    }

    public void setX(T x) {
        this.x = x;
    }

    public void setY(T y) {
        this.y = y;
    }
}