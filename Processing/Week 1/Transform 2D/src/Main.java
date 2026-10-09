import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;

public class Main extends PApplet {

    final String helpString = """
            WASD - movement
            Q/E - rotate left/right
            R/F - scale up/down
            H - toggle help
            """;
    final List<String> pressedKeys = new ArrayList<String>();
    final int frameWidth = 500;
    final int frameHeight = 500;

    final int movementSpeed = 2;

    int circleDiameter = 50;
    PVector position = new PVector(0, 0);
    int currentRotationDegrees = 0;
    boolean doShowHelp = true;

    @Override
    public void draw() {
        background(200);

        showHelp();
        drawCross();

        handleInput();
    }

    public void showHelp() {
        if(!doShowHelp)
            return;
        pushMatrix();
        scale(2);
        text(helpString, 0, 10);
        popMatrix();
    }

    public void drawCross() {
        pushMatrix();

        translate(frameWidth/2, frameHeight/2);
        translate(position.x, position.y);
        rotate(radians(currentRotationDegrees));

        circleDiameter = Math.max(circleDiameter, 0);

        drawHorizontalBar();
        drawVerticalBar();

        popMatrix();
    }

    public void drawHorizontalBar() {
        final int startX = -circleDiameter;
        final int endX = circleDiameter;

        circle(startX, 0, circleDiameter);
        circle(endX, 0, circleDiameter);
        line(startX, 0, endX, 0);
    }

    public void drawVerticalBar() {
        final int startY = -circleDiameter;
        final int endY = circleDiameter;

        circle(0, startY, circleDiameter);
        circle(0, endY, circleDiameter);
        line(0, startY, 0, endY);
    }

    public void handleInput() {
        for(String pressedKey : pressedKeys) {
            handleInput(pressedKey);
        }
    }

    public void handleInput(String pressedKey) {
        switch(pressedKey) {
            case "W" -> position.sub(0, movementSpeed);
            case "A" -> position.sub(movementSpeed, 0);
            case "S" -> position.add(0, movementSpeed);
            case "D" -> position.add(movementSpeed, 0);
            case "Q" -> currentRotationDegrees -= movementSpeed;
            case "E" -> currentRotationDegrees += movementSpeed;
            case "R" -> circleDiameter += movementSpeed;
            case "F" -> circleDiameter -= movementSpeed;
        }
    }

    @Override
    public void keyPressed() {
        String pressedKey = ("" + key).toUpperCase();

        // required to avoid flickering, cannot be handled like other inputs
        if(pressedKey.equals("H")) {
            doShowHelp = !doShowHelp;
            return;
        }

        if(pressedKeys.contains(pressedKey))
            return;
        pressedKeys.add(pressedKey);
    }

    @Override
    public void keyReleased() {
        String pressedKey = ("" + key).toUpperCase();
        pressedKeys.remove(pressedKey);
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    @Override
    public void settings() {
        size(frameWidth, frameHeight);
    }
}