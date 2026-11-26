
package datastructures;

import model.Song;

public class HistoryStack {

    // --- MUSA BARIŞ DOLDURACAK: Yığın düğüm yapısı ---
    private static class Node {
        Song song;
        Node next;

        Node(Song song, Node next) {
            this.song = song;
            this.next = next;
        }
    }

    private Node top;
    private int size;

    public HistoryStack() {
        this.top = null;
        this.size = 0;
    }

    // --- MUSA BARIŞ DOLDURACAK: Çalınan şarkıyı yığının en üstüne ekle (LIFO - push) ---
    public void push(Song song) {
        if (song == null) {
            return;
        }
        top = new Node(song, top);
        size++;
    }

    // --- MUSA BARIŞ DOLDURACAK: En son çalınan şarkıyı yığından çıkar ve döndür (pop) ---
    public Song pop() {
        if (isEmpty()) {
            return null;
        }
        Song removed = top.song;
        top = top.next;
        size--;
        return removed;
    }

    // --- MUSA BARIŞ DOLDURACAK: En son çalınan şarkıyı silmeden görüntüle (peek) ---
    public Song peek() {
        if (isEmpty()) {
            return null;
        }
        return top.song;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    // --- MUSA BARIŞ DOLDURACAK: Geçmişi son çalınandan ilk çalınana doğru listele ---
    public void printHistory() {
        if (isEmpty()) {
            System.out.println("Çalma geçmişi şu an boş.");
            return;
        }
        System.out.println("=== Çalma Geçmişi (En Son Çalınan Üstte) ===");
        Node current = top;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.song);
            current = current.next;
            index++;
        }
    }
}