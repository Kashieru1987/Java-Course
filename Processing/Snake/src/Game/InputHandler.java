package Game;

import Util.InputListener;

import java.util.ArrayList;
import java.util.List;

public class InputHandler implements InputListener {

    private final List<String> pressedKeys;
    private final List<String> releasedKeys;

    public InputHandler() {
        this.pressedKeys = new ArrayList<String>();
        this.releasedKeys = new ArrayList<String>();
    }

    public void handleInputs() {
        System.out.println(pressedKeys);

        for(String key : releasedKeys)
            pressedKeys.remove(key);
    }

    @Override
    public void keyPressed(char key) {
        final String character = "" + key;
        if(pressedKeys.contains(character))
            return;
        pressedKeys.add(character);
    }

    @Override
    public void keyReleased(char key) {
        final String character = "" + key;
        if(releasedKeys.contains(character))
            return;
        releasedKeys.add(character);
    }

}
