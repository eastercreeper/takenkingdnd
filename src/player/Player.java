package player;

import classes.Classes;

public class Player {
        private int Health;
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

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
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

}