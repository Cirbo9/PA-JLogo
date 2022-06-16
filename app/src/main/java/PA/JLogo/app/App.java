package PA.JLogo.app;

import java.util.Scanner;

public class App {

    private final Scanner keyboard;


    public App() {
        this.keyboard = new Scanner(System.in);
    }

    public void start() {
        init();
        while (true) {
            String command = getNextUserInput();
            Interpreter.interpret(command);
        }
    }

    private String getNextUserInput() {
        System.out.print("JLOGO # ");
        return keyboard.nextLine();
    }

    public void init() {

    }

}
