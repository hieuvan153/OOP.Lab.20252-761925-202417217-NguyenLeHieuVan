package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.media.CompactDisc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add CD to store");
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6, 2, 5, 5));
        center.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        center.add(new JLabel("Title: "));
        JTextField tfTitle = new JTextField();
        center.add(tfTitle);

        center.add(new JLabel("Category: "));
        JTextField tfCategory = new JTextField();
        center.add(tfCategory);

        center.add(new JLabel("Director: "));
        JTextField tfDirector = new JTextField();
        center.add(tfDirector);

        center.add(new JLabel("Artist: "));
        JTextField tfArtist = new JTextField();
        center.add(tfArtist);

        center.add(new JLabel("Cost: "));
        JTextField tfCost = new JTextField();
        center.add(tfCost);

        center.add(new JLabel());
        JButton btnAdd = new JButton("Add CD: ");

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String title = tfTitle.getText();
                    String category = tfCategory.getText();
                    String director = tfDirector.getText();
                    String artist = tfArtist.getText();
                    double cost = Double.parseDouble(tfCost.getText().isEmpty() ? "0.0" : tfCost.getText());

                    CompactDisc cd = new CompactDisc(store.getSize() + 1, title, category, director, artist, cost);
                    store.addMedia(cd);
                    JOptionPane.showMessageDialog(AddCompactDiscToStoreScreen.this, "Added new CD successfully");

                    tfTitle.setText("");
                    tfCategory.setText("");
                    tfDirector.setText("");
                    tfArtist.setText("");
                    tfCost.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        center.add(btnAdd);

        return center;
    }
}
