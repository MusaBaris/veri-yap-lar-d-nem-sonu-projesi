# VY-033 - Müzik Arşivi ve Çalma Listesi Uygulaması

Okul: İnönü Üniversitesi - Mühendislik Fakültesi

Ders: Veri Yapıları

Akademik Yıl: 2026-2027

Proje Kodu: VY-033

Takım Adı: proje101

Takım Lideri: Musa Barış UĞUR

Programlama Dili: Java

Geliştirme Ortamı: Eclipse IDE / VS Code (Git & GitHub)

GitHub Deposu: https://github.com/MusaBaris/veri-yap-lar-d-nem-sonu-projesi

---

## Proje Hakkında

Bu proje, Veri Yapıları dersi kapsamında geliştirilen bir Müzik Arşivi ve Çalma Listesi Uygulamasıdır.

Amaç; temel veri yapılarını hazır koleksiyon sınıfları kullanmadan (veya proje kurallarına uygun özel düğüm/yapı sınıflarıyla) sıfırdan tasarlamak, her yapının neden seçildiğini somut bir senaryoyla göstermek ve tüm modülleri tek bir Java uygulamasında birleştirmektir.

---

## Takım Üyeleri ve Görev Dağılımı

Musa Barış UĞUR (02250201072) - Takım Lideri: Çalma Geçmişi (Stack / Yığın), Ortak Song Modeli, Ana Uygulama & Entegrasyon, Arayüz (UI)

Melike GÖK (02240201158): Çalma Listesi Yönetimi (Doubly Linked List / Çift Yönlü Bağlı Liste)

Şevval Aksa İŞERİ (02230201041): Şarkı Arama ve Sıralama (Binary Search Tree - BST / İkili Arama Ağacı)

Şeyda BOZTEPE (02240201262): Çalma Sırası / Bekleme Listesi (Hybrid Queue / Hibrit Kuyruk: FIFO + LIFO)

---

## Modül Detayları ve Veri Yapısı Gerekçeleri

### 1. Çalma Listesi Yönetimi - Çift Yönlü Bağlı Liste (Doubly Linked List)

Sorumlu: Melike GÖK

Bu modül, çalma listesindeki şarkıların dinamik olarak yönetilmesinden ve kullanıcıların liste içinde iki yönde rahatça gezinebilmesinden sorumludur.

Düğüm (Node) Yapısı: Her düğüm üç temel alana sahiptir:

- prev: Önceki düğümün referansını tutar.

- data: Düğümde saklanan şarkı (Song) verisini tutar.

- next: Sonraki düğümün referansını tutar.

Çalışma İlkesi:

null <- [Şarkı A] <-> [Şarkı B] <-> [Şarkı C] -> null

- İlk düğümün prev değeri null olur, son düğümün next değeri null olur.

- Aradaki düğümlerin hem prev hem de next bağlantısına sahiptir.

Temel Özellikler:

- Önceki şarkıya geçiş: Mevcut düğümün prev bağlantısı kullanılır.

- Sonraki şarkıya geçiş: Mevcut düğümün next bağlantısı kullanılır.

- Şarkı silme: Silinen düğümün prev ve next bağlantıları birbirine bağlanarak düğüm listeden çıkarılır.

- Sıra değiştirme: Düğümlerin işaretçi bağlantıları güncellenerek şarkıların listedeki yeri değiştirilir.

- Boş liste kontrolü: Liste boşsa işlem yapılmaz ve kullanıcıya bilgilendirici mesaj verilir.

Neden Çift Yönlü Bağlı Liste?

Tek yönlü listede bir önceki şarkıya dönmek için baştan tarama gerekirken, çift yönlü bağlı listede prev referansı sayesinde önceki şarkıya doğrudan geçilir ve silme/taşıma işlemleri kolaylaşır.

Dinamik bellek kullanımı sayesinde liste boyutu çalışma zamanında esnek şekilde büyüyüp küçülür; Java'da erişilemeyen nesneler Garbage Collector tarafından temizlenir.

---

### 2. Çalma Sırası / Bekleme Listesi - Hibrit Kuyruk (FIFO + LIFO)

