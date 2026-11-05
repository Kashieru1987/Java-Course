import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Bouncer {

    public final int speed = 5;
    public final String text = "MC25883357";
    public PImage upLeft;
    public PImage upRight;
    public PImage downLeft;
    public PImage downRight;

    public PApplet panel;
    public PVector position;
    public PVector delta;
    public PImage image;

    public Bouncer(int x, int y, int deltaX, int deltaY) {
        this(new PVector(x, y), new PVector(deltaX, deltaY));
    }

    public Bouncer(PVector position, PVector delta) {
        this.panel = Main.instance;
        this.position = position;
        this.delta = delta;

        this.getImages();
        setImage();
    }

    public void display() {
        panel.image(image, position.x, position.y);
        panel.fill(255, 0, 0);
        panel.text(text, position.x + 50, position.y + 50);
    }

    public void move() {
        position.add(delta);
    }

    private void setImage() {
        boolean isUp = delta.y < 0;
        boolean isRight = delta.x > 0;

        if(isUp) {
            if(isRight) {
                image = upRight;
            } else {
                image = upLeft;
            }
        } else {
            if(isRight) {
                image = downRight;
            } else {
                image = downLeft;
            }
        }
    }

    public void handleCollisions() {
        handleWallCollisions();
    }

    private void handleWallCollisions() {

    }

    private void getImages() {
        upLeft = panel.loadImage("directions/upLeft.png");
        upRight = panel.loadImage("directions/upRight.png");
        downLeft = panel.loadImage("directions/downLeft.png");
        downRight = panel.loadImage("directions/downRight.png");
    }

}