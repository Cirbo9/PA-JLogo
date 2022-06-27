package PA.JLogo.app;

public interface LogoView {
    void init();
    String getNextUserInput();
    void printHelpMessage();
    void handleCommandNotFound(Exception e);
    void handleException(Exception e);
}
