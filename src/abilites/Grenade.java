package abilites;

public class Grenade {
    private int BaseTime;
    private int diciplineTier;
    private int nadeTeir;
    private boolean isThrown = false;

    public int getBaseTime() {
        return BaseTime;
    }

    public void setBaseTime(int baseTime) {
        BaseTime = baseTime;
    }

    public int getDiciplineTier() {
        return diciplineTier;
    }

    public void setDiciplineTier(int diciplineTier) {
        this.diciplineTier = diciplineTier;
    }

    public int getNadeTeir() {
        return nadeTeir;
    }

    public void setNadeTeir(int nadeTeir) {
        this.nadeTeir = nadeTeir;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getDistance() {
        return Distance;
    }

    public void setDistance(double distance) {
        Distance = distance;
    }

    private double damage;
    private double Distance;
    public Grenade(int nadeTeir,double damage,double Distance) {
        this.nadeTeir = nadeTeir;
        this.damage = damage;
        this.Distance = Distance;
        if(nadeTeir == 7) {
            this.BaseTime = 64;
        }
        if(nadeTeir == 6) {
            this.BaseTime = 73;
        }
        if(nadeTeir == 5) {
            this.BaseTime = 82;
        }
        if(nadeTeir == 4) {
            this.BaseTime = 91;
        }
        if(nadeTeir == 3) {
            this.BaseTime = 105;
        }
        if(nadeTeir == 2) {
            this.BaseTime = 121;
        }
        if(nadeTeir == 1   ) {
            this.BaseTime = 152;
        }
    }
    public boolean isThrown() {
        if(!isThrown) {
            return false;
        } else if(isThrown) {
            return true;
        }
        return false;
    }
}
