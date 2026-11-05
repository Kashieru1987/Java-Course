import processing.core.PApplet;

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
		imageMode(CENTER);

		bouncers = new ArrayList<Bouncer>();
		bouncers.add(new Bouncer(100, 100, 3, 3));
	}

	@Override
	public void draw() {
		background(200);
		for(Bouncer bouncer : bouncers) {
			bouncer.update();
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