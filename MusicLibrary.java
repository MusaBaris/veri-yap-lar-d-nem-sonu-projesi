
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MusicLibrary {
    private List<Song> songs;
    private String filePath;

    public MusicLibrary(String filePath) {
        this.songs = new ArrayList<>();
        this.filePath = (filePath != null && !filePath.isEmpty()) ? filePath : "arsiv.mus";
    }

    

    public boolean addSong(Song song) {
        if (song == null || findById(song.getId()) != null) {
            return false;
        }
        return songs.add(song);
    }

    public boolean deleteSong(String id) {
        Song target = findById(id);
        if (target != null) {
            return songs.remove(target);
        }
        return false;
    }

    public boolean updateSong(String id, String newTitle, String newArtist, int newDuration, String newPlaylist) {
        Song song = findById(id);
        if (song != null) {
            song.setTitle(newTitle);
            song.setArtist(newArtist);
            song.setDuration(newDuration);
            song.setPlaylistName(newPlaylist);
            return true;
        }
        return false;
    }

    public Song findById(String id) {
        for (Song s : songs) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public List<Song> searchByTitle(String titleQuery) {
        List<Song> results = new ArrayList<>();
        for (Song s : songs) {
            if (s.getTitle().toLowerCase().contains(titleQuery.toLowerCase())) {
                results.add(s);
            }
        }
        return results;
    }

    public List<Song> searchByArtist(String artistQuery) {
        List<Song> results = new ArrayList<>();
        for (Song s : songs) {
            if (s.getArtist().toLowerCase().contains(artistQuery.toLowerCase())) {
                results.add(s);
            }
        }
        return results;
    }

    public List<Song> searchByPlaylist(String playlistName) {
        List<Song> results = new ArrayList<>();
        for (Song s : songs) {
            if (s.getPlaylistName().equalsIgnoreCase(playlistName)) {
                results.add(s);
            }
        }
        return results;
    }

    public List<Song> searchByMaxDuration(int maxDuration) {
        List<Song> results = new ArrayList<>();
        for (Song s : songs) {
            if (s.getDuration() <= maxDuration) {
                results.add(s);
            }
        }
        return results;
    }

  

    public void sortByTitle() {
        for (int i = 1; i < songs.size(); i++) {
            Song key = songs.get(i);
            int j = i - 1;
            while (j >= 0 && songs.get(j).getTitle().compareToIgnoreCase(key.getTitle()) > 0) {
                songs.set(j + 1, songs.get(j));
                j--;
            }
            songs.set(j + 1, key);
        }
    }

    public void sortByArtist() {
        for (int i = 1; i < songs.size(); i++) {
            Song key = songs.get(i);
            int j = i - 1;
            while (j >= 0 && songs.get(j).getArtist().compareToIgnoreCase(key.getArtist()) > 0) {
                songs.set(j + 1, songs.get(j));
                j--;
            }
            songs.set(j + 1, key);
        }
    }

    public void sortByDuration() {
        for (int i = 1; i < songs.size(); i++) {
            Song key = songs.get(i);
            int j = i - 1;
            while (j >= 0 && songs.get(j).getDuration() > key.getDuration()) {
                songs.set(j + 1, songs.get(j));
                j--;
            }
            songs.set(j + 1, key);
        }
    }


    public void loadFromFile() {
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }

        songs.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    Song s = Song.fromFileString(line);
                    if (s != null) {
                        songs.add(s);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Dosya okuma hatası: " + e.getMessage());
        }
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
            for (Song s : songs) {
                writer.write(s.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Dosya kaydetme hatası: " + e.getMessage());
        }
    }

    public List<Song> getAllSongs() {
        return songs;
    }
}

}
