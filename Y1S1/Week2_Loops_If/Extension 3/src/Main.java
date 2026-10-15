import processing.core.PApplet;

public class Main extends PApplet {

    public final static int panelWidth = 1000;
    public final static int panelHeight = 500;
    public final static int squareWidth = 20;
    public final static int step = 2;
    public boolean isWhite = true;

    @Override
    public void settings() {
        size(panelWidth, panelHeight);
    }

    @Override
    public void setup() {
        for(int y = 0; y < panelHeight; y += squareWidth) {
            drawRow(y);
            isWhite = step % 2 == 0 ? !isWhite : isWhite;
//            isWhite = !isWhite;
        }
        isWhite = !isWhite;
//        isWhite = step % 2 == 0 ? !isWhite : isWhite;
    }

    public void drawRow(int y) {
        pushMatrix();
        translate(0, y);

        int width = 0;
        boolean increase = true;

        for (int x = 0; x < panelWidth; x += width) {
            fill(isWhite ? 255 : 0);
            isWhite = !isWhite;

            rect(x, 0, width, squareWidth);

            if(width > squareWidth || width < 0)
                increase = !increase;
            width = increase ? width + step : width - step;
        }
        popMatrix();
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}