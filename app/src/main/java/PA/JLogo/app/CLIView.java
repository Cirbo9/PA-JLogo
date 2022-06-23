package PA.JLogo.app;

import java.util.Scanner;

public class CLIView {

    public final Scanner keyboard;

    public CLIView() {
        this.keyboard = new Scanner(System.in);
    }

    public void init() {
        printWelcomeMessage();
    }

    private void printWelcomeMessage() {

    }

    public String getNextUserInput() {
        System.out.print("JLOGO # ");
        return this.keyboard.nextLine();
    }

    public int getInt() {
        return keyboard.nextInt();
    }

    public void printHelpMessage() {

    }

    public void handleCommandNotFoundException(IllegalArgumentException e) {
        System.out.println(e.getMessage() + ": command not found.");
    }

}
