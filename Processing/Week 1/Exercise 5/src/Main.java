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

    public void drawHorizontalBar() {
        final int lineStartX = centreX - lineLength/2;
        final int lineStartY = centreY;
        final int lineEndX = lineStartX + lineLength;
        final int lineEndY = centreY;

        line(lineStartX, lineStartY, lineStartX + lineLength, lineStartY);
    }
    public void drawVerticalBar() {
        final int lineStartX = centreX;
        final int lineStartY = centreY - lineLength/2;
        final int lineEndX = centreX;
        final int lineEndY = lineStartY + lineLength;


        line(lineStartX, lineStartY, lineStartX, lineStartY + lineLength);
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    @Override
    public void settings() {
        size(frameWidth, frameHeight);
    }
}