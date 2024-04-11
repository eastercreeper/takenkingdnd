package guns;

public class weapons {
    private int damage,type,ammo,reserves,ammotype;
    public weapons(int damage, int type, int ammotype) {
        this.damage = damage;
        this.type = type;
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
    public void seBaseAmmo(int ammotype) {
        if(ammotype == 1) {
            ammo = 36;
        }
        if(ammotype == 2) {
            ammo = 4;
        }
        if(ammotype == 3) {
            ammo = 1;
        }
    }
    public void setReserveAmmo(int ammotype) {
        if(ammotype == 1) {
            reserves = 324;
        }
        if(ammotype == 2) {
            reserves =  24;
        }
        if(ammotype == 3) {
            reserves =  6;
        }
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
