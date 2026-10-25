# 🎵 SoundWave - Java Müzik Çalar Uygulaması

Bu proje, Veri Yapıları dersi kapsamında geliştirilen; özel veri yapısı implementasyonlarını (Bağlı Liste, Yığın, Kuyruk, İkili Arama Ağacı) temel alan, Java Swing tabanlı bir masaüstü müzik çalar ve arşiv yöneticisidir.

---

## 👥 Ekip Üyeleri ve İş Bölümü:
 | Adı  | Üstlendiği Görev & Veri Yapısı |

 
 | :--- | :--- | :--- |

 
 | Musa Barış | **Ana Uygulama & Entegrasyon, UI, Çift Yönlü Dairesel Bağlı Liste** |

 
 | Melike     | **Çalma Geçmişi (History) - Yığın (Stack)** |

 
 | Şeyda      | **Çalma Sırası (Queue/Up Next) - Kuyruk (Queue)** | 

 
 | Şevval     | **Şarkı Arama ve Sıralama - İkili Arama Ağacı (BST)** | 
 

---
## 🛠️ Kullanılan Teknolojiler 

* **Dil:** Java 
* **Arayüz:** Java Swing
---
## 📌 Kullanılan Veri Yapıları, İşlevleri ve Tercih Nedenleri

### 1. Çift Yönlü Dairesel Bağlı Liste (Circular Doubly Linked List) - Çalma Listesi
* **Kullanım Yeri:** Aktif çalma listesindeki şarkıların tutulması, bir sonraki/önceki şarkıya geçiş.
* **Tercih Nedeni:** Müzik çalarlarda *"Sonraki Şarkı"* ve *"Önceki Şarkı"* geçişlerinin $O(1)$ sürede yapılması gerekir. Çift yönlü (`prev` ve `next`) işaretçiler çift yönlü geçişi sağlar. Listenin sonuna gelindiğinde başa, başındayken geriye basıldığında sona dönebilmesi için dairesel (circular) bağlantı tercih edilmiştir.

### 2. Yığın (Stack) - Çalma Geçmişi (Playback History)
* **Kullanım Yeri:** Kullanıcının dinlediği şarkıların sırasıyla kaydedilmesi.
* **Tercih Nedeni:** LIFO (Last-In-First-Out / Son Giren İlk Çıkar) prensibiyle çalışır. Kullanıcı "En son hangi şarkıyı dinledim?" dediğinde en son çalınan şarkıya $O(1)$ sürede erişilir.

### 3. Kuyruk (Queue) - Çalma Sırası / Bekleme Listesi (Up Next)
* **Kullanım Yeri:** Kullanıcının "Sıraya Ekle" dediği parçaların geçici olarak bekletilmesi.
* **Tercih Nedeni:** FIFO (First-In-First-Out / İlk Giren İlk Çıkar) prensibine dayanır. İlk sıraya eklenen şarkı, mevcut parça bittiğinde ilk çalacak parçadır. $O(1)$ kuyruğa alma (`enqueue`) ve çıkarma (`dequeue`) imkanı sunar.

### 4. İkili Arama Ağacı (Binary Search Tree - BST) - Şarkı Arama ve Arşiv
* **Kullanım Yeri:** Şarkı adına göre arşivde hızlı arama yapma ve alfabetik listeleme.
* **Tercih Nedeni:** Düzensiz bir listede arama $O(N)$ iken, dengeli bir BST üzerinde şarkı aramak ortalama $O(\log N)$ sürede gerçekleşir. Ayrıca In-order traversal yapılarak kütüphanedeki tüm şarkılar alfabetik olarak sıralı şekilde ekrana basılabilir.

---
## 📐 Temel Düğüm ve Sınıf Yapısı (Sınıf Taslağı)

```text
+-------------------------------------------------------------+
|                            Song                             |
+-------------------------------------------------------------+
| - title: String                                             |
| - artist: String                                            |
| - durationSeconds: int                                      |
+-------------------------------------------------------------+

[CircularDoublyLinkedList]         [SongStack]
       |                                |
       v                                v
+------------------+             +---------------+
|    SongNode      |             |   StackNode   |
+------------------+             +---------------+
| - data: Song     |             | - data: Song  |
| - next: SongNode |             | - next: Node  |
| - prev: SongNode |             +---------------+
+------------------+
                                   [BSTree]
[SongQueue]                           |
       |                              v
       v                         +---------------+
+------------------+             |    BSTNode    |
|    QueueNode     |             +---------------+
| - data: Song     |             | - data: Song  |
| - next: Node     |             | - left: Node  |
+------------------+             | - right: Node |
                                 +---------------+