Sorumlu: Şeyda BOZTEPE

Kullanıcının anlık olarak dinleme sırasına eklediği parçaların geçici olarak tutulmasından sorumludur.

Hazır Java koleksiyonları kullanılmadan, özel Tek Yönlü Bağlı Liste (QueueNode) altyapısıyla geliştirilir.

Çalışma İlkesi ve Tercih Nedeni (Hibrit Model: FIFO + LIFO):

- FIFO (First-In, First-Out): Standart şarkı istekleri kuyruğun sonuna eklenir (enqueue) ve ilk eklenen şarkı sırası geldiğinde kuyruğun başından çıkarılarak çalınır (dequeue).

- LIFO (Last-In, First-Out): "Sırada Çal / Play Next" özelliği ile acil/öncelikli seçilen parçalar kuyruğun doğrudan en önüne (front) eklenir; böylece son eklenen öncelikli parça ilk sıraya geçerek hemen çalınır.

Temel İşlemler ve Karmaşıklık:

- Ekleme (enqueue, playNext), çıkarma (dequeue) ve sıradaki parçaya bakma (peek) işlemleri O(1) sürede tamamlanır.

- Kuyrukta şarkı arama (contains) işlemi O(n) sürede çalışır.

---

### 3. Şarkı Arama ve Sıralama - İkili Arama Ağacı (Binary Search Tree - BST)

Sorumlu: Şevval Aksa İŞERİ

Müzik arşivindeki şarkıların düzenli tutulması, hızlı aranması ve sıralı listelenmesinden sorumludur.

Çalışma İlkesi:

Her düğüm bir şarkıyı temsil eder ve belirlenen anahtar alana (örneğin şarkı adı) göre sol alt ağaçta daha küçük/önceki değerler, sağ alt ağaçta daha büyük/sonraki değerler yer alır.

Temel Özellikler:

- Arşive yeni şarkı ekleme.

- Şarkı adına göre arama yapma.

- Ağaç gezintileri (örneğin In-order traversal) ile şarkıları sıralı şekilde görüntüleme.

Neden İkili Arama Ağacı (BST)?

Sırasız bir listede arama yapmak doğrusal zamanda sürerken, dengeli bir BST yapısında arama ve ekleme işlemleri ortalama O(log n) seviyesinde gerçekleşir ve in-order dolaşım doğal olarak sıralı çıktı üretir.

---

### 4. Çalma Geçmişi (Stack), Ortak Model, Entegrasyon ve UI

Sorumlu: Musa Barış UĞUR (Takım Lideri)

Modüller arası veri bütünlüğünü sağlamak, çalma geçmişini tutmak ve kullanıcıya tek bir bütünleşik uygulama sunmakla sorumludur.

Çalma Geçmişi - Yığın (Stack - LIFO):

Çalınan şarkılar yığına eklenir (push). Kullanıcı "Geçmiş / Önceki Çalınan" özelliğini kullandığında en son çalınan şarkı yığından çıkarılır (pop). Son çalınan şarkıya ilk ulaşma ihtiyacı LIFO mantığıyla birebir örtüşür.

Ortak Song Modeli ve Entegrasyon:

Tüm modüllerin (Çalma Listesi, Kuyruk, BST, Geçmiş) ortak kullanacağı Song sınıfını tanımlar, modüller arası geçişleri (örneğin arşivden çalma listesine/kuyruğa aktarım, şarkı çalındığında geçmişe ve kuyruğa/listeye yansıması) koordine eder.

Kullanıcı Arayüzü (UI) ve Depo Yönetimi:

Uygulamanın ana çalıştırılabilir giriş noktasını ve kullanıcı arayüzünü oluşturur; GitHub deposundaki entegrasyon, sürüm düzeni ve teslim bütünlüğünden sorumludur.

---

## Teknik Bilgiler

Dil: Java

Geliştirme Ortamı: Eclipse IDE (veya VS Code)

Sürüm Kontrolü: Git & GitHub

Bellek Yönetimi: Dinamik düğüm/nesne oluşturma ve Java Garbage Collector
