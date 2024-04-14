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

    public EnemyManager(int wave) {
        for(int i = 0; i < wave; i++) {
            x = (int) (Math.random() * 1920);
            y = (int) (Math.random() * 1080);
            addEnemy(new Enemy(g,keyUtil,x,y,25,25));
        }
    }
    public void draw(Graphics2D g2) {
        for (Enemy enemy : e) {
            temp = enemy;

            temp.draw(g2);
        }
    }

    public void update(int playerX, int playerY,Player p) {
        for(int i = 0; i < e.size(); i++) {
            temp = e.get(i);
                if(temp.geteHealth() <= 0) {
                    kills++;
                    removeEnemy(temp);
                }
            temp.update(playerX,playerY);
            temp.dealDamage(playerX,playerY,p);
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
