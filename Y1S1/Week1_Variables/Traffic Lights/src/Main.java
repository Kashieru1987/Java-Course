import processing.core.PApplet;

import java.awt.*;

public class Main extends PApplet {

    int currentLamp = 0;

    final Color[] lampColors = new Color[] {
            Color.red,
            Color.yellow,
            Color.green
    };
    Color[] lamps = new Color[] {
            Color.red,
            Color.darkGray,
            Color.darkGray
    };

    final int panelWidth = 500;
    final int panelHeight = 500;

    final int lightPadding = 10;
    final int lampDiameter = 50;

    final int trafficLightWidth = lampDiameter + lightPadding*2;
    final int trafficLightHeight = lampDiameter*lamps.length + lightPadding*(lamps.length+1);


    @Override
    public void draw() {
        drawTrafficLight();
    }

    public void drawTrafficLight() {
        pushMatrix();
        translate(panelWidth/2 - trafficLightWidth/2, panelHeight/2 - trafficLightHeight /2);

        drawTrafficLightBox();
        drawTrafficLightLamps();

        popMatrix();
    }

    public void drawTrafficLightBox() {
        fill(Color.LIGHT_GRAY.getRGB());
        rect(0, 0, trafficLightWidth, trafficLightHeight);
    }

    public void drawTrafficLightLamps() {
        int startX = trafficLightWidth/2;
        int startY = lightPadding + lampDiameter/2;
        for(Color color : lamps) {
            fill(color.getRGB());
            circle(startX, startY, lampDiameter);
            startY += lightPadding + lampDiameter;
        }
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void keyPressed() {
        if(!(key == 'p' || key == 'P'))
            return;

        lamps[currentLamp] = Color.gray;
        currentLamp++;
        currentLamp = currentLamp > lamps.length - 1 ? 0 : currentLamp;
        lamps[currentLamp] = lampColors[currentLamp];
    }

    @Override
    public void settings() {
        this.size(panelWidth, panelHeight);
    }

}