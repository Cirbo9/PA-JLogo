package PA.JLogo.app;

import PA.JLogo.app.view.CLIView;
import src.main.java.PA.JLogo.app.io.SimpleFormatter;
import src.main.java.PA.JLogo.app.io.SimpleInterpreter;
import src.main.java.PA.JLogo.app.model.SimpleCanvas;
import src.main.java.PA.JLogo.app.model.SimpleCursor;
import src.main.java.PA.JLogo.app.util.Coordinate2D;
import src.main.java.PA.JLogo.app.util.CursorState;

import java.awt.Color;
import java.util.ArrayList;

public class App {

    public App() {

    }

    public void start() {
        Controller controller = new Controller(new SimpleCanvas(new ArrayList<>(), Color.WHITE,1000,800),
                new SimpleCursor(CursorState.DOWN, Color.BLACK, Color.WHITE, 0, 2, new Coordinate2D(0.0, 0.0)),
                new CLIView(), new SimpleFormatter(), new SimpleInterpreter());
        controller.execute();
    }
}
