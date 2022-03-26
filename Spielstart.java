import java.util.Scanner;

public class Spielstart {

	public static void main(String[] args) {
		Scanner s1=new Scanner(System.in);
	
		// TODO Auto-generated method stub
		Spiel schiffe=new Spiel();
		String wdh;
	
		schiffe.initialisieren();
		do {
			schiffe.spielfeld.initialisierung();
			while(true) {
				schiffe.spielfeld.anzeigen();
				schiffe.zugSpieler();
				if(schiffe.spielfeld.gewonnen()) {
					System.out.println("Spieler hat gewonnen");
					schiffe.spieler.gewonnen();
					break;
				}
				schiffe.zugPC();
				if(schiffe.spielfeld.gewonnen()) {
					System.out.println("PC hat gewonnen");
					schiffe.pc.gewonnen();
					break;
				}
			}
			schiffe.spielfeld.anzeigen();
			System.out.println("Spiel beendet");
			schiffe.statistik();
			System.out.println("Möchten Sie nochmals Spielen? j/n");
			wdh=s1.next();
			
		}while(wdh.equals("j"));
	}

}
