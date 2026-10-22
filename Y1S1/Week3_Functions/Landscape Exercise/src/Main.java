import processing.core.PApplet;

import java.awt.*;

public class Main extends PApplet {

    final int panelWidth = 1000;
    final int panelHeight = 500;

    final int skyColor = new Color(135, 206, 235).getRGB();
    final int landColor = new Color(126, 200, 80).getRGB();
    final int sunColor = new Color(255, 255, 0).getRGB();
    final int cloudColor = new Color(255, 255, 255).getRGB();

    final int cloudSize = 50;
    final int sunSize = 50;

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    @Override
    public void settings() {
        size(panelWidth, panelHeight);
    }

    @Override
    public void draw() {
        drawLandscape();
    }

    public void drawLandscape() {
        drawSky();
        drawLand();
    }

    public void drawSky() {
        fill(skyColor);
        stroke(skyColor);
        rect(0, 0, panelWidth, (float) panelHeight/2);

        final int quarterWidth = panelWidth/4;
        drawCloud(quarterWidth, panelHeight/4, cloudSize);
        drawCloud(quarterWidth * 3, panelHeight/4, cloudSize);
        drawSun(panelWidth/2, panelHeight/4, sunSize);
    }

    public void drawLand() {
        fill(landColor);
        stroke(landColor);
        rect(0, (float) panelHeight /2, panelWidth, (float) panelHeight /2);
    }

    public void drawSun(int x, int y, int size) {
        pushMatrix();
        translate(x, y);

        fill(sunColor);
        stroke(sunColor);
        for(int i = 0; i < 360; i += 10) {
            pushMatrix();
            rotate(radians(i));
            line(0, 0, 0, size);
            popMatrix();
        }

        circle(0, 0, size);

        popMatrix();
    }

    public void drawCloud(int x, int y, int size) {
        pushMatrix();
        translate(x, y);

        final int quarter = size/4;

        fill(cloudColor);
        stroke(Color.BLACK.getRGB());
        circle(-size/2, size/4, size*3/4);
        circle(0, 0, size);
        circle(size/2, size/4, size*3/4);

        popMatrix();
    }

}