// Sistemde yöneteceğimiz temel varlık şarkıdır. Bir şarkının adı, sanatçısı, süresi ve id'si gibi niteliklerini tek bir nesne (Object) altında toplamak için bu modeli yazdık.
package model;

public class Song {
    private int id;
    private String title;
    private String artist;
    private int durationInSeconds;

    public Song(int id, String title, String artist, int durationInSeconds) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.durationInSeconds = durationInSeconds;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    @Override 
    public String toString() {
        int minutes = durationInSeconds / 60;
        int seconds = durationInSeconds % 60;
        return String.format("[%d] %s - %s (%02d:%02d)", id, artist, title, minutes, seconds);
    }
}