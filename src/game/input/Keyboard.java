package game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Evan_2 on 2017-05-03.
 */
public class Keyboard implements KeyListener{

    private boolean[] keys = new boolean[65536];
    public boolean up, down, left, right;

    public void update() {
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}
