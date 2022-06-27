package PA.JLogo.app;

import java.util.Scanner;

public class CLIView implements LogoView {

    public final Scanner keyboard;

    public CLIView() {
        this.keyboard = new Scanner(System.in);
    }

    public void init() {
        printWelcomeMessage();
    }

    private void printWelcomeMessage() {
        System.out.println("Welcome to JLogo.");
    }

    public String getNextUserInput() {
        System.out.print("JLOGO # ");
        return this.keyboard.nextLine();
    }

    public void printHelpMessage() {
        System.out.println("Possible commands:\n" +
                "forward <dist>\n" +
                "backward <dist>\n" +
                "left <angle>\n" +
                "right <angle>\n" +
                "clearscreen\n" +
                "home\n" +
                "penup\n" +
                "pendown\n" +
                "setpencolor <byte> <byte> <byte>\n" +
                "setfillcolor <byte> <byte> <byte>\n" +
                "setscreencolor <byte> <byte> <byte>\n" +
                "setpensize <size>\n" +
                "repeat <num> [ <commands> ]\n");
    }

    public void handleCommandNotFound(Exception e) {
        System.out.println(e.getMessage() + ": command not found.");
    }

    public void handleException(Exception e) {
        System.out.println("Error: " + e.getMessage());
    }

}
