package PA.JLogo.app.util;

public interface Coordinate<T extends Number> {
    T getX();
    T getY();
    void setX(T x);
    void setY(T y);
}
