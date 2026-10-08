import processing.core.PApplet;

public class Main extends PApplet {

    final int frameWidth = 200;
    final int frameHeight = 200;

    final int padding = 25;
    final int lineLength = 100;

    final int paddingMirrored = padding + lineLength;

    final int xShift = 20;
    final int yShift = 20;

    public void horizontalLines() {
        int startX = padding + xShift;
        int startY = padding + yShift;
        line(startX, startY, startX + lineLength, startY);
        startY += lineLength;
        line(startX, startY, startX + lineLength, startY);
    }

    public void verticalLines() {
        int startX = paddingMirrored + xShift;
        int startY = paddingMirrored + yShift;
        line(startX, startY, startX, startY - lineLength);
        startX -= lineLength;
        line(startX, startY, startX, startY - lineLength);
    }

    @Override
    public void draw() {
        horizontalLines();
        verticalLines();
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    @Override
    public void settings() {
        size(frameWidth, frameHeight);
    }

}
