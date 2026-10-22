import processing.core.PApplet;

public class Main extends PApplet {

    private final int panelWidth = 1000;
    private final int panelHeight = 500;
    private final int padding = 25;
    private final String labelText = "MC25883357";

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    @Override
    public void settings() {
        size(panelWidth, panelHeight);
    }

    @Override
    public void draw() {
        pushMatrix();

        drawCarRow(0, 50);
        drawCarRow(150, 100);

        popMatrix();
    }

    public void drawCarRow(int y, int size) {
        pushMatrix();
        translate(padding, padding);

        final int carWidth = size*2;

        for(int i = 0; i + carWidth + padding < panelWidth; i += carWidth + padding) {
            drawCar(i, y, size);
        }

        popMatrix();
    }

    public void drawCar(int x, int y, int size) {
        pushMatrix();
        translate(x, y);
        final float widthHead = size;
        final float widthBody = widthHead * 2;

        stroke(0);
        fill(0, 0, 255);
        rect(widthHead/2, 0, widthHead, widthHead); //head
        fill(255, 0, 0);
        rect(0, widthHead, widthBody, widthHead); //body

        drawText((int) widthHead);

        drawWheel((int) (widthHead/2), (int) (widthHead*2), size/4);
        drawWheel((int) (widthHead/2 + widthHead), (int) (widthHead*2), size/4);

        popMatrix();
    }

    public void drawText(int widthHead) {
        stroke(0);
        fill(0);
        textSize((float) widthHead /3);
        text(labelText, 0, widthHead + (float) widthHead /2);
    }

    public void drawBody() {
    }

    public void drawWheel(int x, int y, int size) {
        pushMatrix();
        translate(x, y);
        fill(255);

        strokeWeight((float) size/3);
        circle(0, 0, size);
        strokeWeight(1);

        int radius = size/2;
        line(-radius, 0, radius, 0);
        line(0, -radius, 0, radius);

        popMatrix();
    }

}