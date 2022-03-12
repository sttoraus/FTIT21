import java.util.Scanner;

public class Main {
	static Feld spielfeld=new Feld();
	static Spieler spieler=new Spieler();
	static Spieler pc=new Spieler();
	static Scanner s1=new Scanner(System.in);
	public static void init() {
		spielfeld.initialisieren();
		System.out.println("Bitte Name eingeben");
		spieler.setName(s1.next());
		pc.setName("PC");
	}
	public static void zugPC() {
		int rand1 = (int)(Math.random() * 3);
        int rand2 = (int)(Math.random() * 3);
        if(!spielfeld.spielzug('0',rand1, rand2)) {
        	zugPC();
        }
   
	}
	public static void zugSpieler() {
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
	public static void main(String[] args) {
		init();
		do {
			spielfeld.initialisieren();
			while(!spielfeld.getEnde()) {
				spielfeld.ausgabe();
				zugSpieler();
				if(spielfeld.getEnde()) {
					System.out.println("Spieler hat gewonnen");
					spieler.gewonnen();
					break;
				}
				zugPC();
				if(spielfeld.getEnde()) {
					System.out.println("PC hat gewonnen");
					pc.gewonnen();
					break;
				}
			}
			spielfeld.ausgabe();
			System.out.println("Spiel beendet");
			statistik();
		}while(spielen());
	
		
	}

	private static void statistik() {
		// TODO Auto-generated method stub
		System.out.println(spieler.getName()+" hat "+spieler.getSiege()+" mal gewonnen");
		System.out.println(pc.getName()+" hat "+pc.getSiege()+" mal gewonnen");
	}
	private static boolean spielen() {
		// TODO Auto-generated method stub
		System.out.println("Möchten Sie nochmal Spielen?");
		String eingabe=s1.next();
		if(eingabe.equals("Y")) {
			return true;
		}
		return false;
	}

}
