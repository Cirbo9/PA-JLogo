package PA.JLogo.app;

import PA.JLogo.app.io.SimpleFormatter;
import PA.JLogo.app.io.SimpleInterpreter;
import PA.JLogo.app.model.SimpleCanvas;
import PA.JLogo.app.model.SimpleCursor;
import PA.JLogo.app.util.Coordinate2D;
import PA.JLogo.app.util.CursorState;
import PA.JLogo.app.view.CLIView;

import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Color;

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
