package player;

import classes.Classes;
import main.Game;
import utils.KeyUtil;

import java.awt.*;

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
        private double damageMultiplier;
        private double universalMultiplier = 1;
        private int x,y;
        private double movementSpeed = 1;


        Game g;
        KeyUtil keyUtil;

        public Player(Game g, KeyUtil keyUtil) {
            this.g = g;
            this.keyUtil = keyUtil;
        }
    public double getUniversalMultiplier() {
        return universalMultiplier;
    }

    public void setUniversalMultiplier(double universalMultiplier) {
        this.universalMultiplier = universalMultiplier;
    }

    public double getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(double movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public Classes getClasss() {
        return classs;
    }

    public void setClasss(Classes classs) {
        this.classs = classs;
    }

    public int getLight() {
        return Light;
    }

    public void setLight(int light) {
        Light = light;
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

    public double getDamageMultiplier() {
        return damageMultiplier;
    }

    public void setDamageMultiplier(double damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
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

    public int getMobility() {
        return mobility;
    }

    public void setMobility(int mobility) {
        this.mobility = mobility;
    }

    public int getResil() {
        return resil;
    }

    public void setResil(int resil) {
        this.resil = resil;
    }

    public int getRecov() {
        return recov;
    }

    public void setRecov(int recov) {
        this.recov = recov;
    }

    public int getDicpline() {
        return dicpline;
    }

    public void setDicpline(int dicpline) {
        this.dicpline = dicpline;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public int getStrength() {
        return strength;
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
    public void update() {

        if(keyUtil.upPressed) {
            y -= (5/g.getMultiplierFPS());
        }
        if(keyUtil.leftPressed) {
            x -= (5/g.getMultiplierFPS());
        }
        if(keyUtil.downPressed) {
            y+=(5/g.getMultiplierFPS());
        }
        if(keyUtil.rightPressed) {
            x+=(5/g.getMultiplierFPS());
        }
    }
    public void draw(Graphics2D g2) {
        g2.setColor(Color.RED);

        g2.fillRect(x, y, 200, 200);
    }


}