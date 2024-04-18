package utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyUtil implements KeyListener {

    public boolean upPressed,downPressed,leftPressed,rightPressed,healingriftPressed,empoweringPressed,escPressed;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W) {
            upPressed = true;
        }
        if(code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if(code == KeyEvent.VK_S) {
            downPressed = true;
        }
        if(code == KeyEvent.VK_D) {
            rightPressed = true;
        }
        if(code == KeyEvent.VK_X) {
            healingriftPressed = true;
        }
        if(code == KeyEvent.VK_Z) {
            empoweringPressed = true;
        }
        if(code == KeyEvent.VK_ESCAPE && !escPressed) {
            escPressed = true;
        }
        if(code == KeyEvent.VK_ESCAPE && escPressed) {
            escPressed = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if(code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if(code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if(code == KeyEvent.VK_D) {
            rightPressed = false;
        }
        if(code == KeyEvent.VK_X) {
            healingriftPressed = false;
        }
        if(code == KeyEvent.VK_Z) {
            empoweringPressed = false;
        }
    }
}
