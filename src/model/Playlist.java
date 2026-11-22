public class Playlist {
private class Node {
  Song data;
  Node next;

  Node (Song data) {
    this.data = data;
  }
}
  private Node head;
  private Node current;
