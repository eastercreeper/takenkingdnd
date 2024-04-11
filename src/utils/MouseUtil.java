package utils;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseUtil implements MouseListener {
    private boolean lmb;

    public boolean isLmb() {
        return lmb;
    }

    public void setLmb(boolean lmb) {
        this.lmb = lmb;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {
            lmb = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {
            lmb = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
