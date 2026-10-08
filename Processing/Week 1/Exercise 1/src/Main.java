import processing.core.PApplet;

public class Main extends PApplet {

    final int padding = 50;

    final int carBaseHeight = 40;
    final int carBaseWidth = carBaseHeight * 2;

    final int carTopHeight = 25;
    final int carTopWidth = carTopHeight * 2;

    final int carWheelRadius = 20;

    final int carHeadlightHeight = 15;
    final int carHeadlightRadius = 10;


    final int carBasePivotX = padding;
    final int carBasePivotY = padding + carTopHeight;

    final int carTopPivotX = carBasePivotX + carBaseWidth/2 - carTopWidth/2;
    final int carTopPivotY = padding;

    final int carWheelX = carTopPivotX;
    final int carWheelY = carBasePivotY + carBaseHeight;

    final int carHeadlightX = carBasePivotX + carBaseWidth;
    final int carHeadlightY = carBasePivotY + carHeadlightHeight;

    @Override
    public void draw() {
        background(0);
        drawCarBase();
        drawCarTop();
        drawWheels();
        drawHeadlights();
    }

    public void drawCarBase() {
        rect(carBasePivotX, carBasePivotY, carBaseWidth, carBaseHeight);
    }

    public void drawCarTop() {
        rect(carTopPivotX, carTopPivotY, carTopWidth, carTopHeight);
    }

    public void drawWheels() {
        ellipse(carTopPivotX, carWheelY, carWheelRadius, carWheelRadius);
        ellipse(carTopPivotX + carTopWidth, carWheelY, carWheelRadius, carWheelRadius);
    }

    public void drawHeadlights() {
        ellipse(carHeadlightX, carHeadlightY, carHeadlightRadius, carHeadlightRadius);
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    @Override
    public void settings() {
        size(300, 300);
    }
}
