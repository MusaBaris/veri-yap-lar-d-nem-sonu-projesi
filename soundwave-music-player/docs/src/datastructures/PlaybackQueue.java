// Dinleme sırası için (Şeyda)
package datastructures;

import model.Song;

public class PlaybackQueue {

    private static class QueueNode {
        Song song;
        QueueNode next;

        public QueueNode(Song song) {
            this.song = song;
            this.next = null;
        }
    }

    private QueueNode front;
    private QueueNode rear;
    private int size;

    public PlaybackQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Standart Kuyruğa Ekleme (Sona Ekle - FIFO): İlk giren ilk çalar
    public void enqueue(Song song) {
        if (song == null) return ;
        QueueNode newNode = new QueueNode(song);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Sırada Çal / Başa Ekle (LIFO): Son giren ilk çalar
    public void playNext(Song song) {
        if (song == null) return;
        QueueNode newNode = new QueueNode(song);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.next = front;
            front = newNode;
        }
        size++;
    }

    // Sıradaki şarkıyı çal ve çıkar -> 0(1)
    public Song dequeue() {
        if (isEmpty()) return null;
        Song songToPlay = front.song;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return songToPlay;
    }

    // Sıradaki parçaya silmeden bakma -> 0(1)
    public Song peek() {
        if (isEmpty()) return null;
        return front.song;
    }

    // 
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean contains(int songId) {
        QueueNode current = front;
        while (current != null) {
            if (current.song.getId() == songId) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Çalma sırası boş.");
            return ;
        }
        QueueNode temp = front;
        int index = 1;
        while (temp != null) {
            System.out.println(index + ".Sırada: " + temp.song);
            temp = temp.next;
            index++;
        }
    }
}
