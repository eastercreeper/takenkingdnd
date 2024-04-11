package guns;

import java.awt.*;

public class weapons {
    private int damage,type,ammo,reserves,ammotype;
    public weapons(int damage, int type, int ammo, int reserves, int ammotype) {
        this.damage = damage;
        this.type = type;
        this.ammo = ammo;
        this.reserves = reserves;
        this.ammotype = ammotype;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public int getReserves() {
        return reserves;
    }

    public void setReserves(int reserves) {
        this.reserves = reserves;
    }

    public int getAmmotype() {
        return ammotype;
    }

    public void setAmmotype(int ammotype) {
        this.ammotype = ammotype;
    }
    public int seBaseAmmo(int ammotype) {
        if(ammotype == 1) {
            return 36;
        }
        if(ammotype == 2) {
            return 4;
        }
        if(ammotype == 3) {
            return 1;
        }
        return 0;
    }
    public int setReserveAmmo(int ammotype) {
        if(ammotype == 1) {
            return 324;
        }
        if(ammotype == 2) {
            return 24;
        }
        if(ammotype == 3) {
            return 6;
        }
        return 0;
    }
    public void addAmmo(int pickupType) {
        if(pickupType == 1) {
            ammo+=72;
        }
        if(pickupType == 2) {
            ammo+=6;
        }
        if(pickupType == 3) {
            ammo+=2;
        }
    }

}
