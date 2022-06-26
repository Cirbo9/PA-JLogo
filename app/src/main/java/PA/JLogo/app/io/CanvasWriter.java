package PA.JLogo.app.io;

import PA.JLogo.app.model.Canvas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public interface CanvasWriter {
    String formatCanvas(Canvas canvas);
    default void write(Path path, Canvas canvas) throws IOException {
        Files.writeString(path, formatCanvas(canvas));
    }
}
