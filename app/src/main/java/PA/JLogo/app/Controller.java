package PA.JLogo.app;

import PA.JLogo.app.model.Canvas;
import PA.JLogo.app.model.Cursor;
import PA.JLogo.app.model.Line;
import PA.JLogo.app.util.CursorState;

import java.awt.Color;
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
        //utente deve inserire misure del canvas
    }

    /**
     * Parses the command that the user typed
     *
     * @param userInput The line typed by the user
     */
    public void interpret(String userInput) throws IllegalArgumentException {
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
                printHelp();
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
                setPenColor();
                break;
            case "setfillcolor":
                setFillColor();
                break;
            case "setscreencolor":
                setScreenColor();
                break;
            case "setpensize":
                setPenSize();
                break;
            case "repeat":
                repeat();
                break;
            case "quit":
            case "exit":
            case "q":
                return;
            default:
                throw new IllegalArgumentException(command);
        }


    }

    private void forward() {
        int px = Integer.parseInt(tokenizer.nextToken());
        penMovement(px);
    }

    private void backward() {
        int px = Integer.parseInt(tokenizer.nextToken());
        penMovement(-px);
    }

    private void penMovement(int px) {
        Line line = cursor.forward(canvas, px);
        if (cursor.getState() == CursorState.DOWN)
            canvas.add(line);
    }

    private void left() {
        int px = Integer.parseInt(tokenizer.nextToken());
        cursor.rotateLeft(px);
    }

    private void right() {
        int px = Integer.parseInt(tokenizer.nextToken());
        cursor.rotateRight(px);
    }

    private void clearscreen() {
        this.canvas.clear();
    }

    private void home() {
        cursor.setPosition(canvas.getHomePosition());
    }

    private void penup() {
        cursor.up();
    }

    private void pendown() {
        cursor.down();
    }

    private void setPenColor() {
        cursor.setPenColor(userPickColor());
    }

    private void setFillColor() {
        cursor.setFillColor(userPickColor());
    }

    private void setScreenColor() {
        canvas.setColor(userPickColor());
    }

    private Color userPickColor() {
        int r = Integer.parseInt(tokenizer.nextToken());
        int g = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());
        return new Color(r, g, b);
    }

    private void setPenSize() {

    }

    private void repeat() {

    }

    private void printHelp() {
        System.out.println("Welcome to JLogo");
    }

}
