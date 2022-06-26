package PA.JLogo.app;

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
        CLIView view = new CLIView();
        Controller controller = new Controller(new SimpleCanvas(new ArrayList<>(), Color.RED,1000,800),
                new SimpleCursor(CursorState.DOWN, Color.RED, Color.RED, 0, 2, new Coordinate2D(0.0, 0.0)));
        controller.init();
        String s;
        do {
            s = view.getNextUserInput();
            try {
                controller.interpret(s);
            } catch (IllegalArgumentException e) {
                view.handleCommandNotFoundException(e);
            }
        } while (!s.equals("exit") && !s.equals("quit") && !s.equals("q"));
    }
}
