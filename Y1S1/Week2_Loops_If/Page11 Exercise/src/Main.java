import processing.core.PApplet;

public class Main extends PApplet {

    public final static int frameWidth = 500;
    public final static int frameHeight = 500;
    public final static int shapeWidth = 50;

    @Override
    public void settings() {
        this.size(frameWidth, frameHeight);
    }

    @Override
    public void draw() {
        for(int i = shapeWidth; i < frameWidth/2; i+=shapeWidth/2) {
            drawShape(i, i);
        }
    }

    public void drawShape(int x, int y) {
        this.pushMatrix();
        this.translate(x, y);

        this.rect(0, 0, shapeWidth, shapeWidth);
        this.circle(shapeWidth/2, shapeWidth/2, shapeWidth);

        this.popMatrix();
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}
