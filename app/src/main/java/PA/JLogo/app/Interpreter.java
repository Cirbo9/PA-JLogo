package PA.JLogo.app;

import java.util.Locale;
import java.util.StringTokenizer;

/**
 * This class bears the responsibility of translating user input to the right commands.
 */
public class Interpreter {
    /**
     * Parses the command that the user typed
     * @param userInput The line typed by the user
     */
    public static void interpret (String userInput) {
        StringTokenizer tokenizer = new StringTokenizer(userInput, " ");
        parseCommand(tokenizer.nextToken().toLowerCase(Locale.ROOT));
    }

    /**
     * Chooses the operation to do
     *
     * @param command The command that the user typed
     * @throws Exception if the command specified by the user is not found
     */
    private static void parseCommand(String command) {
        switch (command) {
            case "quit":
                return;
            case "forward":
            case "backward":
            case "left":
            case "right":
            case "clearscreen":
            case "home":
            case "help":
            case "penup":
            case "pendown":
            case "setpencolor":
            case "setfillcolor":
            case "setscreencolor":
            case "setpensize":
            case "repeat":
            default: handleCommandNotFound(command);
        }
    }

    /**
     * Handles the situation where the command input by the user was not found.
     * @param command the command which was input by the user
     */
    private static void handleCommandNotFound(String command) {
        System.out.println(command + ": command not found.");
    }
}
