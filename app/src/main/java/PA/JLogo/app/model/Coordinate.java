package PA.JLogo.app.model;

public interface Coordinate<X, Y> {
    /**
     *
     * @return <code>true</code> if the coordinate pointed by <code>x</code> and
     *  <code>y</code> is out of the canvas
     */
    boolean isOutOfBounds();
}
