package PA.JLogo.app.util;
import static java.lang.Math.*;

public class Canvas2DOperations {
    /**
     * Performs a forward translation of a single coordinate
     * @param start the start coordinate
     * @param d (direction) the rotation of the cursor
     * @param px the translation (in pixels) to be performed
     * @return the coordinate after the translation has been performed
     */
    public Coordinate2D forwardTranslation(Coordinate2D start, int d, int px) throws IllegalArgumentException, NullPointerException {
        checkTranslation(start, d, px);
        return new Coordinate2D(start.getX() + (px * cos(d)), start.getY() + (px + sin(d)));
    }

    /**
     * Performs a backward translation of a single coordinate
     * @param start the start coordinate
     * @param d the rotation of the cursor
     * @param px the translation (in pixels) to be performed
     * @return the coordinate after the translation has been performed
     */
    public Coordinate2D backwardTranslation(Coordinate2D start, int d, int px) throws IllegalArgumentException, NullPointerException {
        checkTranslation(start, d, px);
        return new Coordinate2D(start.getX() - (px * cos(d)), start.getY() - (px + sin(d)));
    }

    /**
     * Checks if the parameters are valid
     * @param c coordinate
     * @param d cursor rotation angle
     * @param px translation length
     * @return <code>true</code> if all the parameters are valid
     * @throws IllegalArgumentException
     * @throws NullPointerException
     */
    private boolean checkTranslation (Coordinate2D c, Integer d, Integer px) throws IllegalArgumentException, NullPointerException {
        if (c == null || d == null || px == null)
            throw new NullPointerException("Invalid parameters.");
        if (d >= 360 || px < 0)
            throw new IllegalArgumentException("Invalid parameters.");
        return true;
    }
}
