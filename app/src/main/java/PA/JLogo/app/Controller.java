package PA.JLogo.app;

import PA.JLogo.app.io.CanvasLoader;
import PA.JLogo.app.io.CanvasWriter;
import PA.JLogo.app.model.Canvas;
import PA.JLogo.app.model.Cursor;
import PA.JLogo.app.model.Line;
import PA.JLogo.app.util.CursorState;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.StringTokenizer;

public class Controller {

    private Canvas canvas;
    private Cursor cursor;
    private StringTokenizer tokenizer;
    private LogoView view;
    private CanvasWriter writer;
    private CanvasLoader loader;
    private Path currentPath = Paths.get("").toAbsolutePath();
    private String filePath = currentPath.toString() + File.separator + "myCanvas.txt";


    public Controller(Canvas canvas, Cursor cursor, LogoView view, CanvasWriter writer, CanvasLoader loader) {
        this.canvas = canvas;
        this.cursor = cursor;
        this.view = view;
        this.writer = writer;
        this.loader = loader;
    }

    /**
     * Apply some initialization settings
     */
    public void init()  {
        view.init();
        System.out.println("File will be saved to: " + filePath);
        home();
    }

    /**
     * General behavior of the program
     */
    public void execute() {
        init();
        String s;
        do {
            s = view.getNextUserInput();
            tokenizer = new StringTokenizer(s, " ");
            try {
                while (tokenizer.hasMoreTokens()) {
                    parseCommand(tokenizer.nextToken().toLowerCase(Locale.ROOT));
                }
            } catch (Exception e) {
                view.handleCommandNotFound(e);
            }
        } while (!isExitCommand(s));
    }

    private boolean isExitCommand(String s) {
        return (s.equals("exit") || s.equals("quit") || s.equals("q"));
    }

    /**
     * Parses the command that the user typed. Some shortcuts are implemented
     *
     * @param command The line typed by the user
     */
    private void parseCommand(String command) throws IllegalArgumentException, IOException {
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
                view.printHelpMessage();
                break;
            case "penup":
            case "up":
                penup();
                break;
            case "pendown":
            case "down":
                pendown();
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
            case "save":
            case "s":
                save();
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
        penMovement(getTokenizerNextInt());
    }

    private void backward() {
        penMovement(-getTokenizerNextInt());
    }

    private void penMovement(int px) {
        Line line = cursor.forward(canvas, px);
        if (cursor.getState() == CursorState.DOWN)
            canvas.add(line);
    }

    private void left() {
        cursor.rotateLeft(getTokenizerNextInt());
    }

    private void right() {
        cursor.rotateRight(getTokenizerNextInt());
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
        cursor.setPenSize(getTokenizerNextInt());
    }

    private void repeat() {

    }

    private int getTokenizerNextInt() {
        return Integer.parseInt(tokenizer.nextToken());
    }

    private void save() throws IOException {
        writer.write(Path.of(filePath), canvas);
    }

    private void load() throws IOException {
        loader.load(Path.of(filePath));
    }

}
