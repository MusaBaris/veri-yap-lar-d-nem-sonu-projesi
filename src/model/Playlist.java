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
