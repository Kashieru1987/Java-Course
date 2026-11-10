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
		bouncers.add(new Bouncer(300, 250, -3, 3));
		bouncers.add(new Bouncer(200, 150, 3, -3));
	}

	@Override
	public void draw() {
		background(200);
		for(int i = 0; i < bouncers.size(); i++) {
			final Bouncer bouncer = bouncers.get(i);

			for(int j = 0; j < bouncers.size(); j++) {
				if(i == j)
					continue;
				final Bouncer bouncer2 = bouncers.get(j);
				if(dist(bouncer.position.x, bouncer.position.y, bouncer2.position.x, bouncer2.position.y) < 50) {
					bouncer.bounce();
					bouncer2.bounce();
				}

			}

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