import java.util.ArrayList;
import java.util.List;

public class Song {
    private String id;
    private String title;
    private String artist;
    private int duration;
    private List<String> playlists;

    public Song(String id, String title, String artist, int duration) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.playlists = new ArrayList<>();
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public List<String> getPlaylists() { return playlists; }

    public void addPlaylist(String playlistName) {
        if (playlistName != null && !playlistName.trim().isEmpty()) {
            for (String p : playlists) {
                if (p.equalsIgnoreCase(playlistName.trim())) {
                    return;
                }
            }
            playlists.add(playlistName.trim());
        }
    }

    public void removePlaylist(String playlistName) {
        if (playlistName != null) {
            playlists.removeIf(p -> p.equalsIgnoreCase(playlistName.trim()));
        }
    }

    public boolean isInPlaylist(String playlistName) {
        if (playlistName == null) return false;
        for (String p : playlists) {
            if (p.equalsIgnoreCase(playlistName.trim())) {
                return true;
            }
        }
        return false;
    }

    public String toFileString() {
        String joinedLists = String.join(",", playlists);
        return id + "|" + title + "|" + artist + "|" + duration + "|" + joinedLists;
    }

    public static Song fromFileString(String line) {
        if (line == null || line.trim().isEmpty()) return null;
        String[] parts = line.split("\\|", -1);
        if (parts.length >= 4) {
            try {
                int parsedDuration = Integer.parseInt(parts[3].trim());
                Song song = new Song(parts[0].trim(), parts[1].trim(), parts[2].trim(), parsedDuration);
                if (parts.length >= 5 && !parts[4].trim().isEmpty()) {
                    String[] listNames = parts[4].split(",");
                    for (String name : listNames) {
                        song.addPlaylist(name);
                    }
                }
                return song;
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }

    public String toString() {
        String listInfo = playlists.isEmpty() ? "Liste Yok" : String.join(", ", playlists);
        return "[" + id + "] " + title + " - " + artist + " (" + duration + " sn) [" + listInfo + "]";
    }
}
