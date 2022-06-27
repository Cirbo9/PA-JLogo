package PA.JLogo.app;

import PA.JLogo.app.io.SimpleFormatter;
import PA.JLogo.app.model.SimpleCanvas;
import PA.JLogo.app.model.SimpleCursor;
import PA.JLogo.app.util.Coordinate2D;
import PA.JLogo.app.util.CursorState;

import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Color;

public class App {

    public final Scanner keyboard;

    public App() {
        this.keyboard = new Scanner(System.in);
    }

    public void start() {
        Controller controller = new Controller(new SimpleCanvas(new ArrayList<>(), Color.WHITE,1000,800),
                new SimpleCursor(CursorState.DOWN, Color.BLACK, Color.RED, 0, 2, new Coordinate2D(0.0, 0.0)),
                new CLIView(), new SimpleFormatter(), null);
        controller.execute();
    }
}
