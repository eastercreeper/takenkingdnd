package player;

import classes.Classes;
import guns.Bullet;
import guns.BulletManager;
import main.Game;
import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import utils.KeyUtil;
import utils.MouseUtil;

import java.awt.*;
import java.util.ArrayList;

public class Player {
        private double Health;
        //top split
        private int mobility;
        private int resil;
        private int recov;
        // bottom split
        private int dicpline;
        private int intellect;
        private int strength;
        private Classes classs;
        private int Light;
    public boolean isTakingDamage() {
        return takingDamage;
    }
    public void setTakingDamage(boolean takingDamage) {
        this.takingDamage = takingDamage;
    }
    private double damageMultiplier;
    private boolean takingDamage;
    public int getPlayerWidth() {
        return playerWidth;
    }

    public int getPlayerHeight() {
        return playerHeight;
    }
        private int x,y;
        private int movementSpeed = 8;
        private int playerWidth = 50;
        protected int dir = 0;
        private int playerHeight = 75;
        Game g;
        KeyUtil keyUtil;

        BulletManager bulletManager = new BulletManager();

        public Player(Game g, KeyUtil keyUtil) {
            this.g = g;
            this.keyUtil = keyUtil;
        }
    public int getMovementSpeed() {
        return movementSpeed;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public double getHealth() {
        return Health;
    }
    public void setHealth(double health) {
        Health = health;
    }
    public void addHealth(double health) {
        Health += health;
    }
    public void setMobility(int mobility) {
        this.mobility = mobility;
    }
    public int getRecov() {
        return recov;
    }
    public void setRecov(int recov) {
        this.recov = recov;
    }
    public void setDicpline(int dicpline) {
        this.dicpline = dicpline;
    }
    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
    public int getRecovTier(int recov) {
        if(recov < 20 && recov <=10) {
            return 1;
        } else if (recov <30&& recov >= 20) {
            return 2;
        }else if (recov <40&& recov >= 30) {
            return 3;
        }else if (recov <50&& recov >= 40) {
            return 4;
        }else if (recov <60&& recov >= 50) {
            return 5;
        }else if (recov <70&& recov >= 60) {
            return 6;
        }else if (recov <80&& recov >= 70) {
            return 7;
        }else if (recov <90&& recov >= 80) {
            return 8;
        }else if (recov <100&& recov >= 90) {
            return 9;
        }else if (recov >= 100) {
            return 10;
        }
        return 0;
    }
    public void update(int x, int y) {
        updateShooting(x,y);
    }

    private void updateShooting(int x, int y) {

    }

    protected void shoot(int x, int y, double dir) {
            //dir *= 180/Math.PI;


    }
    public void draw(Graphics2D g2) {
        g2.setColor(Color.RED);

        g2.fillRect(x, y, playerWidth, playerHeight);
    }


}