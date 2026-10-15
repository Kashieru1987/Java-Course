import processing.core.PApplet;

public class Main extends PApplet {

    public static final int panelWidth = 500;
    public static final int panelHeight = 500;
    public static final int wheelsWide = 5;
    public static final int wheelsHigh = 5;
    public static final int wheelDiameter = 50;
    public static final int wheelStep = 10;

    @Override
    public void settings() {
        size(panelWidth, panelHeight);
    }

    @Override
    public void setup() {
        pushMatrix();
        translate(wheelDiameter, wheelDiameter);

        for(int i = 0; i < wheelsHigh; i++) {
            drawRow(i*wheelDiameter);
        }
    }

    @Override
    public void draw() {
    }

    public void drawRow(int y) {
        pushMatrix();
        translate(0, y);

        for(int i = 0; i < wheelsWide; i++) {
            drawWheel(i * wheelDiameter);
        }

        popMatrix();
    }

    public void drawWheel(int x) {
        pushMatrix();
        translate(x, 0);
        int radius = wheelDiameter/2;

        setRandomStroke();
        circle(0, 0, wheelDiameter);
        for(int i = 0; i < 360; i+=wheelStep) {
            float angle = radians(i);
            line(0, 0, radius*sin(angle), radius*cos(angle));
        }

        popMatrix();
    }

    public void setRandomStroke() {
        int r = (int) random(50) * 5;
        int g = (int) random(50) * 5;
        int b = (int) random(50) * 5;
        stroke(r, g, b);
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}