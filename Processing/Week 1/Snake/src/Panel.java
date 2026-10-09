import processing.core.PApplet;

public class Panel extends PApplet {

    final String title;
    final int width;
    final int height;

    public Panel() {
    }

    @Override
    public void setup() {
        this.surface.setTitle(title);
    }

    @Override
    public void settings() {
        this.size(width, height);
    }

}
