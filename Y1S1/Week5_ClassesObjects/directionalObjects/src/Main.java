import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class Main extends PApplet {

	public volatile static Main instance;
	public List<Bouncer> bouncers;

	/**
	 * the only thing this is really needed for here is setting the frame size
	 */
	@Override
	public void settings() {
		size(500, 300);
	}

	/**
	 * for all the stuff we only wanna do once:
	 * - makes sure bouncers are drawn from the centre
	 * - initialises and stores all the bouncers
	 */
	@Override
	public void setup() {
		imageMode(CENTER);

		bouncers = new ArrayList<Bouncer>();
		bouncers.add(new Bouncer(100, 100, 3, 3));
		bouncers.add(new Bouncer(300, 250, -3, 3));
		bouncers.add(new Bouncer(200, 150, 3, -3));
	}

	/**
	 * handles everything we wanna redo every frame:
	 * - refreshes the background
	 * - handles collisions
	 * - displays the bouncers
	 */
	@Override
	public void draw() {
		background(200); // necessary otherwise bouncers leave a trail

		// check collisions between bouncers
		for(int i = 0; i < bouncers.size(); i++) {
			final Bouncer bouncer = bouncers.get(i);

			for(int j = 0; j < bouncers.size(); j++) {
				if(i == j) // to avoid bouncers colliding with themselves
					continue;

				final Bouncer bouncer2 = bouncers.get(j);

				// bounce the bouncers if they're colliding
				if(dist(bouncer.position.x, bouncer.position.y, bouncer2.position.x, bouncer2.position.y) < 50) {
					bouncer.bounce();
					bouncer2.bounce();
				}

			}

			// update then move
			bouncer.update();
			bouncer.display();
		}
	}

	public Main() {
		// required in some farm as multiple files are being used
		instance = this;
	}

	public static void main(String[] args) {
		PApplet.main("Main");
	}
}