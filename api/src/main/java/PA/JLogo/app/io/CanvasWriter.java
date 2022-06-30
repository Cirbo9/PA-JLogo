package src.main.java.PA.JLogo.app.io;


import src.main.java.PA.JLogo.app.model.Canvas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public interface CanvasWriter {

    /**
     * Translates a canvas into a String in order to save the canvas into a file
     * @param canvas the canvas to be formatted and saved
     * @return the resulting String after the canvas gets translated
     */
    String formatCanvas(Canvas canvas);

    /**
     * Writes a canvas into a file indicated by the path specified. If the file
     * doesn't exist, it gets created.
     * @param path the path of the file where the canvas will get saved
     * @param canvas the canvas to be saved into a file
     * @throws IOException if an error arises while writing or trying to write the file
     */
    default void write(Path path, Canvas canvas) throws IOException {
        Files.writeString(path, formatCanvas(canvas));
    }
}
