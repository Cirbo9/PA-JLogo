import java.util.Scanner;

public class App {

    private final Scanner keyboard;


    public App(String[] args) {
        this.keyboard = new Scanner(System.in);
    }

    public void start() throws Exception {
        String command = getNextUserInput();
        Interpreter.interpret(command);

        return;
    }

    private String getNextUserInput() {
        System.out.print("JLOGO # ");
        return keyboard.nextLine();
    }
}
