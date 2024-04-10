package player;

import main.Game;
import utils.KeyUtil;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Enemy extends Player {

    private int Health = 5;
    private int Speed = 3;
    private int Damage = 20;
    private int x,y,width,height;
    public Enemy(Game g, KeyUtil keyUtil,int width, int height) {
        super(g, keyUtil);
        this.width = width;
        this.height = height;
    }

    public void followPlayer(int playerX, int playerY) {
        if(x < playerX+25) {
            x+=Speed;
        }
        if(y < playerY+37) {
            y+=Speed;
        }
        if(x > playerX+25) {
            x-=Speed;
        }
        if(y > playerY+37) {
            y-=Speed;
        }
    }

    public void dealDamage(int playerX,int playerY,Player p) {

        if(x+width >= playerX && x<=playerX+getPlayerWidth() && y+height >= playerY && y<=playerY+getPlayerHeight()){
            Timer resetTimer = new Timer();
            resetTimer.scheduleAtFixedRate(new TimerTask() {
                int count = 0;
                @Override
                public void run() {
                    if(count % 1000 == 0) {
                        p.setHealth(p.getHealth()-Damage);
                        setTakingDamage(true);

                    }
                    count++;
                    if (count == 5000) { // cd * 1000 milliseconds
                        resetTimer.cancel();
                        setTakingDamage(false);
                    }
                }
            }, 0, 1);
        }
    }
    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.fillOval(x,y,width,height);
    }
    public void update(int playerX, int playerY,Player p) {
        followPlayer(playerX, playerY);
        dealDamage(playerX,playerY,p);
    }
}