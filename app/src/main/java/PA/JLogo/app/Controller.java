package PA.JLogo.app;

import PA.JLogo.app.view.LogoView;
import src.main.java.PA.JLogo.app.io.CanvasLoader;
import src.main.java.PA.JLogo.app.io.CanvasWriter;
import src.main.java.PA.JLogo.app.model.Canvas;
import src.main.java.PA.JLogo.app.model.Cursor;
import src.main.java.PA.JLogo.app.model.Line;
import src.main.java.PA.JLogo.app.util.CursorState;
import src.main.java.PA.JLogo.app.util.Validations;

import java.awt.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.StringTokenizer;

public class Controller {

    private Canvas canvas;
    private final Cursor cursor;
    private StringTokenizer tokenizer;
    private final LogoView view;
    private final CanvasWriter writer;
    private final CanvasLoader loader;
    private Path currentPath = Paths.get("").toAbsolutePath();
    private String filePath = currentPath + File.separator + "myCanvas.jlogo";

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
     * Parses the command that the user typed. Shortcuts are implemented for some commands.
     * @param commandToken a String containing only the command name.
     */
    private void parseCommand(String commandToken) throws Exception {
        switch (commandToken) {
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
            case "load":
            case "l":
                load();
                break;
            case "quit":
            case "exit":
            case "q":
                return;
            default:
                throw new Exception(commandToken);
        }
    }

    private void forward() {
        penMovement(Integer.parseInt(tokenizer.nextToken()));
    }

    private void backward() {
        penMovement(-Integer.parseInt(tokenizer.nextToken()));
    }

    private void penMovement(int px) {
        Line line = cursor.forward(canvas, px);
        if (cursor.getState() == CursorState.DOWN)
            canvas.add(line);
    }

    private void left() {
        cursor.rotateLeft(Integer.parseInt(tokenizer.nextToken()));
    }

    private void right() {
        cursor.rotateRight(Integer.parseInt(tokenizer.nextToken()));
    }

    private void clearscreen() {
        this.canvas.clear();
        home();
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
        cursor.setPenSize(Integer.parseInt(tokenizer.nextToken()));
    }

    private void repeat() throws Exception {
        int repetitions = Integer.parseInt(tokenizer.nextToken());
        try {
            Validations.validateSyntax(tokenizer.nextToken(), "[");
        } catch (Exception e) {
            view.handleException(e);
        }
        for (int i = 0; i < repetitions; i++) {
            parseCommand(tokenizer.nextToken());
        }
    }

    private void save() {
        try {
            writer.write(Path.of(filePath), canvas);
            view.fileSaveInfo(filePath);
        } catch (Exception e) {
            view.handleException(e);
        }
    }

    private void load() {
        try {
            this.canvas = loader.load(Path.of(filePath));
        } catch (Exception e) {
            view.handleException(e);
        }
    }

}
