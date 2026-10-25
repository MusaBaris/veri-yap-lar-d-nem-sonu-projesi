// Henüz arayüz yazılmadığı için yazdığım sınıfı test etmek amacıyla bağımsız bir test sınıfı kurdum. İki şarkıyı kuyruğa ekledim (enqueue), boyutun arttığını doğruladım, sıradaki şarkıyı inceledim (peek), sonra şarkıyı sıradan çıkararak (dequeue) FIFO kuralının çalıştığını test ettim.
import datastructures.SongRequestQueue;
import model.Song;

public class QueueText {
    public static void main(String[] args) {
        System.out.println("=== Şarkı İstek Kuyruğu (Queue) Test Başlıyor ===");

        SongRequestQueue requestQueue = new SongRequestQueue();

        Song s1 = new Song(1, "Bohemian Rhapsody", "Queen", 354);
        Song s2 = new Song(2, "Hotel California", "Eagles", 390);

        System.out.println("Kuyruk boş mu? " + requestQueue.isEmpty());

        requestQueue.enqueue(s1);
        requestQueue.enqueue(s2);
        System.out.println("Eklenen istek sayısı: " + requestQueue.getSize());
        requestQueue.printQueue();

        System.out.println("\nSıradaki istek şarkı (Peek): " + requestQueue.peek().getTitle());
        System.out.println("Çalınan şarkı (Dequeue): " + requestQueue.dequeue().getTitle());
        System.out.println("Kalan istek sayısı: " + requestQueue.getSize());
    }
}