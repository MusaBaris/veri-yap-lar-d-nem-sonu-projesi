// Main burada olucak
import ui.MusicPlayerUI;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
       
        SwingUtilities.invokeLater(() -> {
            MusicPlayerUI pencere = new MusicPlayerUI();
            pencere.setVisible(true); 
        });
    }
}
