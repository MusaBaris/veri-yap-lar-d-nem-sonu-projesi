// Proje yönergesinde 'Kullanıcının sıradaki şarkı istekleri eklenir, ilk gelen istek önce çalınır' deniyor. Bu tam olarak FIFO (First In, First Out - İlk Giren İlk Çıkar) kuralıdır.Kuyruk veri yapısını diziyle değil, bağlı liste (linked list) mantığıyla kurdum. Çünkü dizi kullansaydık boyut sınırı olurdu veya baştan eleman çıkarırken tüm diziyi O(n) sürede kaydırmak gerekirdi. Kendi yazdığım QueueNode yapısıyla hem ekleme (enqueue) hem çıkarma (dequeue) işlemlerini O(1) yani sabit zamanda yapıyoruz.
package datastructures;

import model.Song;

public class SongRequestQueue {

    // Kendi Bağlı Liste Düğüm Yapımız (Hazır kütüphane kullanılmadı)
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

    public SongRequestQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // İstek ekle (Enqueue) -> 0(1)
    public void enqueue(Song song) {
        if (song == null) return;
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

    // Sıradaki istek şarkıyı sıradan çıkar ve getir (Dequeue) ->0(1)
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

    // Sıradaki şarkıyı silmeden incele (Peek) -> 0(1)
    public Song peek() {
        if (isEmpty()) return null;
        return front.song;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("İstek kuyruğu şu anda boş.");
            return;
        }
        QueueNode temp = front;
        int index = 1;
        while (temp != null) {
            System.out.println(index + ". İstek: " + temp.song);
            temp = temp.next;
            index++;
        }
    }
}