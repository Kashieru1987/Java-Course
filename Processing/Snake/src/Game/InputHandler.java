package Game;

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

        inputQueue.removeFirst();
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
