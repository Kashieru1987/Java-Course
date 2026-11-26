class Star {
  float x, y; // position
  float size; // radius
  color colour; // Processing colour representation
  float xt, yt; // target point - used by move method
  int numPoints; // number of 'points' of the star

  Star( float x, float y, float size, color colour, int numPoints ) {
    this.x = x;
    this.y = y;
    this.size = size;
    this.colour = colour;
    this.numPoints = numPoints;
    // set a target to move towards
    xt = x;
    yt = y;
  }

  void update() {
    move();
    render();
  }

  void render() {
    fill(colour);
    float dTheta = (float) Math.PI / (float) numPoints;

    beginShape(); // start a filled polygon
    float theta = 0;
    for ( int i = 0; i <= numPoints; i++ )
    {
      // add outer vertex
      vertex( (float)(x + size * Math.cos( theta )), (float)(y + size * Math.sin(theta)) );
      theta += dTheta;
      // add inner vertex
      vertex( (float)(x + 0.5 * size * Math.cos( theta )), (float)(y + 0.5 * size * Math.sin(theta)) );
      theta += dTheta;
    }
    endShape(); // end filled polygon
  }

  void move() {
    // is the centre close to the target?
    if ( (x-xt)*(x-xt) + (y-yt)*(y-yt) < 1 ) {
      // choose a new target
      xt = x + random( -50, 50 );
      yt = y + random( -50, 50 );
    }
    // move towards target
    x = xt * 0.05 + x * 0.95;
    y = yt * 0.05 + y * 0.95;
  }
}
