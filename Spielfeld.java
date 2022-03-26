
public class Spielfeld {
	private boolean ende;
    public boolean gewonnen() {
		return this.ende;
	}
	private char [][] spielfeld=new char[3][3];
    int schiffex;
    int schiffey;
    public void initialisierung(){
    	ende= false;
    	schiffex = (int)(Math.random() * 3);
    	schiffey = (int)(Math.random() * 3);
        for( int i=0;i<3;i++){    //Schleife für Zeilen
            for(int y=0;y<3;y++){  // Schleife für Spalten
                spielfeld[i][y]='-';
            }
        }  
    }
    public void anzeigen(){
        for( int i=0;i<3;i++){    //Schleife für Zeilen
            for(int y=0;y<3;y++){  // Schleife für Spalten
                System.out.print(spielfeld[i][y]);
            }
            System.out.println();
        }
    } 
    public boolean spielzug(char zeichen,int zeile, int spalte){
    	
       if(spielfeld[zeile][spalte]=='-') {
    	   spielfeld[zeile][spalte]=zeichen;
    	   if(zeile==this.schiffex && spalte==this.schiffey) {
       		spielfeld[zeile][spalte]='!';
       		ende=true;
       	}
    	   return true;
       }
       else {
    	   return false;
       }
    }    

}
