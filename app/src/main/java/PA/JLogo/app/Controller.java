package PA.JLogo.app;

import PA.JLogo.app.model.Canvas;
import PA.JLogo.app.model.Cursor;

import java.awt.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class Controller {
    /**
     * Creates all the variables that are necessary for the system to function
     * Also contains all the supported operations
     */

    private Canvas canvas;
    private Cursor cursor;
    private static StringTokenizer tokenizer;

    public Controller(Canvas canvas, Cursor cursor) {
        this.canvas = canvas;
        this.cursor = cursor;
    }

    /**
     * This is the procedure to initializing the canvas (setting base and height)
     */
    public void init() {

    }

    /**
     * Parses the command that the user typed
     * @param userInput The line typed by the user
     */
    public void interpret (String userInput) {
        tokenizer = new StringTokenizer(userInput, " ");
        String command = tokenizer.nextToken().toLowerCase(Locale.ROOT);
        switch (command) {
            case "quit":
                return;
            case "forward":
            case "fd":
                break;
            case "backward":
            case "bd":
                break;
            case "left":
                break;
            case "right":
                break;
            case "clearscreen":
            case "clear":
            case "cls":
                this.clearscreen();
                break;
            case "home":
                this.home();
                break;
            case "help":
                break;
            case "penup":
            case "up":
                this.cursor.up();
                break;
            case "pendown":
            case "down":
                this.cursor.down();
                break;
            case "setpencolor":
                break;
            case "setfillcolor":
                break;
            case "setscreencolor":
                break;
            case "setpensize":
                break;
            case "repeat":
                break;
            default: handleCommandNotFound(command);
        }


    }

    private void handleCommandNotFound(String command) {
        System.out.println(command + ": command not found.");
    }


    public void forward () {

    }

    public void backward () {

    }

    public void left () {

    }

    public void right () {

    }

    public void clearscreen () {
        this.canvas.clear();
    }

    public void home () {
        cursor.setPosition(canvas.getHomePosition());
    }

    public void penup () {
        cursor.up();
    }

    public void pendown () {
        cursor.down();
    }

    public void setPenColor (Color color) {

    }

    public void setFillColor (Color color) {

    }

    public void setScreenColor (Color color) {

    }

    public void setPenSize (int size) {

    }

    public void repeat (int i) {

    }

}
