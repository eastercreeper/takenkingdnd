package classes;

import main.Game;
import player.Player;
import utils.KeyUtil;

import java.awt.*;
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
    private double riftX = getX();
    private double riftY = getY();
    private boolean healingriftActive = false;
    private boolean empoweringRiftActive = false;
    private boolean healingriftUsed = false;
    private int HCooldownC = 0;

    private int riftType = 0;
    int r = 100;
    int diameter = r*2;


    KeyUtil keyUtil = new KeyUtil();
    Game g;
    public Warlock(Game g, KeyUtil keyUtil) {
        super(g,keyUtil);
        setHealth(200);
        setDicpline(20);
        setIntellect(20);
        setMobility(20);
        setStrength(20);
        setRecov(100);
        this.g = g;
        this.keyUtil = keyUtil;
    }



    public int setRiftCD(int recovTier) {
        if(recovTier == 0) {
            return 117;
        } else if(recovTier == 1) {
            return 102;
        } else if(recovTier == 2) {
            return 91;
        } else if(recovTier == 3) {
            return 82;
        } else if(recovTier == 4) {
            return 74;
        } else if(recovTier == 5) {
            return 68;
        } else if(recovTier == 6) {
            return 63;
        } else if(recovTier == 7) {
            return 59;
        } else if(recovTier == 8) {
            return 51;
        } else if(recovTier == 9) {
            return 46;
        } else if(recovTier == 10) {
            return 41;
        }
        return 117;
    }



    public void HealingRift() {
        if(!healingriftUsed) {
            //for 5 seconds heal 10 health every 1 second
            healingriftActive = true;

            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                int count = 0;

                @Override
                public void run() {
                    healingriftUsed = true;
                    if (getHealth() < 200 && getX() + getPlayerWidth() / 2 < riftX + r && getX() + getPlayerWidth() / 2 > riftX - r && getY() + getPlayerHeight() / 2 < riftY + r && getY() > riftY - r) {
                        addHealth(healthPerMilli);
                        System.out.println(getHealth());

                    } else if (getHealth() >= 200 && getHealth() < 215 && getX() < riftX + r && getX() > riftX - r && getY() < riftY + r && getY() > riftY - r) {
                        addHealth(healthPerMilli200plus);
                        System.out.println(getHealth());

                    }
                    count++;
                    if (count == 15000) { // 15 seconds * 1000 milliseconds
                        timer.cancel();
                        healingriftActive = false;
                        healingriftUsed = true;
                        setHealingriftUsed();
                    }
                }
            }, 0, 1);
        }
    }
    public void setHealingriftUsed() {
            healingriftActive = false;

            Timer resetTimer = new Timer();
            resetTimer.scheduleAtFixedRate(new TimerTask() {
                int count = 0;
                @Override
                public void run() {
                    count++;
                    HCooldownC++;
                    if (count == (setRiftCD(getRecovTier(getRecov()))*1000)) { // cd * 1000 milliseconds
                        resetTimer.cancel();
                        HCooldownC = 0;
                        healingriftUsed = false;
                    }
                }
            }, 0, 1);
    }


    public void empoweringRift() {
        empoweringRiftActive = true;

        Timer timer = new Timer();


        timer.scheduleAtFixedRate(new TimerTask() {
            int count = 0;
            @Override
            public void run() {
                if(getX()<riftX+r && getX()>riftX-r && getY() < riftY+r && getY()>riftY-r && !radiantActive) {
                    setDamageMultiplier(getUniversalMultiplier()+.2);
                }
                count++;
                if (count == 15000) { // 15 seconds * 1000 milliseconds
                    timer.cancel();
                    empoweringRiftActive = false;
                }
            }
        },0,1);
    }
    public void activateRadiant() {
        if(poweredMeeleKill) {

        }
    }

    @Override
    public void update() {
        if(keyUtil.upPressed) {
           setY(getY()- (5/g.getMultiplierFPS()));
        }
        if(keyUtil.leftPressed) {
            setX(getX()- (5/g.getMultiplierFPS()));
        }
        if(keyUtil.downPressed) {
            setY(getY()+ (5/g.getMultiplierFPS()));
        }
        if(keyUtil.rightPressed) {
            setX(getX()+ (5/g.getMultiplierFPS()));
        }
        if(keyUtil.healingriftPressed) {
            if(!healingriftActive) {
                HealingRift();
                riftX = getX();
                riftY = getY();
            }
        }
        if(keyUtil.empoweringPressed) {
            empoweringRift();
            riftX = getX();
            riftY = getY();
        }

    }
    public void draw(Graphics2D g2) {
        if(healingriftActive) {
            g2.setColor(Color.WHITE);
            g2.fillOval((int) riftX,(int) riftY,r,r);
        }
       if(HCooldownC<=30*1000 && healingriftUsed) {
            g2.setColor(Color.GRAY);
            g2.fillRect(10,getHEIGHT()-85   ,75,75);

        }
        super.draw(g2);

    }
}
