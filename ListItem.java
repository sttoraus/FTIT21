
public class ListItem {
	Object content; // Inhalt, z.B. String
	ListItem next = null; // nächstes Element

	// Konstruktor
	ListItem(Object x) {
		content = x;
	}
}