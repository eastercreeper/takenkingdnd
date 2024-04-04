package classes;

import main.Game;
import player.Player;
import utils.KeyUtil;

import java.util.Timer;
import java.util.TimerTask;

import static main.Main.getWIDTH;
import static main.Main.getHEIGHT;



public class Warlock extends Player {

    private double healthPerMilli =  0.004;
    private double healthPerMilli200plus = 0.003;
    private boolean radiantActive = false;
    private boolean poweredMeeleKill;
    public int getRiftCD() {
        return cooldownTier;
    }
    private int cooldownTier;
    public Warlock(Game g, KeyUtil keyUtil) {
        super(g,keyUtil);
        setHealth(200);
        setDicpline(20);
        setIntellect(20);
        setMobility(20);
        setStrength(20);
        setRecov(20);
    }



    public void setRiftCD(int recovTier) {
        if(recovTier == 0) {
            cooldownTier = 117;
        } else if(recovTier == 1) {
            cooldownTier = 102;
        } else if(recovTier == 2) {
            cooldownTier = 91;
        } else if(recovTier == 3) {
            cooldownTier = 82;
        } else if(recovTier == 4) {
            cooldownTier = 74;
        } else if(recovTier == 5) {
            cooldownTier = 68;
        } else if(recovTier == 6) {
            cooldownTier = 63;
        } else if(recovTier == 7) {
            cooldownTier = 59;
        } else if(recovTier == 8) {
            cooldownTier = 51;
        } else if(recovTier == 9) {
            cooldownTier = 46;
        } else if(recovTier == 10) {
            cooldownTier = 41;
        }
    }



    public void HealingRift() {
        //for 5 seconds heal 10 health every 1 second
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            int count = 0;

            @Override
            public void run() {
                if(getHealth()<200) {
                    addHealth(healthPerMilli);
                } else if(getHealth() >= 200 && getHealth() <215) {
                    addHealth(healthPerMilli200plus);
                }
                count++;
                System.out.println(getHealth());
                if (count == 15000) { // 15 seconds * 1000 milliseconds
                    timer.cancel();
                }
            }
        },0,1);
    }


    public void empoweringRift() {
        Timer timer = new Timer();
        double riftX = getX();
        double riftY = getY();

        timer.scheduleAtFixedRate(new TimerTask() {
            int count = 0;

            @Override
            public void run() {
                if(riftX >=getX() && riftX <=getX()+100 && riftY >=getY() && riftY <=getY()+100 && riftY >=getY() && !radiantActive) {
                    setDamageMultiplier(getUniversalMultiplier()+.2);
                }
                count++;
                if (count == 15000) { // 15 seconds * 1000 milliseconds
                    timer.cancel();
                }
            }
        },0,1);
    }
    public void activateRadiant() {
        if(poweredMeeleKill) {

        }
    }
}
