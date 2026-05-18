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
                    dialog.setTitle("Media Player");
                    dialog.setSize(400, 350);
                    dialog.setLayout(new BorderLayout(10, 10));
                    dialog.setLocationRelativeTo(null);

                    JLabel playingLabel = new JLabel("Now Playing: " + media.getTitle(), SwingConstants.CENTER);
                    playingLabel.setFont(new Font("Arial", Font.BOLD, 20));
                    playingLabel.setForeground(new Color(0, 102, 204));
                    dialog.add(playingLabel, BorderLayout.NORTH);

                    JPanel centerPanel = new JPanel();

                    if (media instanceof hust.soict.globalict.aims.media.CompactDisc) {
                        hust.soict.globalict.aims.media.CompactDisc cd = (hust.soict.globalict.aims.media.CompactDisc) media;
                        java.util.ArrayList<hust.soict.globalict.aims.media.Track> tracks = cd.getTracks();

                        if (tracks != null && !tracks.isEmpty()) {
                            centerPanel.setLayout(new GridLayout(0, 1, 5, 5));
                            centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                            for (hust.soict.globalict.aims.media.Track track : tracks) {
                                JPanel trackBox = new JPanel(new BorderLayout());
                                trackBox.setBorder(BorderFactory.createCompoundBorder(
                                        BorderFactory.createLineBorder(Color.GRAY, 1), // Viền của ô
                                        BorderFactory.createEmptyBorder(10, 10, 10, 10) // Khoảng cách bên trong ô
                                ));
                                trackBox.setBackground(Color.WHITE);

                                JLabel trackTitle = new JLabel("🎵 Track: " + track.getTitle());
                                trackTitle.setFont(new Font("Arial", Font.BOLD, 14));

                                JLabel trackLength = new JLabel("Length: " + track.getLength() + "s");

                                trackBox.add(trackTitle, BorderLayout.WEST);
                                trackBox.add(trackLength, BorderLayout.EAST);

                                centerPanel.add(trackBox);
                            }
                        } else {
                            centerPanel.add(new JLabel("No tracks available in this CD."));
                        }
                    }
                    else if (media instanceof hust.soict.globalict.aims.media.DigitalVideoDisc) {
                        centerPanel.setLayout(new GridBagLayout());
                        hust.soict.globalict.aims.media.DigitalVideoDisc dvd = (hust.soict.globalict.aims.media.DigitalVideoDisc) media;
                        JLabel dvdLabel = new JLabel("DVD Length: " + dvd.getLength() + " seconds");
                        dvdLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                        centerPanel.add(dvdLabel);
                    }

                    JScrollPane scrollPane = new JScrollPane(centerPanel);
                    scrollPane.setBorder(null);
                    dialog.add(scrollPane, BorderLayout.CENTER);

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
