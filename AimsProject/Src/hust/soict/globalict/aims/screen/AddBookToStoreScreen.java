package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.media.Book;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(Store store) {
        super(store);
        setTitle("Add Book to Store");
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(4, 2, 5, 5));
        center.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        center.add(new JLabel("Title:"));
        JTextField tfTitle = new JTextField();
        center.add(tfTitle);

        center.add(new JLabel("Category:"));
        JTextField tfCategory = new JTextField();
        center.add(tfCategory);

        center.add(new JLabel("Cost:"));
        JTextField tfCost = new JTextField();
        center.add(tfCost);

        center.add(new JLabel());
        JButton btnAdd = new JButton("Add Book");

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String title = tfTitle.getText();
                    String category = tfCategory.getText();
                    double cost = Double.parseDouble(tfCost.getText().isEmpty() ? "0.0" : tfCost.getText());

                    Book book = new Book(store.getSize() + 1, title, category, cost);
                    store.addMedia(book);
                    JOptionPane.showMessageDialog(null, "Added new Book Successfully!");

                    tfTitle.setText("");
                    tfCategory.setText("");
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
