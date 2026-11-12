import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Bouncer {

	public final String text = "MC25883357";
	public PImage upLeft;
	public PImage upRight;
	public PImage downLeft;
	public PImage downRight;

	public PApplet panel;
	public PVector position;
	public PVector delta;
	public PImage image;

	// constructor overloading, otherwise things become unreasonably long

	/**
	 * overloaded constructor, needed otherwise creating a new bouncer becomes unreasonably long
	 * @param x the x position
	 * @param y the y position
	 * @param deltaX the change in x position for the next frame
	 * @param deltaY the change in y position for the next frame
	 */
	public Bouncer(int x, int y, int deltaX, int deltaY) {
		this(new PVector(x, y), new PVector(deltaX, deltaY));
	}

	/**
	 * main constructor, stores position and delta as a vector
	 * also loads and sets the image, based on the delta given
	 * @param position the current position
	 * @param delta the change in position for the next frame
	 */
	public Bouncer(PVector position, PVector delta) {
		this.panel = Main.instance;
		this.position = position;
		this.delta = delta;

		this.getImages(); // loads the images
		setImage(); // sets image depending on direction
	}

	/**
	 * collides and moves
	 */
	public void update() {
		handleWallCollisions();
		move();
	}

	/**
	 * simple bounce, reverses the current delta
	 */
	public void bounce() {
		this.delta = delta.mult(-1);
		setImage();
	}

	/**
	 * displays the arrow with the text attached
	 */
	public void display() {
		panel.image(image, position.x, position.y);
		panel.fill(255, 0, 0);
		panel.text(text, position.x, position.y);
	}

	/**
	 * simple move implementation, just adds delta to position
	 */
	private void move() {
		position.add(delta);
	}

	/**
	 * sets the image of the bouncer depending on the current delta (the direction it's travelling)
	 */
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

	/**
	 * collisions for walls
	 * appropriately sets the distance the bouncer should be from the wall
	 * also reverses the delta for that axis
	 */
	private void handleWallCollisions() {
		final int width = panel.width;
		final int height = panel.height;
		final int imagePadding = 40;

		if(position.x - imagePadding < 0) {
			delta.x = -delta.x;
			position.x = imagePadding;
			setImage();
		}

		if(position.x + imagePadding > width) {
			delta.x = -delta.x;
			position.x = width - imagePadding;
			setImage();
		}

		if(position.y - imagePadding < 0) {
			delta.y = -delta.y;
			position.y = imagePadding;
			setImage();
		}

		if(position.y + imagePadding > height) {
			delta.y = -delta.y;
			position.y = height - imagePadding;
			setImage();
		}

	}

	/**
	 * loading is expensive, so ideally we only want to do this once
	 * this is intended for use in the constructor
	 * it initialises the values of the directionPImages
	 */
	private void getImages() {
		upLeft = panel.loadImage("directions/upLeft.png");
		upRight = panel.loadImage("directions/upRight.png");
		downLeft = panel.loadImage("directions/downLeft.png");
		downRight = panel.loadImage("directions/downRight.png");
	}

}