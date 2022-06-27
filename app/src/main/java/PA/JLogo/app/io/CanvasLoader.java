package PA.JLogo.app.io;

import PA.JLogo.app.model.Canvas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public interface CanvasLoader {
    Canvas getCanvas(String s);
    default Canvas load(Path path) throws IOException {
        return getCanvas(Files.readAllBytes(path).toString());
    }
}
