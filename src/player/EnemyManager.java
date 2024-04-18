package player;

import guns.ammoBrick;
import main.Game;
import utils.KeyUtil;

import java.awt.*;
import java.util.ArrayList;

public class EnemyManager {
    ArrayList<Enemy> e = new ArrayList<Enemy>();

    public ArrayList<Enemy> getE() {
        return e;
    }

    Enemy temp;

    public void setE(ArrayList<Enemy> e) {
        this.e = e;
    }

    Game g;
    KeyUtil keyUtil;
    private int kills = 0;
    ammoBrick brickAmmo = new ammoBrick();
    private int x = (int) (Math.random() * 1920);
    private int y = (int) (Math.random() * 1080);

    public int getKills() {
        return kills;
    }

    public EnemyManager(int wave, int px, int py) {
        for(int i = 0; i < wave; i++) {
            x =(int)(Math.random() * 1920);
            y = (int)(Math.random() * 1080);
            if(x  > px -500 && x < px) {
                x-= 500;
            }
            if(x  < px + 500 && x > px) {
                x+=500;
            }
            if(y  > py - 500 && y < py) {
                y-= 500;
            }
            if(y  < py + 500 && y > py) {
                y+= 500;
            }
            addEnemy(new Enemy( x, y, 25, 25));
        }
    }
    public void draw(Graphics2D g2) {
        for (Enemy enemy : e) {
            temp = enemy;

            temp.draw(g2);
        }
    }

    public void update(int playerX, int playerY,Player p, int playerWidth, int playerHeight) {
        for(int i = 0; i < e.size(); i++) {
            temp = e.get(i);
                if(temp.geteHealth() <= 0) {
                    kills++;
                    removeEnemy(temp);
                    if(p.getHealth()<213) {
                        p.setHealth(p.getHealth() + 1);
                    }
                    if(p.getHealth()>=213) {
                        p.setHealth(215);
                    }
                }
            temp.update(playerX,playerY);
            temp.dealDamage(playerX,playerY,p, playerWidth, playerHeight);
            if(temp.isDealingDamage()) {
                removeEnemy(temp);
            }
        }

    }

    public void addEnemy(Enemy enemy) {
        e.add(enemy);
    }
    public void removeEnemy(Enemy enemy) {
        e.remove(enemy);
    }
}
