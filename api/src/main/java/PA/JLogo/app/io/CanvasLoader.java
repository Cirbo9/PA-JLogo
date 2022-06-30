package PA.JLogo.app.io;

import PA.JLogo.app.model.Canvas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public interface CanvasLoader {

    /**
     * Interprets a String, and translates it into an actual Canvas.
     * @param s the String being read
     * @return the resulting Canvas
     */
    Canvas getCanvas(String s) throws Exception;

    /**
     * Loads a saved Canvas from a file.
     * @param path the path of the file being read
     * @return the resulting Canvas
     * @throws IOException if an error arises while reading or trying to open the file for reading
     */
    default Canvas load(Path path) throws Exception {
        return getCanvas(Arrays.toString(Files.readAllBytes(path)));
    }
}
