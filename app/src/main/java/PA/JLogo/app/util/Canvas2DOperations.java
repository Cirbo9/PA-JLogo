package PA.JLogo.app.util;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import PA.JLogo.app.util.Validations;

public class Canvas2DOperations {
    /**
     * Performs a forward translation of a single coordinate. Resulting coordinate
     * will not be exact, as the values will be approximated to integers.
     * @param start the start coordinate
     * @param d (direction) the rotation of the cursor
     * @param px the translation (in pixels) to be performed
     * @return the coordinate after the translation has been performed
     * @throws IllegalArgumentException
     * @throws NullPointerException
     */
    public static Coordinate2D forwardTranslation(Coordinate2D start, int d, int px) throws IllegalArgumentException, NullPointerException {
        if (px == 0)
            return start;
        checkTranslation(start, d, px);
        return new Coordinate2D(start.getX() + (px * cos(Math.toRadians(d))),
                start.getY() + (px * sin(Math.toRadians(d))));
    }

    /**
     * Performs a backward translation of a single coordinate. Resulting coordinate
     * will not be exact, as the values will be approximated to integers.
     * @param start the start coordinate
     * @param d the rotation of the cursor
     * @param px the translation (in pixels) to be performed
     * @return the coordinate after the translation has been performed
     */
    public static Coordinate2D backwardTranslation(Coordinate2D start, int d, int px) throws IllegalArgumentException, NullPointerException {
        if (px == 0)
            return start;
        checkTranslation(start, d, px);
        return new Coordinate2D(start.getX() - (px * cos(Math.toRadians(d))),
                start.getY() - (px * sin(Math.toRadians(d))));
    }

    /**
     * Checks if the parameters are valid
     * @param c coordinate
     * @param d cursor rotation angle
     * @param px translation length
     * @throws IllegalArgumentException
     * @throws NullPointerException
     */
    private static void checkTranslation (Coordinate2D c, Integer d, Integer px) throws IllegalArgumentException, NullPointerException {
        if (c == null || d == null || px == null)
            throw new NullPointerException("Invalid parameters.");
        if (d >= 360 || px < 0)
            throw new IllegalArgumentException("Invalid parameters.");
    }
}
