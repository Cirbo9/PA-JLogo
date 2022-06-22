package PA.JLogo.app;

import PA.JLogo.app.model.SimpleCanvas;
import PA.JLogo.app.model.SimpleCursor;
import PA.JLogo.app.util.Coordinate2D;
import PA.JLogo.app.util.CursorState;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private final Scanner keyboard;


    public App() {
        this.keyboard = new Scanner(System.in);
    }

    public void start() {
        Controller controller = new Controller(new SimpleCanvas(new ArrayList<>(), Color.red,
                getInt(), getInt()),
                new SimpleCursor(CursorState.DOWN, Color.red, Color.red, 0, 5, new Coordinate2D(0.0, 0.0)));
        while (true) {
            String command = getNextUserInput();
            Controller.interpret(command);
        }
    }

    private int getInt() {
        return keyboard.nextInt();
    }

    private String getNextUserInput() {
        System.out.print("JLOGO # ");
        return keyboard.nextLine();
    }
}
