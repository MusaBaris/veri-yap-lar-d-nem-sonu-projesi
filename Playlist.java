

public class Playlist {
	private Node head;
	private Node tail;
	private Node current;	
	private int size;

	//EKLEME TEST İÇİN YORUM SATIRI OLABİLİR.

	public void add(Song song) {
		Node n = new Node(song);
		if (head == null) {
			head = tail = current = n;
		} else {
			tail.next = n;
			n.prev = tail;
			tail = n;
		}
		size++;
	}

	//SONRAKİ ŞARKIYA GEÇ 

	public Song next() {
		is (isEmpty()) {
			System.out.println("Çalma listesi boş.");
			return null;
		}
		if (current.next == null)
		{
			System.out.println("Listenin sonundasınız.");
			return current.song;
		}
		current = current.next;
		return current.song;
	}

	//ÖNCEKİŞARKIYA GEÇ

	public Song previous() {
		if (isEmpty()) {
			System.out.println("Çalma listesi boş.");
			return null;
		}
		if (current.prev == null)
		{
			System.out.println("Listenin başındasınız.");
			return current.song;
		}
		current = current.prev;
		return current.song;
	}

	//ŞARKIYI LİSTEDEN SİLER 

	public boolean remove(String title) {
		if (isEmpty()) {
			System.out.println("Çalma listesi boş.");
			return false;
		}
		Node n = find(title);
		if ( n== null) {
			System.out.println("Şarkı bulunamadı: " + title);
			return false;
		}

		if ( n== current) {
			current = (n.next != null) ? n.next : n.prev;
		}

		unLink(n);
		size--;

		if (isEmpty()) {
			current = null;

			System.out.println("Çalma lisetesi boşaldı.");
		}
		return true;
	}

	//ŞARKIYI VERİLEN KONUMA TAŞIR.

	public boolean move(String title, int newIndex)  {
		if (isEmpty()) {
			System.out.println("Çalma listesi boş.");
			return false;
		}
		if (newIndex < 0 || newIndex >= size) {
			System.out.println("Geçersiz konum: " + newInddex + "(0-" + (size - 1) + "arası olmalı)");
			return false;
		}
		Node n = find(title);
		if (n ==  null) {
			System.out.println("Şarkı bulunamadı: " + title);
			return false;
		}
		unLink(n);


		if (newIndex == 0) {
			n.next = head;
			if ( head!= null) 
				head.prev = n;
			head = n;
			if (tail == null) 
				tail = n;
		} else {
			Node p = head;
			for (int i = 0; i < newIndex -1; i++) 
				p = p.next;
			n.prev = p;
			n.next = p.next;
			if (p.next != null) 
				p.next.prev = n;
			else 
				tail = n;
			p.next = n;
		}
		return  true;
	}

	private void unLink(Node n) {
		if(n.prev !=  null) 
			n.prev.next = n.next;
		else
			head = n.next;
		i (n.next != null) 
			n.next.prev = n.prev;
		else
		tail = n.prev;
		n.prev = null;
		n.next = null;
	}

	private Node find (String title) {
		for (Node t= head; t!= null;  t= t.next) {
			if (t.song.getTitle().equalsIgnoreCase(title))
				return t;
		}
		return null;
	}
	public void print() {
		if (isEmpty()) {
			System.out.println("Çalma listesi boş.");
			return;
		}
		int i = 0; 
		for (Node t = head; t != null; t = t.next) {
			System.out.println((t == current ? "▶ " : " " ) + i++ + "." + t.song);
		}
	}}

			 

		
				 
			
			
	
			
	
