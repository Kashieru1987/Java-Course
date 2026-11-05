import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;

public class Main extends PApplet {

    public volatile static Main instance;
    public List<Bouncer> bouncers;

    @Override
    public void settings() {
        size(500, 300);
    }

    @Override
    public void setup() {
//        new Bouncer(new PVector(50,50), new PVector(5, 5)).display();
//        new Bouncer(new PVector(150,50), new PVector(-5, 5)).display();
//        new Bouncer(new PVector(50,150), new PVector(5, -5)).display();
//        new Bouncer(new PVector(150,150), new PVector(-5, -5)).display();
        bouncers = new ArrayList<Bouncer>();
        bouncers.add(new Bouncer(50, 50, 3, 3));
    }

    @Override
    public void draw() {
        background(200);
        for(Bouncer bouncer : bouncers) {
            bouncer.move();
            bouncer.display();
        }
    }

    public Main() {
        instance = this;
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}