import java.awt.*;

public interface Canvas {

    /**
     *
     * @return the base value of the canvas
     */
    int getBase();

    /**
     *
     * @return the height value of the canvas
     */
    int getHeight();

    /**
     *
     * @return the background color of the canvas
     */
    Color getColor();

    /**
     * resets to a clear canvas with default settings
     */
    void clear();

    /**
     *
     * @return the canvas info in a format which is ready to be saved in memory
     */
    String toString();
}
