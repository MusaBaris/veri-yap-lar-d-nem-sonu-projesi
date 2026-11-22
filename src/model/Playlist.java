//Geçen hafta double linked list kullanarak yapmıştık. Ama sonra dedik ki tek yönlü listeyle yapalım az şarkı olacağı için işimizi daha iyi görür ve az yer kaplar

public class Playlist {
private class Node {
  Song data;
  Node next;

  Node (Song data) {
    this.data = data;
  }
}
  private Node head;   //listemizizin ilk düğümü
  private Node current;  //şu an çalan şarkı 

public void add (Song song ) {
  Node newNode  = new Node (song);
  if (head == null) {
    head = newNode;
    current = newNode; }
  else {
    Node temp = head;
    while ( temp.next != null) {
      temp = temp.next;
    }
    temp.next = newNode;
  }
}
//Sonraki şarkıya geçelim.
  public Song next() {
    if (head == null ) {
      System.out.println("Çalma listeniz boş.");
      return null;
    }
    if (current.next == null) {
      System.out.println("Listenin sonundasınız, sonraki şarkı yok.");
      return current.data;
    }
    current = current.next;
    return current.data;
  }
//Önceki şarkıya geçelim.
  public Song previous() {
    if (head == null)  {
      System.out.println("Çalma listeniz boş.");
      return null;
    }
    if (current == head) {
      System.out.println("Listenin başındasınız , önceki şarkı yok.");
      return current.data;
    }
    Node temp = head;
    while ( temp.next != current ) {
      temp = temp.next;
    }
    current = temp;
    return current.data;
  }
  //ID'ye göre şarkı silelim.
  public boolean remove (int id) {
    if ( head == null) {
      System.out.println("Çalma listeniz boş.");
      return false;
    }

    //Silinecek düğümü ve onun öncesini bulalım .
    Node prev = null;
    Node temp = head;
    while (temp != null && temp.data getID() != id) {
      prev = temp;
      temp = temp.next;
    }
    if (temp == null {
      System.out.println("Şarkı bulunamadı.");
      return false;
    }
    
      
}
    
