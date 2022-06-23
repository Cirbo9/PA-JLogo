package PA.JLogo.app.io;

import PA.JLogo.app.model.Canvas;

import java.io.File;

public interface CanvasWriter {
    File writeCanvas(Canvas canvas);
}
