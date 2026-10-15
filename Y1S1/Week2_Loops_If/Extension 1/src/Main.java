import processing.core.PApplet;

public class Main extends PApplet {

    public static final int panelWidth = 500;
    public static final int panelHeight = 500;
    public static final int pivot = 50;
    public static final int padding = 25;

    @Override
    public void settings() {
        this.size(panelWidth, panelHeight);
    }

    @Override
    public void draw() {
        this.pushMatrix();
        this.translate(pivot, pivot);

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                int value = 10 * i + j + 1;
                text("" + value, i*padding, j*padding);
            }
        }

        this.popMatrix();
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}