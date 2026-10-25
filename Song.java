
public class Song {
    private String id;
    private String title;
    private String artist;
    private int duration; // Saniye cinsinden
    private String playlistName;

    public Song(String id, String title, String artist, int duration, String playlistName) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.playlistName = playlistName;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public String getPlaylistName() { return playlistName; }
    public void setPlaylistName(String playlistName) { this.playlistName = playlistName; }

    // Dosyaya yazılacak format (Örn: 1|Glass Table Girls|The Weeknd|180|Favoriler)
    public String toFileString() {
        return id + "|" + title + "|" + artist + "|" + duration + "|" + playlistName;
    }

    // Dosyadaki satırdan nesne üreten metot
    public static Song fromFileString(String line) {
        String[] parts = line.split("\\|");
        if (parts.length >= 5) {
            return new Song(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]);
        }
        return null;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + title + " - " + artist + " (" + duration + " sn) [" + playlistName + "]";
    }
}

}
