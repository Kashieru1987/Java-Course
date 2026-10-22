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
        final int step = 50;
        for(int i = 1; i <= 4; i++) {
            drawBalloon(i*step + ((i-1)*step), 50, (float) (i * step) /2);
        }
    }

    public void drawBalloon(int x, int y, float diameter) {
        pushMatrix();
        translate(x, y);

        circle(0, 0, diameter);
        line(0, diameter/2, 0, diameter);

        popMatrix();
    }

}