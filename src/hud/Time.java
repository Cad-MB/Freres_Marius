package hud;

public class Time implements Runnable{
    private int compteurTemps;
	private String str;
	public Time(){

		this.compteurTemps = 100; 
		this.str = "Temps restant : 100";
		
		Thread compteARebours = new Thread(this);
		compteARebours.start();
	}
	public int getCompteurTemps() {return compteurTemps;}
    public String getStr() {return str;}
	@Override
	public void run() {
		while(true){
		    try{
                int PAUSE = 1000;
                Thread.sleep(PAUSE);}
			catch (InterruptedException _){}
			this.compteurTemps--;
			this.str = STR."Temps restant : \{this.compteurTemps}";
		}		
	}
}
