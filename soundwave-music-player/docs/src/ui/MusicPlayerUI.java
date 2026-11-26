// Ana pencere burada olucak
package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MusicPlayerUI extends JFrame {

    public MusicPlayerUI() {
        // Pencere başlığı
        setTitle("Müzik Çalar Uygulaması");

        // Pencere boyutu (Genişlik, Yükseklik)
        setSize(400, 250);

        // Çarpı tuşuna basınca programın tamamen kapanmasını sağlar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Pencereyi ekranın tam ortasında açar
        setLocationRelativeTo(null);

        // İçerideki yazı etiketi
        JLabel label = new JLabel("Burada müzik çalar arayüzü olacak...", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 16));

        // Yazıyı pencereye ekliyoruz
        add(label);
    }
}
