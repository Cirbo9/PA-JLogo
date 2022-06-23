package PA.JLogo.app;

import PA.JLogo.app.model.Canvas;
import PA.JLogo.app.model.Cursor;
import PA.JLogo.app.model.Line;

import java.awt.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class Controller {

    private Canvas canvas;
    private Cursor cursor;
    private StringTokenizer tokenizer;

    public Controller(Canvas canvas, Cursor cursor) {
        this.canvas = canvas;
        this.cursor = cursor;
    }

    /**
     * This is the procedure to initializing the canvas (setting base and height)
     */
    public void init() {
        //set base, height
        cursor.setPosition(canvas.getHomePosition());
    }

    /**
     * Parses the command that the user typed
     * @param userInput The line typed by the user
     */
    public void interpret (String userInput) throws IllegalArgumentException {
        tokenizer = new StringTokenizer(userInput, " ");
        String command = tokenizer.nextToken().toLowerCase(Locale.ROOT);
        switch (command) {
            case "forward":
            case "fd":
                forward();
                break;
            case "backward":
            case "bd":
                backward();
                break;
            case "left":
                left();
                break;
            case "right":
                right();
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
            case "quit":
            case "exit":
            case "q":
                return;
            default: throw new IllegalArgumentException(command);
        }


    }

    private void forward () {
        //get int px some way
//        Line line = cursor.forward();
    }

    private void backward () {

    }

    private void left () {

    }

    private void right () {

    }

    private void clearscreen () {
        this.canvas.clear();
    }

    private void home () {
        cursor.setPosition(canvas.getHomePosition());
    }

    private void penup () {
        cursor.up();
    }

    private void pendown () {
        cursor.down();
    }

    private void setPenColor (Color color) {

    }

    private void setFillColor (Color color) {

    }

    private void setScreenColor (Color color) {

    }

    private void setPenSize (int size) {

    }

    private void repeat (int i) {

    }

    private void printHelp() {
        System.out.println("JLogo lets you create a ");
    }

}
