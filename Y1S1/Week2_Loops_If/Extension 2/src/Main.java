import processing.core.PApplet;

public class Main extends PApplet {

    public final static int panelWidth = 500;
    public final static int panelHeight = 500;
    public final static int pivotX = 50;
    public final static int pivotY = 50;
    public final static int padding = 50;

    @Override
    public void settings() {
        this.size(panelWidth, panelHeight);
    }

    @Override
    public void draw() {
        drawA(pivotX, pivotY);
        drawB(pivotX, pivotY + padding);
        drawC(pivotX, pivotY + padding*2);
        drawD(pivotX, pivotY + padding*3);
    }

    public void drawA(int x, int y) {
        pushMatrix();
        translate(x, y);

        final int rangeStart = 10;
        final int rangeEnd = 13;

        int total = 0;
        for(int i = rangeStart; i <= rangeEnd; i++) {
            total+=i;
        }
        textSize(20);
        text(total, 0, 0);

        popMatrix();
    }

    public void drawB(int x, int y) {
        pushMatrix();
        translate(x, y);

        final int value = 5;

        int result = 1;
        for(int i = value; i > 0; i--) {
            result *= i;
        }

        textSize(20);
        text(result, 0, 0);

        popMatrix();
    }

    public void drawC(int x, int y) {
        pushMatrix();
        translate(x, y);

        final int value = 2;
        final int exponent = 5;
        final int result = (int) Math.pow(value, exponent);

        textSize(20);
        text(result, 0, 0);

        popMatrix();
    }

    public void drawD(int x, int y) {
        pushMatrix();
        translate(x, y);
        translate(0, 100);

        final int m = 2;
        final int intersect = 5;

        strokeWeight(3);
        for(int xVal = 0; xVal < 50; xVal++) {
            point(xVal, (xVal * m + intersect)*-1);
        }

        popMatrix();
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}