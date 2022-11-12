
public class Setup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyList list=new MyList();
		list.add("Hans");
		list.add("Peter");
		list.add("Semmel");
		list.printAll();
	}
}

public class ListItem {
	Object content; // Inhalt, z.B. String
	ListItem next = null; // nächstes Element

	// Konstruktor
	ListItem(Object x) {
		content = x;
	}
}

public class MyList {
	// ListItem first = null; // erstes Element oder null
	ListItem first = null;

	void add(Object x) {
		ListItem li = new ListItem(x);
		if (first == null) {
			// Fall 1: dies ist das erste Element überhaupt
			first = li;
		} else {
			// Fall 2: es gibt bereits Elemente
			ListItem last = getLastItem();
			last.next = li;
		}
	}
	public ListItem getLastItem() {
		// zur Sicherheit: Liste darf nicht leer sein
		// ... sonst bekommen Sie unten bei item.next einen Fehler!
		if (first == null) {
			return null;
		}
		// Schleife: solange Nachfolger vorhanden,
		// gehe zum Nachfolger
		ListItem item = first; // beginne beim ersten Item
		// Hat das Item einen Nachfolger... ?
		while (item.next != null) {
			item = item.next; // ... dann gehe zum Nachfolger
		}
		// Dieses Item hatte keinen Nachfolger
		// => muss das letzte sein
		return item;
	}
	void printAll() {
		ListItem item = first;
		int counter = 0;
		while (item != null) {
			System.out.println(counter + ": " + item.content);
			item = item.next;
			counter++;
		}
	}
}