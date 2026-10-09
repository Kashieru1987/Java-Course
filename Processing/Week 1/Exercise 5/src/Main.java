import processing.core.PApplet;

public class Main extends PApplet {

    final int frameWidth = 200;
    final int frameHeight = 200;
    final int centreX = frameWidth/2;
    final int centreY = frameHeight/2;

    final int ellipseDiameter = 50;
    final int lineLength = ellipseDiameter * 2;

    @Override
    public void draw() {
        drawHorizontalBar();
        drawVerticalBar();
    }

    // for the horizontal line with the circles attached
    public void drawHorizontalBar() {
        final int lineStartX = centreX - lineLength/2;
        final int lineStartY = centreY;
        final int lineEndX = lineStartX + lineLength;
        final int lineEndY = centreY;

        // important to draw the circles first, then the line, so the line is visible above it
        ellipse(lineStartX, lineStartY, ellipseDiameter, ellipseDiameter);
        ellipse(lineEndX, lineEndY, ellipseDiameter, ellipseDiameter);
        line(lineStartX, lineStartY, lineEndX, lineEndY);
    }
    public void drawVerticalBar() {
        final int lineStartX = centreX;
        final int lineStartY = centreY - lineLength/2;
        final int lineEndX = centreX;
        final int lineEndY = lineStartY + lineLength;

        // important to draw the circles first, then the line, so the line is visible above it
        ellipse(lineStartX, lineStartY, ellipseDiameter, ellipseDiameter);
        ellipse(lineEndX, lineEndY, ellipseDiameter, ellipseDiameter);
        line(lineStartX, lineStartY, lineEndX, lineEndY);
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    // required inside of a settings method over a setup method when outside of the processing IDE
    @Override
    public void settings() {
        size(frameWidth, frameHeight);
    }
}