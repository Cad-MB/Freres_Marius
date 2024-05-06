package map;

import mechanics.Main;

public class HUB implements Runnable {
    private int nbrePieces;
    private int compteurTemps;
    private String str;
    private long lastUpdateTime;  // Added for time tracking

    public HUB() {
        // Initialize score
        this.nbrePieces = 0;

        // Initialize timer
        this.compteurTemps = 100;
        this.str = "Remaining time : " + this.compteurTemps;

        // Record the current time when the instance is created
        this.lastUpdateTime = System.currentTimeMillis();

        // Start unified countdown timer and repaint thread
        Thread compteARebours = new Thread(this);
        compteARebours.start();
    }

    // Score methods
    public int getNbrePieces() {
        return nbrePieces;
    }

    public void setNbrePieces(int nbrePieces) {
        this.nbrePieces = nbrePieces;
    }

    public int getNBRE_TOTAL_PIECES() {
        return 15;
    }

    // Timer methods
    public int getCompteurTemps() {
        return compteurTemps;
    }

    public String getStr() {
        return str;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (Main.level1Scene != null) {
                    Main.level1Scene.repaint();  // Continues to handle frequent game updates
                }
                Thread.sleep(3);  // Sleep for 3 milliseconds

                long currentTime = System.currentTimeMillis();
                // Check if a second has passed since the last update
                if (currentTime - lastUpdateTime >= 1000) {
                    this.compteurTemps--;  // Decrement the timer
                    this.str = "Remaining time : " + this.compteurTemps;
                    lastUpdateTime = currentTime;  // Reset the last update time
                }
            } catch (InterruptedException e) {
                e.printStackTrace();  // Handle interruptions
            }
        }
    }

}
