package Game;

import Util.Directions;
import Util.InputListener;

import java.util.ArrayList;
import java.util.List;

public class InputHandler implements InputListener {

    private final List<String> inputQueue;

    public InputHandler() {
        this.inputQueue = new ArrayList<String>();
    }

    public void handleInputs() {
        System.out.println(inputQueue);

        if(inputQueue.isEmpty())
            return;

        final String input = inputQueue.removeFirst();
        final Snake snake = Main.getInstance().getSnake();
        final Directions direction = snake.getDirection();
        switch(input.toUpperCase()) {
            case "W" -> {
                if(direction.equals(Directions.SOUTH))
                    return;
                snake.setDirection(Directions.NORTH);
            }
            case "A" -> {
                if(direction.equals(Directions.WEST))
                    return;
                snake.setDirection(Directions.EAST);
            }
            case "S" -> {
                if(direction.equals(Directions.NORTH))
                    return;
                snake.setDirection(Directions.SOUTH);
            }
            case "D" -> {
                if(direction.equals(Directions.EAST))
                    return;
                snake.setDirection(Directions.WEST);
            }
        }
    }

    @Override
    public void keyPressed(char key) {
        final String character = "" + key;
        if(!inputQueue.isEmpty())
            if(inputQueue.getLast().equals(character))
                return;
        inputQueue.add(character);

        if(inputQueue.size() > 3) {
            inputQueue.removeFirst();
        }
    }

    @Override
    public void keyReleased(char key) {
    }
}
