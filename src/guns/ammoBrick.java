package guns;

import java.awt.*;

public class ammoBrick {
    public ammoBrick() {
    }

    public void draw(Graphics2D g2,int x,int y,int ammoType) {
        g2.setColor(Color.GRAY);
        g2.fillRect(x,y,7,5);
        if(ammoType == 1) {
            g2.setColor(Color.WHITE);
        }
        if(ammoType == 2) {
            g2.setColor(Color.GREEN);
        }
        if(ammoType == 3) {
            g2.setColor(new Color(131, 0, 255));
        }
        g2.fillRect(x+1,y+1,5,3);

    }
}
