import processing.core.PApplet;

public class Main extends PApplet {

    public final static int backgroundColour = 0;
    public final static int panelWidth = 500;
    public final static int panelHeight = 300;
    public final static int ballDiameter = 15;
    public final static int ballRadius = ballDiameter/2;
    public int paddleWidth = 10;
    public int paddleHeight = 50;
    public int paddleX = 10;
    public int paddleY = paddleWidth;
    public int deltaPaddle = 10;
    public int ballX = paddleWidth*4 + ballDiameter;
    public int ballY = paddleWidth*4 + ballDiameter;
    public int deltaX = 10;
    public int deltaY = 10;

    @Override
    public void settings() {
        size(panelWidth, panelHeight);
    }

    @Override
    public void draw() {
        background(backgroundColour);
        drawBall();
        drawPaddle();
        moveBall();
        handleWallCollisions();
        handlePaddleCollisions();
    }

    public void drawBall() {
        pushMatrix();
        translate(ballX, ballY);
        circle(0, 0, ballDiameter);
        popMatrix();
    }

    public void drawPaddle() {
        pushMatrix();
        translate(paddleX, paddleY);
        rect(0, 0, paddleWidth, paddleHeight);
        popMatrix();
    }

    public void moveBall() {
        ballX += deltaX;
        ballY += deltaY;
    }

    public void handleWallCollisions() {
        if(ballX > panelWidth - ballRadius) { //east wall
            ballX = panelWidth - ballRadius;
            deltaX = -deltaX;
        }
        if(ballY < ballRadius) { //north wall
            ballY = ballRadius;
            deltaY = -deltaY;
        }
        if(ballY > panelHeight - ballRadius) { //south wall
            ballY = panelHeight - ballRadius;
            deltaY = -deltaY;
        }
        if(ballX < ballRadius) {
            exit();
        }
    }

    public void handlePaddleCollisions() {
        final int paddleStartY = paddleY;
        final int paddleEndY = paddleStartY + paddleHeight;

        if(ballY > paddleStartY - ballRadius && ballY < paddleEndY + ballRadius) {
            if(ballX < paddleX + paddleWidth) {
                ballX = paddleX + paddleWidth;
                deltaX = -deltaX;
            }
        }

    }

    @Override
    public void keyPressed() {
        switch(keyCode) {
            case UP -> {
                paddleY -= deltaPaddle;
                paddleY = Math.max(paddleY, paddleWidth);
            }
            case DOWN -> {
                paddleY += deltaPaddle;
                paddleY = Math.min(paddleY, height - paddleHeight - paddleWidth);
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}