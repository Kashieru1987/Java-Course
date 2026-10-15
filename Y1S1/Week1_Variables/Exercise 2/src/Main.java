import processing.core.PApplet;

public class Main extends PApplet {

    public void original() {
        float x = 50;
        point(0, 0);
        ellipse(x, 250, 40, 40);
    }

    public void centredCircle() {
        float x = 250;
        point(0, 0);
        ellipse(x, 250, 40, 40);
    }

    public void biggerAndHalvedCircle() {
        float x = 50;
        point(0, 0);
        ellipse(x, 250, 80, 40);
        ellipse(x, 250, 20, 20);
    }

    public void sizeVariableExample() {
        float x = 50;
        int size = 40;
        point(0, 0);
        ellipse(x, 250, size, size);
    }

    @Override
    public void draw() {
//        original();
//        centredCircle();
//        biggerAndHalvedCircle();
        sizeVariableExample();
    }

    @Override
    public void settings() {
        size(500, 500);
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}