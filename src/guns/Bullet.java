package guns;

import org.lwjgl.input.Mouse;
import utils.MouseUtil;

import java.awt.*;

public class Bullet {
   private int x, y;
    private double angle;
    private int dx, dy;
    private int speed, rpm, range, dmg;
   MouseUtil mU;
    public Bullet() {
        speed = 20;
    }

    public void update(int px, int py) {
         dx = mU.getX() - px;
         dy = mU.getY() - py;

         angle = Math.atan2(dy, dx);
         System.out.println(angle);
        move();
    }

    public void move() {
        x += (int) Math.cos(angle);
        y += (int) Math.sin(angle);
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
