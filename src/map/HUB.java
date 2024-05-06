package map;

import mechanics.Main;

public class HUB implements Runnable {
    private int nbrCoins;
    private int countTime;
    private String str;
    private long lastUpdateTime;

    public HUB() {
        this.nbrCoins = 0;

        this.countTime = 100;
        this.str = STR."Remaining time : \{this.countTime}";

        this.lastUpdateTime = System.currentTimeMillis();

        Thread countToEnd = new Thread(this);
        countToEnd.start();
    }

    public int getNbrCoins() {
        return nbrCoins;
    }

    public void setNbrCoins(int nbrCoins) {
        this.nbrCoins = nbrCoins;
    }

    public int getNbrTotalCoins() {
        return 15;
    }

    public int getCountTime() {
        return countTime;
    }

    public String getStr() {
        return str;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (Main.level1Scene != null) {
                    Main.level1Scene.repaint();
                }
                Thread.sleep(3);

                long currentTime = System.currentTimeMillis();
                if (currentTime - lastUpdateTime >= 1000) {
                    this.countTime--;
                    this.str = STR."Remaining time : \{this.countTime}";
                    lastUpdateTime = currentTime;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
