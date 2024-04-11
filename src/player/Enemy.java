package player;

import guns.ammoBrick;
import main.Game;
import utils.KeyUtil;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Enemy extends Player {

    private int Health = 5;
    private int spawnRate = 1;
    private int Speed = 3;
    private boolean alive = true;
    private boolean isDead = false;
    ammoBrick brickAmmo = new ammoBrick();

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }

    private int Damage = 20;
    private int x,y,width,height;

    public int geteHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    public Enemy(Game g, KeyUtil keyUtil, int width, int height) {
        super(g, keyUtil);
        this.width = width;
        this.height = height;
    }

    public void followPlayer(int playerX, int playerY) {
        if(alive) {
            if (x < playerX + 25) {
                x += Speed;
            }
            if (y < playerY + 37) {
                y += Speed;
            }
            if (x > playerX + 25) {
                x -= Speed;
            }
            if (y > playerY + 37) {
                y -= Speed;
            }
        }
    }



    public void dealDamage(int playerX,int playerY,Player p) {
    if(alive) {
        if (x + width >= playerX && x <= playerX + getPlayerWidth() && y + height >= playerY && y <= playerY + getPlayerHeight()) {
            Health--;
//            Timer resetTimer = new Timer();
//            resetTimer.scheduleAtFixedRate(new TimerTask() {
//                int count = 0;
//                @Override
//                public void run() {
//                    if(count % 1000 == 0) {
//                        p.setHealth(p.getHealth()-Damage);
//                        setTakingDamage(true);
//
//                    }
//                    count++;
//                    if (count == 5000) { // cd * 1000 milliseconds
//                        resetTimer.cancel();
//                        setTakingDamage(false);
//                    }
//                }
//            }, 0, 1);
        }
    }
    }

@Override
    public void draw(Graphics2D g2) {
        if(alive) {
            g2.setColor(Color.WHITE);
            g2.fillOval(x, y, width, height);
        }
            if (Health <= 0) {
                double chanceToDrop = Math.random() * 100;
                double AmmoDropped = Math.random() * 100;
                if (chanceToDrop >= 70) {
                    if (AmmoDropped <= 60) {
                        brickAmmo.draw(g2, x, y, 1);
                    }
                    if (AmmoDropped > 60 && AmmoDropped < 90) {
                        brickAmmo.draw(g2, x, y, 2);
                    }
                    if (AmmoDropped > 90) {
                        brickAmmo.draw(g2, x, y, 3);
                    }
                }
            }
    }
    public void update(int playerX, int playerY,Player p) {
        followPlayer(playerX, playerY);
        dealDamage(playerX,playerY,p);
    }
}
