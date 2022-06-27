package PA.JLogo.app.view;

import java.util.Scanner;

public class CLIView implements LogoView {

    public final Scanner keyboard;

    public CLIView() {
        this.keyboard = new Scanner(System.in);
    }

    /**
     * Prints a message to be displayed on the program's start.
     */
    @Override
    public void init() {
        printWelcomeMessage();
    }

    /**
     * Prints the welcome message.
     */
    private void printWelcomeMessage() {
        System.out.println("Welcome to JLogo.");
    }

    @Override
    public String getNextUserInput() {
        System.out.print("JLOGO # ");
        return this.keyboard.nextLine();
    }

    /**
     * Prints a list of the implemented commands/features of the program.
     */
    @Override
    public void printHelpMessage() {
        System.out.println("""
                Possible commands:
                * forward <dist>
                * backward <dist>
                * left <angle>
                * right <angle>
                * clearscreen
                * home
                * penup
                * pendown
                * setpencolor <byte> <byte> <byte>
                * setfillcolor <byte> <byte> <byte>
                * setscreencolor <byte> <byte> <byte>
                * setpensize <size>
                * repeat <num> [ <commands> ]
                """);
    }

    @Override
    public void handleCommandNotFound(Exception e) {
        System.out.println(e.getMessage() + ": command not found.");
    }



    @Override
    public void handleException(Exception e) {
        System.out.println("Error: " + e.getMessage());
    }

    /**
     * Prints info about the file after it got saved into the system's memory.
     */
    @Override
    public void fileSaveInfo(String path) {
        System.out.println("The Canvas has been saved to: " + path);
    }

}
