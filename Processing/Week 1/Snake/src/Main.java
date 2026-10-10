import processing.core.PApplet;

public class Main {

    public volatile static Main instance;
    public Panel panel;

    public void setPanel(Panel panel) {
        this.panel = panel;
    }

    public static Main getInstance() {
        Main mainInstance = instance;
        if(mainInstance == null) {
            synchronized (Main.class) {
                mainInstance = instance;
                if(mainInstance == null) {
                    instance = mainInstance = new Main();
                }
            }
        }
        return mainInstance;
    }

    private Main() {
        PApplet.main("Panel");
        this.setPanel(Panel.instance);
        panel.addToDrawQueue(Test::drawSquare);
        panel.addToDrawQueue(Test::drawCircle);
    }

    public static void main(String[] args) {
        Main.getInstance();
    }
}