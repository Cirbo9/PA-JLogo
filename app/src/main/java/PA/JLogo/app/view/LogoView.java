package PA.JLogo.app.view;

public interface LogoView {

    /**
     * Does all the operations necessary in order to prepare the environment to be used by the User
     */
    void init();

    /**
     * Retrieves a single line of the user's input.
     * @return a String containing a line of the user's input
     */
    String getNextUserInput();

    /**
     * Prints the manual or a short help message.
     */
    void printHelpMessage();

    /**
     * Prints an error message relative to the command not found.
     * e.getMessage() is assumed to contain the (non-existing) command which has been input by the user.
     * @param e the Exception thrown
     */
    void handleCommandNotFound(Exception e);

    /**
     * Prints a message relative to the Exception thrown.
     * @param e the Exception thrown
     */
    void handleException(Exception e);

    /**
     * Handles the saving of the Canvas into a file
     */
    void fileSaveInfo(String path);
}
