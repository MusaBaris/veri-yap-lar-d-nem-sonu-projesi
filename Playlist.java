// Geçen hafta çift yönlü bağlı liste ile Plylist sınıfını oluşturmuştuk. Sonra kontrol sırasında  önceki ve sonraki şarkıya geçişi linked list ile daha kolay olacağını konuştuk. Daha az alan kaplayacağını konuşmuştuk. 
//Bu ölçüde bu kısmı güncelledim.

public class Playlist{
	private class Node {
		Song data;
		Node next;

		Node (Song data) {
			this.data = data;
		}
	} 

	private Node head; //Bu listemizin başındaki düğümümüz.
	private Node current; //Bu da şu an çaldığımız şarkı.

	//Sona şarkı ekleyelim 
	public void add(Song song) {
		Node newNode = new Node (song);
		if (head == null) {
			head = newNode;
		    current = newNode; }
		else {
			Node temp = head; 
			while (temp.next != null ) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	//Sonraki şarkıya geçelim.
public Song next() {
	if ( head == null ) {
		System.out.println("Çalma listeniz boş.");
		return null;
	}
	if( current.next == null ) {
		System.out.println("Listenin sonundasınız, sonraki şarkı yok. ");
		return current.data;
	}
	current = current.next; 
	return current.data;
}

	//Önceki şarkıya geçelim

	public Song previous() {
		if (head == null) {
			System.out.println("Çalma listeniz boş.");
			return null;
		}
		if (current == head) {
			System.out.println("Listenin başındasınız, önceki şarkı yok. ");
			return current.data;
		}
		Node temp = head;
		while ( temp.next != current ) {
			temp = temp.next;
		}
		current = temp;
		return current.data;
	}
}
