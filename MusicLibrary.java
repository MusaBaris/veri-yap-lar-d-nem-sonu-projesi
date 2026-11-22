import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MusicLibrary {
    private List<Song> songs;
    private String filePath;

    public MusicLibrary(String filePath) {
        this.songs = new ArrayList<>();
        this.filePath = (filePath != null && !filePath.trim().isEmpty()) ? filePath.trim() : "arsiv.mus";
    }

    public boolean addSong(Song song) {
        if (song == null || song.getId() == null || song.getId().trim().isEmpty()) {
            return false;
        }
        if (findById(song.getId()) != null) {
            return false;
        }
        return songs.add(song);
    }

  
    public boolean deleteSong(String id) {
        Song target = findById(id);
        if (target != null) {
            target.getPlaylists().clear();
            return songs.remove(target);
        }
        return false;
    }

    public boolean updateSong(String id, String newTitle, String newArtist, int newDuration) {
        Song song = findById(id);
        if (song != null) {
            if (newTitle != null) song.setTitle(newTitle.trim());
            if (newArtist != null) song.setArtist(newArtist.trim());
            if (newDuration >= 0) song.setDuration(newDuration);
            return true;
        }
        return false;
    }

    public Song findById(String id) {
        if (id == null) return null;
        for (Song s : songs) {
            if (s.getId() != null && s.getId().equalsIgnoreCase(id.trim())) {
                return s;
            }
        }
        return null;
    }

    public List<Song> searchByTitle(String titleQuery) {
        List<Song> results = new ArrayList<>();
        if (titleQuery == null) return results;
        String q = titleQuery.toLowerCase().trim();
        for (Song s : songs) {
            if (s.getTitle() != null && s.getTitle().toLowerCase().contains(q)) {
                results.add(s);
            }
        }
        return results;
    }

    public List<Song> searchByArtist(String artistQuery) {
        List<Song> results = new ArrayList<>();
        if (artistQuery == null) return results;
        String q = artistQuery.toLowerCase().trim();
        for (Song s : songs) {
            if (s.getArtist() != null && s.getArtist().toLowerCase().contains(q)) {
                results.add(s);
            }
        }
        return results;
    }

    public List<Song> searchByPlaylist(String playlistName) {
        List<Song> results = new ArrayList<>();
        if (playlistName == null) return results;
        for (Song s : songs) {
            if (s.isInPlaylist(playlistName)) {
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

    
    public List<String> getPlaylistsContainingSong(String id) {
        Song song = findById(id);
        if (song == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(song.getPlaylists());
    }

    public void sortByTitle() {
        for (int i = 1; i < songs.size(); i++) {
            Song key = songs.get(i);
            String keyTitle = (key.getTitle() != null) ? key.getTitle() : "";
            int j = i - 1;
            while (j >= 0) {
                String currentTitle = (songs.get(j).getTitle() != null) ? songs.get(j).getTitle() : "";
                if (currentTitle.compareToIgnoreCase(keyTitle) > 0) {
                    songs.set(j + 1, songs.get(j));
                    j--;
                } else {
                    break;
                }
            }
            songs.set(j + 1, key);
        }
    }

    public void sortByArtist() {
        for (int i = 1; i < songs.size(); i++) {
            Song key = songs.get(i);
            String keyArtist = (key.getArtist() != null) ? key.getArtist() : "";
            int j = i - 1;
            while (j >= 0) {
                String currentArtist = (songs.get(j).getArtist() != null) ? songs.get(j).getArtist() : "";
                if (currentArtist.compareToIgnoreCase(keyArtist) > 0) {
                    songs.set(j + 1, songs.get(j));
                    j--;
                } else {
                    break;
                }
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
                    try {
                        Song s = Song.fromFileString(line);
                        if (s != null && findById(s.getId()) == null) {
                            songs.add(s);
                        }
                    } catch (Exception ex) {
                        System.err.println("Bozuk satır atlandı: " + line);
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
