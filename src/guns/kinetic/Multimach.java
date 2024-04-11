package guns.kinetic;

import guns.weapons;
import utils.MouseUtil;

public class Multimach extends weapons {
    MouseUtil mouseUtil;

    public Multimach() {
        super(10, 1, 1);
        seBaseAmmo(1);
        setReserveAmmo(1);
        setAmmotype(1);
        mouseUtil = new MouseUtil();
    }


    public void update() {

    }

    public void draw() {

    }
}
