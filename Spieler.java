
public class Spieler {
	private String name;
	private int siege =0;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSiege() {
		return siege;
	}
	public void gewonnen() {
		this.siege++;
	}
}
