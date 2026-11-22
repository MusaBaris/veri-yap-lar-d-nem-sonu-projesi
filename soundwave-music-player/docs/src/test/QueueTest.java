// Queue testi için
package test;

import datastructures.PlaybackQueue;
import model.Song;

public class QueueTest {
    public static void main(String[] args) {
        System.out.println("=== PlaybackQueue Test Başlıyor ===");

        PlaybackQueue queue = new PlaybackQueue();

        Song s1 = new Song(1, "Bohemian Rhapsody", "Queen", 354);
        Song s2 = new Song(2, "Hotel California", "Eagles", 390);
        Song s3 = new Song(3, "Shape of You", "Ed Sheeran", 233);

        // 1.Standart ekleme (FIFO)
        queue.enqueue(s1);
        queue.enqueue(s2);
        System.out.println("Normal eklemeler yapıldı (s1, s2):");
        queue.printQueue();

        // 2.LIFO testi: En son eklenen s3 başa geçmeli
        System.out.println("\n--- 'Sırada çal' (playNext -LIFO) Testi ---");
        queue.playNext(s3);
        queue.PlayQueue();

        // İlk çıkacak şarkıya bakıyoruz (s3 olmalı)
        System.out.println("\nİlk çalacak şarkı(Peek): " + queue.peek().getTitle());
        System.out.println("Çalınan şarkı (Dequeue): " + queue.dequeue().getTitle());

        // 3. Arama ve Temizleme
        System.out.println("\nID 2 sırada var mı? " + queue.contains(2));
        queue.clear();
        System.out.println("Temizlendikten sonra sıra boş mu? " + queue.isEmpty());
    }
}
