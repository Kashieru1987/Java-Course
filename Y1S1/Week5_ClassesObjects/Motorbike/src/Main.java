import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class Main extends PApplet {

    private final int colourRed = color(255, 0, 0);
    private final int colourBlue = color(0, 0, 255);
    private final int colourGreen = color(0, 255, 0);
    private List<Motorbike> motorbikes;
    private GameModes gameMode = GameModes.RACING;

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    @Override
    public void settings() {
        size(500, 500);
    }

    @Override
    public void setup() {
        motorbikes = new ArrayList<Motorbike>();
        motorbikes.add(new Motorbike(50, colourRed));
        motorbikes.add(new Motorbike(100, colourBlue));
        motorbikes.add(new Motorbike(150, colourGreen));
    }

    @Override
    public void draw() {
        background(200);
        switch(gameMode) {
            case RACING -> {
                for (Motorbike bike : motorbikes) {
                    bike.update();
                }
            }
            case FINISH -> {
                text("Game Over", 30, 30);
            }
        }
    }

    class Motorbike {
        int x = 5;
        int y;
        int speed;
        int size=30;
        int colour;

        public Motorbike(int y, int colour) {
            this.y = y;
            this.speed = (int) (Math.random() * 6);
            this.colour = colour;
        }

        public void update() {
            this.move();
            this.display();
        }

        private void display() {
            float wheelHeight = size/3;
            fill(colour);
            triangle(x,y,x+size,y,x+size/2,y-size/2);  //built-in triangle routine
            drawWheel(x,y,wheelHeight);
            drawWheel(x+size,y,wheelHeight);
        }

        private void drawWheel(int x, int y, float size) {
            float inner = size*2/3;
            fill(0);
            ellipse(x,y,size,size);
            fill(255);
            ellipse(x,y,inner,inner);
        }

        private void move() {
            if(isFinished()) {
                gameMode = GameModes.FINISH;
                return;
            }
            this.x += speed;
        }

        private boolean isFinished() {
            return x > width-50;
        }

    }

}