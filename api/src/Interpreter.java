import java.util.Locale;
import java.util.StringTokenizer;

public class Interpreter {
    /**
     * Parses the command that the user typed
     * @param userInput The line typed by the user
     * @throws Exception if the command was not found or syntax is wrong
     */
    public static void interpret (String userInput) throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(userInput, " ");
        parseCommand(tokenizer.nextToken().toLowerCase(Locale.ROOT));
    }

    /**
     * Chooses the operation to do
     * @param command The command that the user typed
     * @throws Exception if the command specified by the user is not found
     */
    private static void parseCommand(String command) throws Exception {
        switch (command) {
            case "quit":
            case "forward":
            case "backward":
            case "left":
            case "right":
            case "clearscreen":
            case "home":
            case "penup":
            case "pendown":
            case "setpencolor":
            case "setfillcolor":
            case "setscreencolor":
            case "setpensize":
            case "repeat":
            default: throw new Exception(command + ": command not found");
        }
    }
}
