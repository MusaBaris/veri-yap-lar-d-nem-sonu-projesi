public class Main {
  public static void main(String[] args) {
    Playlist p1 = new Playlist();
    pl.add(new Song("Şarkı A " , "Sanatçı 1" , 200));
    pl.add(new Song("Şarkı B" , "Sanatçı 2" , 185));
    pl.add(new Song("Şarkı C" , "Sanatçı 3" , 220));
    pl.add(new Song("Şarkı D" , "Sanatçı 4" , 240));

  Scanner   sc = new Scanner(System.in);
    while (true) {
      System.out.println("\n--- Çalma Liatesi ---");
      pl.print();
      System.out.println("\n1) Sonraki 2) Önceki 3) Sil 4) Taşı 0) Çıkış");

      System.out.print("Seçim: ");
      String secim = sc.nextLine().trim();

      switch (secim) {
        case "1":
          Song s = pl.next();
          if ( s!= null) 
            System.out.println("Çalıyor: " + s);
          break;
        case "2":
          Song p = pl.previous();
          if ( p != null) 
            System.out.println("Çalıyor: " + p);
          break;
        case "3":
          System.out.print("Silinecek şarkı adı: " );
          p1.remove(sc.nextLine().trim());
          break;
        case "4":
          System.out.print("Taşınacak şarkı adı: ");
          String ad = sc.nextLine().trim();
          System.out.print("Yeni konum ( 0 tabanlı) : ");
          try {
            pl.move( ad, Integer.parseInt(sc.nextLine():trim()));
          }
          catch 
            (NumberFormatException e) {
              System.out.println("Lütfen sayı girin.");
            }
          break;
        case "0":
          return;
        default:
          System.out.println("Geçersiz seçim.");
      }
    }
  }
}

          
                
        
