package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Media media;
    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if(media instanceof Playable) {
            JButton playButton = new JButton("Play");

            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JDialog dialog = new JDialog();
                    dialog.setTitle("Play Media");
                    dialog.setSize(300, 150);
                    dialog.setLayout(new BorderLayout());
                    JLabel playingLabel = new JLabel("Playing: " + media.getTitle(), SwingConstants.CENTER);
                    playingLabel.setFont(new Font("Arial", Font.BOLD, 16));
                    dialog.add(playingLabel, BorderLayout.CENTER);
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                }
            });

            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this. setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
