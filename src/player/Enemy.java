package player;

import main.Game;
import utils.KeyUtil;

import java.awt.*;

public class Enemy extends Player {
    private int Health = 5;
    private double Speed = 10/240;
    private int Damage = 20;
    private int x,y,width,height;

    public Enemy(Game g, KeyUtil keyUtil,int width, int height) {
        super(g, keyUtil);
        this.width = width;
        this.height = height;
    }

    public void followPlayer(int playerX, int playerY) {
        if(x < playerX) {
            x+=1;
        }
        if(y < playerY) {
            y+=1;
        }
        if(x > playerX) {
            x-=1;
        }
        if(y > playerY) {
            y-=1;
        }
    }

    public void dealDamage() {
        if(x+width >= getX() && x<=getX()+getPlayerWidth() && y+height >= getY() && y<=getY()+getPlayerHeight()){
            setHealth(getHealth()-Damage);
        }
    }
    @Override
    public void draw(Graphics2D g2) {
        g2.fillOval(x,y,width,height);
    }
    public void update(int playerX, int playerY) {
        followPlayer(playerX, playerY);
        dealDamage();
    }
}
