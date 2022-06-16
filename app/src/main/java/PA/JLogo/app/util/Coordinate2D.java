package PA.JLogo.app.util;

public class Coordinate2D<T extends Number> implements Coordinate<T> {
    private T x;
    private T y;

    public Coordinate2D(T x, T y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public T getX() {
        return this.x;
    }

    @Override
    public T getY() {
        return this.y;
    }

    @Override
    public void setX(T x) {
        this.x = x;
    }

    @Override
    public void setY(T y) {
        this.y = y;
    }
}