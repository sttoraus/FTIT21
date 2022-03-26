import java.util.Scanner;

public class Spiel {
	Spielfeld spielfeld=new Spielfeld();
	Spieler spieler=new Spieler();
	Spieler pc=new Spieler();
	Scanner s1=new Scanner(System.in);
	public void initialisieren() {
		spielfeld.initialisierung();
		System.out.println("Bitte Name eingeben");
		spieler.setName(s1.next());
		pc.setName("PC");
	}
	public void zugPC() {
		int rand1 = (int)(Math.random() * 3);
        int rand2 = (int)(Math.random() * 3);
        if(!spielfeld.spielzug('0',rand1, rand2)) {
        	zugPC();
        }
	}
        public void zugSpieler() {
    		System.out.println("Ihr Zug Bitte");
    		try {
    			int x=s1.nextInt();
    			int y=s1.nextInt();
    			if(!spielfeld.spielzug('X',x,y )){
    				zugSpieler();
    			}
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			System.out.println("Fehler");
    			s1.next();
    			zugSpieler();
    		}
    	}
        public void statistik() {
    		// TODO Auto-generated method stub
    		System.out.println(spieler.getName()+" hat "+spieler.getSiege()+" mal gewonnen");
    		System.out.println(pc.getName()+" hat "+pc.getSiege()+" mal gewonnen");
    	}
    
}
