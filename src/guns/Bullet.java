package guns;

import org.lwjgl.input.Mouse;
import utils.MouseUtil;

import java.awt.*;

public class Bullet {
   MouseUtil mU = new MouseUtil();
    private int x, y;// Bullet position
    private double angle,dx,dy;
    private int targetX, targetY; // Mouse positio
    public Bullet(int x, int y, int targetX, int targetY) {
        this.x = x;
        this.y = y;
        this.targetX = targetX;
        this.targetY = targetY;
         dx = targetX - x;
         dy = targetY - y;
        angle = Math.atan2(dy,dx);
    }


    public void update() {

        x += (int) Math.cos(angle);
        y += (int) Math.sin(angle);
    }

    public void move() {
    }

//    public void tick(int px, int py) {
//        double dx = Math.abs(Mouse.getX() - px);
//        double dy = Math.abs(Mouse.getY() - py);
//        double angle = Math.atan2(dy,dx);
//
//        x += (int) (Math.cos(Math.toRadians(angle)) * 15);
//        y += (int) (Math.sin(Math.toRadians(angle)) * 15);
//
//    }


    public void draw(Graphics2D g2) {
            g2.setColor(Color.white);
            g2.fillRect((int)x,(int)y,10,4);
    }
}
