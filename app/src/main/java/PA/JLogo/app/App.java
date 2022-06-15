package PA.JLogo.app;

import java.util.Scanner;

public class App {

    private final Scanner keyboard;


    public App() {
        this.keyboard = new Scanner(System.in);
    }

    public void start() {
        String command = getNextUserInput();
        Interpreter.interpret(command);

        return;
    }

    private String getNextUserInput() {
        System.out.print("JLOGO # ");
        return keyboard.nextLine();
    }
}
