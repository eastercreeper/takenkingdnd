package utils;

import org.lwjgl.Sys;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseUtil implements MouseListener {
    private boolean lmb;
    private int x, y;

    public boolean isLmb() {
        return lmb;
    }

    public void setLmb(boolean lmb) {
        this.lmb = lmb;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {
            System.out.println("help");
            x=e.getX();
            y=e.getY();
            lmb = true;
        }
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }
}
