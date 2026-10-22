import processing.core.PApplet;

public class Main extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    @Override
    public void settings() {
        size(500, 500);
    }

    @Override
    public void draw() {
        drawPercentage(0, 0, 50);
    }

    public void drawPercentage(int x, int y, float size) {
        pushMatrix();
        translate(x, y);

        line(0, size, size, 0);
        final float quarter = size/4;
        circle(quarter, quarter, size/2);
        circle(quarter + size/2, quarter + size/2, size/2);

        popMatrix();
    }
}